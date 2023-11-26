package com.onecart.AccountService.external.client;


import com.onecart.AccountService.external.dto.response.GetAllOrderByUserIdResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORDER-SERVICE/order")
public interface OrderService {


    @GetMapping("/user/{id}")
    public ResponseEntity<GetAllOrderByUserIdResponse> getAllOrderByUserId(@PathVariable Long id);

}
