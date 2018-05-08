package com.poc.services;

import javax.xml.bind.JAXBElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import com.poc.services.soap.AcompanharPedidoPorData;
import com.poc.services.soap.AcompanharPedidoPorDataResponse;
import com.poc.services.soap.ObjectFactory;

@Component
public class TrackerClient extends WebServiceGatewaySupport {

	private final long SEGUNDO = 1000;
	private final long MINUTO = 60 * SEGUNDO;

	private static final Logger log = LoggerFactory.getLogger(TrackerClient.class);

	@Value("${userName}")
	private String userName;

	@Value("${userPassword}")
	private String userPassword;

	//@Scheduled(fixedRate = SEGUNDO * 100)
	@SuppressWarnings("unchecked")
	public JAXBElement<AcompanharPedidoPorDataResponse> getProductStatus() {
		log.info("scheduler rodando...");

		AcompanharPedidoPorData acompanharPedidoPorData = new AcompanharPedidoPorData();
		acompanharPedidoPorData.setCodAdministrativo("17000190");
		acompanharPedidoPorData.setData("07/05/2018");
		acompanharPedidoPorData.setTipoSolicitacao("A");
		
		JAXBElement<AcompanharPedidoPorData> element = new ObjectFactory().createAcompanharPedidoPorData(acompanharPedidoPorData);
		
		return (JAXBElement<AcompanharPedidoPorDataResponse>) getWebServiceTemplate().marshalSendAndReceive(element);
	}


}
