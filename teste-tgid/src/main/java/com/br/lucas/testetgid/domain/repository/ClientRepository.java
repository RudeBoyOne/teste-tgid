package com.br.lucas.testetgid.domain.repository;

import com.br.lucas.testetgid.domain.entity.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByCpf(String cpf);
}
