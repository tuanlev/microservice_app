package com.tuan.authservice.grpc;

import io.grpc.Status;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class GrpcHandler {
    @GrpcExceptionHandler(Exception.class)
    public Status grpcExceptionHandler(){
        return Status.INTERNAL.withDescription( "tuan" );
    }
}
