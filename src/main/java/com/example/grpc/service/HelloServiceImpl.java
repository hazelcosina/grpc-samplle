package com.example.grpc.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{

    @Override
    public String sayHello(String firstName, String lastName) {
        return "Hello World from " + firstName + " " + lastName;
    }
}
