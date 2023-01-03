package com.example.belajarSpring.services.Transaction;

import com.example.belajarSpring.models.dto.request.TransactionRequest;
import com.example.belajarSpring.models.dto.response.TransactionResponse;

public interface TransactionService {
    TransactionResponse createPeminjaman(TransactionRequest request) throws Exception;
    TransactionResponse updatePeminjaman(Long id, TransactionRequest request) throws Exception;

}
