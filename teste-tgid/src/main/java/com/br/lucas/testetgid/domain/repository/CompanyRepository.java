package com.br.lucas.testetgid.domain.repository;

import com.br.lucas.testetgid.domain.entity.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    Optional<Company> findByCnpj(String cnpj);
}
