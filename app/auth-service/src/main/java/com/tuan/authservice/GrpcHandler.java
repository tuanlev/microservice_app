package com.tuan.authservice;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrpcHandler {
//    @Autowired
//    AuthServiceGrpc.AuthServiceBlockingStub stub;
//    @Autowired
//    JwtService jwtService;
//    @GetMapping("/{hi}")
//    public String index(@PathVariable Optional<String> hi) {
//        AuthRequest request = AuthRequest.newBuilder().setToken(((hi.isPresent())?hi.get():"token")).build();
//        AuthResponse response = stub.authenticate(request);
//        return "Hello World" + jwtService.generateToken() + "   /n " + jwtService.getBody(jwtService.generateToken());
//    }
//    @ExceptionHandler(Exception.class)
//    public String handleException(Exception e) {
//        return "error";
//    }
}
