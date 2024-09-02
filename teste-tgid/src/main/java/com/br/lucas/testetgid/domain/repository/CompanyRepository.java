package com.br.lucas.testetgid.domain.repository;

import com.br.lucas.testetgid.domain.entity.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
