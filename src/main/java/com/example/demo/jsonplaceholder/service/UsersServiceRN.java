package com.example.demo.jsonplaceholder.service;

import org.springframework.web.reactive.function.client.WebClient;

public class UsersServiceRN {

    private WebClient client = WebClient.create();

    public String getAll() {
        WebClient.ResponseSpec responseSpec = client.get()
                .uri("https://jsonplaceholder.typicode.com/posts")
                .retrieve();
        String responseBody = responseSpec.bodyToMono(String.class).block();
        return responseBody;
    }

    public String getById(Integer id) {
        String url = String.format("https://jsonplaceholder.typicode.com/posts/%d",id);
        WebClient.ResponseSpec responseSpec = client.get()
                .uri(url)
                .retrieve();
        String responseBody = responseSpec.bodyToMono(String.class).block();
        return responseBody;
    }

}
