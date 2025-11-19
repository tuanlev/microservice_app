package com.tuan.apigateway.controller;

import com.tuan.apigateway.service.GrpcServiceImplement;
import io.grpc.builtin.AuthRequest;
import io.grpc.builtin.AuthResponse;
import io.grpc.builtin.AuthServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
@Slf4j
@RestController
public class TestController {
    @Autowired
    GrpcServiceImplement grpcServiceImplement;
    @GrpcClient("auth-service")
    AuthServiceGrpc.AuthServiceStub stub;
    @GetMapping("/test")
    public Mono<AuthResponse> test() {
        return Mono.just(grpcServiceImplement.authenticate(AuthRequest.newBuilder().setToken("hi").build()));
    }
    @ExceptionHandler(value = {Exception.class})
    public Mono<String> handleException(Exception e) {
        return Mono.just(e.getMessage());
    }

}
