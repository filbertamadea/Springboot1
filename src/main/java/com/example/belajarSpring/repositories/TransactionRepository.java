package com.example.belajarSpring.repositories;

import com.example.belajarSpring.models.entitiy.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaksi, Long> {

}
