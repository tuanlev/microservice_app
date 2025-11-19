package com.tuan.authservice.grpc;
import com.tuan.authservice.Model.User;
import com.tuan.authservice.service.JwtService;
import io.grpc.Status;
import io.grpc.builtin.*;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@GrpcService
@Slf4j
class GprcService extends AuthServiceGrpc.AuthServiceImplBase {
    @Autowired
    public JwtService jwtService;
    @Override
    public void authenticate(AuthRequest request, StreamObserver<AuthResponse> responseObserver) {
            String token = request.getToken();
            User userDecoder = jwtService.verifyAccessToken(token);
            UserInfo userInfo = UserInfo.newBuilder()
                    .setId(userDecoder.getId())
                    .setUsername(userDecoder.getUsername())
                    .setRole(userDecoder.getRole().toString())
                    .build();
            AuthResponse authRequest = AuthResponse.newBuilder()
                    .setMessage("authenticated")
                    .setUserInfo(userInfo)
                    .build();
            responseObserver.onNext(authRequest);
            responseObserver.onCompleted();
        }

    }

