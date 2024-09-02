package com.br.lucas.testetgid.domain.repository;

import com.br.lucas.testetgid.domain.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransctionRepository extends JpaRepository<Transaction, Integer> {
}
