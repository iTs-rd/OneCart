package com.onecart.OrderService.external.client;


import com.onecart.OrderService.external.dto.request.payment.DoPaymentRequest;
import com.onecart.OrderService.external.dto.request.payment.GetPaymentDataFromIDsRequest;
import com.onecart.OrderService.external.dto.response.payment.DoPaymentResponse;
import com.onecart.OrderService.external.dto.response.payment.GetPaymentByIdResponse;
import com.onecart.OrderService.external.dto.response.payment.GetPaymentDataFromIDsResponse;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-SERVICE/payment")
public interface PaymentService {

    @PostMapping("")
    ResponseEntity<DoPaymentResponse> doPayment(@Valid @RequestBody DoPaymentRequest doPaymentRequest);

    @GetMapping("/{id}")
    public ResponseEntity<GetPaymentByIdResponse> getPaymentById(@PathVariable Long id);

    @PostMapping("/bulk")
    public ResponseEntity<GetPaymentDataFromIDsResponse> getPaymentDataFromIDs(@RequestBody GetPaymentDataFromIDsRequest getPaymentDataFromIDsRequest);
}
