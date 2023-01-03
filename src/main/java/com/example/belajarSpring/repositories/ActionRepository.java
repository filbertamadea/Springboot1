package com.example.belajarSpring.repositories;

import com.example.belajarSpring.models.entitiy.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
    Action findAllByAksi(String aksi);
}
