package com.poc.config;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import com.poc.services.TrackerClient;

@Configuration
public class SoapConfig {
	
	@Value("${urlApi}")
	private String urlApi;

	@Bean
	Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPath("com.poc.services.soap");

		return jaxb2Marshaller;
	}

	@Bean
	public TrackerClient trackerClient() {

		TrackerClient trackerClient = new TrackerClient();

		trackerClient.setMarshaller(jaxb2Marshaller());
		trackerClient.setUnmarshaller(jaxb2Marshaller());
		trackerClient.setDefaultUri(urlApi);
		trackerClient.setMessageSender(httpComponentsMessageSender());

		return trackerClient;
	}

	@Bean
	public HttpComponentsMessageSender httpComponentsMessageSender() {
		HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
		httpComponentsMessageSender.setCredentials(usernamePasswordCredentials());

		return httpComponentsMessageSender;
	}

	@Bean
	public UsernamePasswordCredentials usernamePasswordCredentials() {
		return new UsernamePasswordCredentials("empresacws", "123456");
	}
}
