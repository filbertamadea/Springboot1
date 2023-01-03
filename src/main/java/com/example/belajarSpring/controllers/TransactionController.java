package com.example.belajarSpring.controllers;

import com.example.belajarSpring.models.dto.request.BookRequest;
import com.example.belajarSpring.models.dto.request.TransactionRequest;
import com.example.belajarSpring.models.dto.response.BookResponse;
import com.example.belajarSpring.models.dto.response.TransactionResponse;
import com.example.belajarSpring.repositories.TransactionRepository;
import com.example.belajarSpring.services.Transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBookById(@PathVariable Long id, @RequestBody TransactionRequest request) {
        try {
            transactionResponse = transactionService.updatePeminjaman(id, request);
            return ResponseEntity.status(transactionResponse.getStatus()).body(transactionResponse);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            transactionResponse = new TransactionResponse(500, e.getMessage(), null);
            return ResponseEntity.status(transactionResponse.getStatus()).body(transactionResponse);
        }
    }
}
