package com.onecart.OrderService.external.dto.response;

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
    
}