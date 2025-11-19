//package com.tuan.authservice.exception;
//
//import com.tuan.authservice.response.ResponseError;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class ErrorHandler {
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ResponseError> handleException(Exception ex)
//    {
//        return
//            ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(ResponseError.builder().message(ex.getMessage()).build());
//    }
//}
