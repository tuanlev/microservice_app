package com.tuan.authservice.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseSuccess {
    final boolean success = true;
    String message;
    Object data;
    int status;
}
