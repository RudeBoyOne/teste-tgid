package com.br.lucas.testetgid.domain.entity;

import com.br.lucas.testetgid.domain.entity.client.Client;
import com.br.lucas.testetgid.domain.entity.company.Company;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Transaction {

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_transaction;

    @Column(nullable = false)
    private Double value;

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(
            name = "id_client",
            nullable = false
    )
    private Client client;

    @ManyToOne
    @JoinColumn(
            name = "id_company",
            nullable = false
    )
    private Company company;

    @ManyToOne
    @JoinColumn(
            name = "id_tax",
            nullable = false
    )
    private Tax tax;
}
