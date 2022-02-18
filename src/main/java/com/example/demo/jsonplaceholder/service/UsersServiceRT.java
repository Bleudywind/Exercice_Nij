package com.example.demo.jsonplaceholder.service;

import com.example.demo.jsonplaceholder.models.Users;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceRT {
    private String url = "https://jsonplaceholder.typicode.com/users";

    private final RestTemplate restTemplate;

    public UsersServiceRT(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Users> getAll() {
        List<Users> usersList = new ArrayList<Users>();
        return this.restTemplate.getForObject(url, usersList.getClass());
    }

    public String getById(Integer id) {
        Users users = new Users();
        String finaleUrl = String.format("%s/%d", url, id);
        System.out.println(finaleUrl);
        return this.restTemplate.getForObject(finaleUrl, String.class);
    }

    public String create(Users users) {
        return this.restTemplate.getForObject(url, String.class);
    }

    public String update(Users users, Integer id) {
        String finaleUrl = String.format("%s/%d", url, id);
        return this.restTemplate.getForObject(finaleUrl, String.class);
    }

    public void delete(Integer id) {
        String finaleUrl = String.format("%s/%d", url, id);
        this.restTemplate.delete(finaleUrl);
    }
}
