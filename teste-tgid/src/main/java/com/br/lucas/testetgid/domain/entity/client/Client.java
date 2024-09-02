package com.br.lucas.testetgid.domain.entity.client;

import com.br.lucas.testetgid.domain.entity.Transaction;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Client {

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @EqualsAndHashCode.Include
    @Column(
            nullable = false,
            unique = true
    )
    private String cpf;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Set<AddressClient> addressesClient;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Set<PhoneClient> phonesClient;

    @OneToMany
    @JoinColumn(
            name = "client",
            nullable = false
    )
    private Set<Transaction> transactions;
}