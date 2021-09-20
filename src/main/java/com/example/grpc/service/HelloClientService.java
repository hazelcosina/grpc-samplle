package com.example.grpc.service;

import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import com.example.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import org.springframework.stereotype.Service;

@Service
public class HelloClientService {

    private final ManagedChannel helloChannel;

    public HelloClientService(ManagedChannel managedChannel) {
        this.helloChannel = managedChannel;
    }

    private void callHelloService(){
        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(helloChannel);

        HelloRequest.Builder request = HelloRequest.newBuilder();
        request.setFirstName("Brad");
        request.setLastName("Pitt");

        HelloResponse helloResponse = stub.hello(request.build());

        System.out.println(helloResponse);
    }
}
