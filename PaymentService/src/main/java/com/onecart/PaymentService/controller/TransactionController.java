package com.onecart.PaymentService.controller;

import com.onecart.PaymentService.dto.request.DoPaymentRequest;
import com.onecart.PaymentService.dto.request.GetPaymentDataFromIDsRequest;
import com.onecart.PaymentService.dto.response.DoPaymentResponse;
import com.onecart.PaymentService.dto.response.GetPaymentByIdResponse;
import com.onecart.PaymentService.dto.response.GetPaymentDataFromIDsResponse;
import com.onecart.PaymentService.service.TransactionService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/payment")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("")
    public ResponseEntity<DoPaymentResponse> doPayment(@Valid @RequestBody DoPaymentRequest doPaymentRequest) {
        log.info("TransactionController -> Initiating Payment : " + doPaymentRequest);
        return new ResponseEntity<>(transactionService.doPayment(doPaymentRequest), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPaymentByIdResponse> getPaymentById(@PathVariable Long id) {
        log.info("TransactionController -> Fetching Payment Details for Id : " + id);
        return new ResponseEntity<>(transactionService.getPaymentById(id), HttpStatus.OK);
    }

    @PostMapping("/bulk")
    public ResponseEntity<GetPaymentDataFromIDsResponse> getPaymentDataFromIDs(@RequestBody GetPaymentDataFromIDsRequest getPaymentDataFromIDsRequest) {
        log.info("TransactionController");
        return new ResponseEntity<>(transactionService.getPaymentDataFromIDs(getPaymentDataFromIDsRequest), HttpStatus.OK);
    }

    @GetMapping("/healthcheck")
    public ResponseEntity<String> healthcheck() {
        String message = "Payment Service is healthy";
        log.info(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
