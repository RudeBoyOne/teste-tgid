package com.br.lucas.testetgid.domain.entity.company;

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
public class Company {

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_company;

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    @EqualsAndHashCode.Include
    @Column(
            nullable = false,
            unique = true
    )
    private String cnpj;

    @NonNull
    @Column(nullable = false)
    private Double balance;

    @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Set<AddressCompany> addressesCompany;

    @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Set<PhoneCompany> phonesCompany;

    @OneToMany
    @JoinColumn(
            name = "company",
            nullable = false
    )
    private Set<Transaction> transactions;
}
