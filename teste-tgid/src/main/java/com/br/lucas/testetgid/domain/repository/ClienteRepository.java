package com.br.lucas.testetgid.domain.repository;

import com.br.lucas.testetgid.domain.entity.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Client, Integer> {
}
