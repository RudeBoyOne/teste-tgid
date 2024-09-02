package com.br.lucas.testetgid.domain.entity.client;

import com.br.lucas.testetgid.domain.entity.Transaction;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Client {

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_client;

    @Column(nullable = false)
    private String name;

    @EqualsAndHashCode.Include
    @Column(
            nullable = false,
            unique = true
    )
    private String cpf;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<AddressClient> addressesClient;

    @OneToMany
    @JoinColumn(
            name = "client",
            nullable = false
    )
    private Set<PhoneClient> phonesClient;

    @OneToMany
    @JoinColumn(
            name = "client",
            nullable = false
    )
    private Set<Transaction> transactions;
}