package com.nttdata.bootcamp.exchangebootcoinservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class ExchangeBootcoinServiceApplication {
	@Value(value = "${webclient.baseurl}")
	private String baseurl;

	public static void main(String[] args) {
		SpringApplication.run(ExchangeBootcoinServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public WebClient loadBalancedWebClientBuilder() {
		return WebClient.builder()
				.baseUrl(baseurl)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}
}
