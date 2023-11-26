package com.onecart.AccountService.dto.response.userResponse;


import com.onecart.AccountService.external.model.Product;
import com.onecart.AccountService.external.model.Transaction;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
public class OrderResponse {
    private final Long id;
    private final Long userId;
    private final Long quantity;
    private final String orderStatus;
    private final Long amount;
    private final String currency;
    private final LocalDateTime orderDatetime;
    private final ZoneId timeZone;
    private final Transaction transaction;
    private final Product product;

}

