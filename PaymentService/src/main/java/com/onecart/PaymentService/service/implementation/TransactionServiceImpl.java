package com.onecart.PaymentService.service.implementation;

import com.onecart.PaymentService.dto.request.DoPaymentRequest;
import com.onecart.PaymentService.dto.request.GetPaymentDataFromIDsRequest;
import com.onecart.PaymentService.dto.response.DoPaymentResponse;
import com.onecart.PaymentService.dto.response.GetPaymentByIdResponse;
import com.onecart.PaymentService.dto.response.GetPaymentDataFromIDsResponse;
import com.onecart.PaymentService.models.Transaction;
import com.onecart.PaymentService.repository.TransactionRepository;
import com.onecart.PaymentService.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public DoPaymentResponse doPayment(DoPaymentRequest doPaymentRequest) {

        Transaction transaction = new Transaction(doPaymentRequest);

        transactionRepository.save(transaction);

        log.info("TransactionServiceImpl -> Payment Done : " + transaction);
        return new DoPaymentResponse(transaction, "Payment Successful", "success");
    }

    @Override
    public GetPaymentByIdResponse getPaymentById(Long id) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);

        if (optionalTransaction.isEmpty())
            throw new RuntimeException("No Transaction Found!");

        Transaction transaction = optionalTransaction.get();

        log.info("TransactionServiceImpl -> Transaction Found : " + transaction);

        return new GetPaymentByIdResponse(transaction, "Transaction Found!", "success");
    }

    @Override
    public GetPaymentDataFromIDsResponse getPaymentDataFromIDs(GetPaymentDataFromIDsRequest getPaymentDataFromIDsRequest) {
        log.info("TransactionServiceImpl -> indide");
        List<Transaction> transactions = transactionRepository.findAllById(getPaymentDataFromIDsRequest.getIDs());
        System.out.println(transactions);
        log.info("TransactionServiceImpl -> proccesed");


        return new GetPaymentDataFromIDsResponse(transactions, "found", "success");
    }
}
