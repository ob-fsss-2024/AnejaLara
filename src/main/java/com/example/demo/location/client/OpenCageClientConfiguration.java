package com.example.demo.location.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class OpenCageClientConfiguration {
    @Bean
    public OpenCageClient openCageClient(@Value("${opencage.api.url}") final String openCageApiUrl) {
        final RestClient restClient = RestClient.builder().baseUrl(openCageApiUrl).build();
        final RestClientAdapter adapter = RestClientAdapter.create(restClient);
        final HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(OpenCageClient.class);
    }
}

