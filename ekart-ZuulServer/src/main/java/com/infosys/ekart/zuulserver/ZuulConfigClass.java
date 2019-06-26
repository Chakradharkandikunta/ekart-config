package com.infosys.ekart.zuulserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;

@Configuration
public class ZuulConfigClass {

	@Bean
	public FallbackProvider fallbackProvider() {
		return new FallbackProvider() {

			@Override
			public String getRoute() {
				return null;
			}

			@Override
			public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
				return new ClientHttpResponse() {

					@Override
					public InputStream getBody() throws IOException {
						return new ByteArrayInputStream("Sorry. Something went wrong. Please try again".getBytes());
					}

					@Override
					public HttpHeaders getHeaders() {
						HttpHeaders headers = new HttpHeaders();
						headers.setContentType(MediaType.TEXT_PLAIN);
						return headers;
					}

					@Override
					public HttpStatus getStatusCode() throws IOException {
						return HttpStatus.OK;
					}

					@Override
					public int getRawStatusCode() throws IOException {
						return 200;
					}

					@Override
					public String getStatusText() throws IOException {
						return "OK";
					}

					@Override
					public void close() {

					}
				};
			}
		};
	}
}
