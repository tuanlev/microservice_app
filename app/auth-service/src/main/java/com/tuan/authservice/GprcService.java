package com.tuan.authservice;
import com.example.grpc.*;
import io.grpc.stub.StreamObserver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

@GrpcService
class GprcService extends AuthServiceGrpc.AuthServiceImplBase {

    private static Log log = LogFactory.getLog(GprcService.class);

    @Override
    public void authenticate(com.example.grpc.AuthRequest request, StreamObserver<com.example.grpc.AuthResponse> responseObserver) {
        AuthResponse response = AuthResponse.newBuilder().setIsValid(true).setStatus(500).setMessage("hi lo ban nho"+request.getToken()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}