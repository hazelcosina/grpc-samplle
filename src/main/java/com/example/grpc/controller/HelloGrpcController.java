package com.example.grpc.controller;

import com.example.grpc.HelloRequest;
import com.example.grpc.HelloResponse;
import com.example.grpc.HelloServiceGrpc;
import com.example.grpc.service.HelloService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloGrpcController extends HelloServiceGrpc.HelloServiceImplBase {

    private final HelloService helloService;

    public HelloGrpcController(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public void hello(HelloRequest helloRequest, StreamObserver<HelloResponse> responseObserver) {

        String greeting = helloService.sayHello(helloRequest.getFirstName(), helloRequest.getLastName());

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
