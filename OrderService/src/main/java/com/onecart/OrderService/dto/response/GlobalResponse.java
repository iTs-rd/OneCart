package com.onecart.OrderService.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
