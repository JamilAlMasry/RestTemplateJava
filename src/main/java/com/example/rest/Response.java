package com.example.rest;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    public boolean status;
    public Object data;
    public String message;

    public Response() {
    }
    public Response(boolean status, Object data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }
}
