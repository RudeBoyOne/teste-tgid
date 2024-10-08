package com.br.lucas.testetgid.domain.repository;

import com.br.lucas.testetgid.domain.entity.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Integer> {
}
