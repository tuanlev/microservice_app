package com.tuan.apigateway.service;

import io.grpc.builtin.AuthRequest;
import io.grpc.builtin.AuthResponse;
import io.grpc.builtin.AuthServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GrpcServiceImplement {
    @GrpcClient("auth-service")
    AuthServiceGrpc.AuthServiceStub authServiceStub;
    public AuthResponse authenticate(AuthRequest authRequest) {
        try {
            return (AuthResponse) Mono.create(
                    sink -> authServiceStub.authenticate(
                            authRequest,
                            new StreamObserver<AuthResponse> () {
                                @Override
                                public void onNext(AuthResponse value) {
                                    sink.success(value);
                                }
                                @Override
                                public void onError(Throwable t) {
                                    sink.error(t);
                                }
                                @Override
                                public void onCompleted() {}
                            }
                    )
            ).toFuture().get();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
