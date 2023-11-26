package com.onecart.AccountService.external.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long productId;
    private Long paymentId;
    private Long quantity;
    private String orderStatus;
    private Long amount;
    private String currency;
    private LocalDateTime orderDatetime;
    private ZoneId timeZone;

}
