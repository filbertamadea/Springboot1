package com.example.belajarSpring.services.Transaction;

import com.example.belajarSpring.exceptions.custom.CustomNotFoundException;
import com.example.belajarSpring.models.dto.request.TransactionRequest;
import com.example.belajarSpring.models.dto.response.TransactionResponse;
import com.example.belajarSpring.models.entitiy.Action;
import com.example.belajarSpring.models.entitiy.Book;
import com.example.belajarSpring.models.entitiy.Transaksi;
import com.example.belajarSpring.models.entitiy.User;
import com.example.belajarSpring.repositories.ActionRepository;
import com.example.belajarSpring.repositories.BookRepository;
import com.example.belajarSpring.repositories.TransactionRepository;
import com.example.belajarSpring.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ActionRepository actionRepository;

    private Transaksi transaksi;
    private List<Transaksi> transaksiList;
    private TransactionResponse transactionResponse;

    @Override
    public TransactionResponse createPeminjaman(TransactionRequest request) throws Exception {
        if(request.getNamaBuku() == null || request.getPeminjam() == null || request.getAction() == null){
            transactionResponse = new TransactionResponse(400, "data kosong, tidak bisa request", null);
        } else {
            transaksi = new Transaksi();
            transaksi.setPeminjam(request.getPeminjam());
            transaksi.setTglDipinjam(String.valueOf(LocalDateTime.now()));

            User user = userRepository.findAllByNama(request.getPeminjam());
            if(Objects.isNull(user)){ 
                throw new CustomNotFoundException("Nama tidak ada");
            }
            transaksi.setUser(user);

            Book book = bookRepository.findAllByJudul(request.getNamaBuku());
            if(Objects.isNull(book)){
                throw new CustomNotFoundException("Buku tidak ada");
            }
            transaksi.setBook(book);

            Action action = actionRepository.findAllByAksi(request.getAction());
            if(Objects.isNull(action)){
                throw new CustomNotFoundException("Action tidak ada");
            }
            transaksi.setAction(action);

            transactionRepository.save(transaksi);

            transactionResponse = new TransactionResponse(HttpStatus.CREATED.value(), "Sukses dibuat", transaksi);

        }
        return transactionResponse;
    }


    @Override
    public TransactionResponse updatePeminjaman(Long id, TransactionRequest request) throws Exception {
        return null;
    }
}
