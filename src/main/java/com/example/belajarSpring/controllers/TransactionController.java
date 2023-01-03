package com.example.belajarSpring.controllers;

import com.example.belajarSpring.models.dto.request.TransactionRequest;
import com.example.belajarSpring.models.dto.response.TransactionResponse;
import com.example.belajarSpring.repositories.TransactionRepository;
import com.example.belajarSpring.services.Transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaksi")
public class TransactionController {
    @Autowired
    private TransactionService  transactionService;
    @Autowired
    private TransactionRepository transactionRepository;

    private TransactionResponse transactionResponse;

    @PostMapping
    public ResponseEntity<?> addPeminjaman(@RequestBody TransactionRequest request) {
        try{
            transactionResponse = transactionService.createPeminjaman(request);
            return ResponseEntity.status(transactionResponse.getStatus()).body(transactionResponse);
        } catch (Exception e) {
            e.printStackTrace();
            transactionResponse = new TransactionResponse(500, e.getLocalizedMessage(), null);
            return ResponseEntity.status(transactionResponse.getStatus()).body(transactionResponse);
        }
    }
}
