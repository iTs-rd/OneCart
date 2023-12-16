package com.onecart.PaymentService.models;

import com.onecart.PaymentService.dto.request.DoPaymentRequest;
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
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long orderId;

    private Long userId;

    private Long amount;

    private String currency;

    private String paymentStatus;

    private LocalDateTime paymentDatetime;

    private ZoneId timeZone;


    public Transaction(DoPaymentRequest doPaymentRequest) {
        this.orderId = doPaymentRequest.getOrderId();
        this.userId = doPaymentRequest.getUserId();
        this.amount = doPaymentRequest.getAmount();
        this.currency = doPaymentRequest.getCurrency();

        this.paymentStatus = "success";
        this.paymentDatetime = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        this.timeZone = ZoneId.of("Asia/Kolkata");
    }
}
