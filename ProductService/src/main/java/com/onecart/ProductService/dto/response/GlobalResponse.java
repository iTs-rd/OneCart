package com.onecart.ProductService.dto.response;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@ToString
public class GlobalResponse {

    public String message;
    public String status;
    public LocalDateTime timestamp;
    public ZoneId timeZone;

    public GlobalResponse(String message, String status) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        this.timeZone = ZoneId.of("Asia/Kolkata");
    }

}
