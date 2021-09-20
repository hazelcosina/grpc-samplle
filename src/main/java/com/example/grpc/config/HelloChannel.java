package com.example.grpc.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloChannel {

    @Value("${grpc.hello.host}")
    private String host;
    @Value("${grpc.hello.port}")
    private int port;

    @Bean
    ManagedChannel managedChannel(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        return channel;

    }
}
