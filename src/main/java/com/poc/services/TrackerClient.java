package com.poc.services;

import javax.xml.soap.MessageFactory;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import com.poc.services.soap.AcompanharPedidoPorData;
import com.poc.services.soap.AcompanharPedidoPorDataResponse;

@Component
public class TrackerClient extends WebServiceGatewaySupport {

	private final long SEGUNDO = 1000;
	private final long MINUTO = 60 * SEGUNDO;

	private static final Logger log = LoggerFactory.getLogger(TrackerClient.class);

	@Value("${urlApi}")
	private String urlApi;

	@Value("${userName}")
	private String userName;

	@Value("${userPassword}")
	private String userPassword;

	@Scheduled(fixedRate = SEGUNDO * 20)
	public void getProductStatus() {
		log.info("scheduler rodando...");

		AcompanharPedidoPorDataResponse result = symbolicSwap("08082650", "A", "20/07/2015");
		System.out.println(result);
	}

	public AcompanharPedidoPorDataResponse symbolicSwap(String codAdministrativo, String tipoSolicitacao, String data) {

		AcompanharPedidoPorData apd = new AcompanharPedidoPorData();
		apd.setCodAdministrativo(codAdministrativo);
		apd.setTipoSolicitacao(tipoSolicitacao);
		apd.setData(data);

		try {
			SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory(MessageFactory.newInstance());
			messageFactory.afterPropertiesSet();

			WebServiceTemplate webServiceTemplate = webServiceTemplate();
//			Jaxb2Marshaller marshaller = jaxb2Marshaller();

//			marshaller.setContextPath("com.poc.services.soap");
//			marshaller.afterPropertiesSet();
//			webServiceTemplate.setMarshaller(marshaller);
//			webServiceTemplate.afterPropertiesSet();

			return (AcompanharPedidoPorDataResponse) webServiceTemplate.marshalSendAndReceive(this.urlApi, apd,
					webServiceMessage -> ((SoapMessage) webServiceMessage)
							.setSoapAction("logisticaReversaService/AcompanharPedidoPorData"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	 @Bean
	  Jaxb2Marshaller jaxb2Marshaller() {
	    Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
	    jaxb2Marshaller.setContextPath("com.poc.services.soap");
	    
	    return jaxb2Marshaller;
	  }

	  @Bean
	  public WebServiceTemplate webServiceTemplate() {
	    WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
	    webServiceTemplate.setMarshaller(jaxb2Marshaller());
	    webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
	    webServiceTemplate.setDefaultUri(urlApi);
	    // set a HttpComponentsMessageSender which provides support for basic authentication
	    webServiceTemplate.setMessageSender(httpComponentsMessageSender());

	    return webServiceTemplate;
	  }

	  @Bean
	  public HttpComponentsMessageSender httpComponentsMessageSender() {
	    HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
	    // set the basic authorization credentials
	    httpComponentsMessageSender.setCredentials(usernamePasswordCredentials());

	    return httpComponentsMessageSender;
	  }

	  @Bean
	  public UsernamePasswordCredentials usernamePasswordCredentials() {
	    return new UsernamePasswordCredentials("empresacws", "123456");
	  }

}
