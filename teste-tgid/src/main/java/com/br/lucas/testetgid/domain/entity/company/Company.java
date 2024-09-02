package com.br.lucas.testetgid.domain.entity.company;

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
public class Company {

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_company;

    @Column(nullable = false)
    private String name;

    @EqualsAndHashCode.Include
    @Column(
            nullable = false,
            unique = true
    )
    private String cnpj;

    @Column(nullable = false)
    private Double balance;

    @OneToMany(
            mappedBy = "company",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<AddressCompany> addressesCompany;

    @OneToMany
    @JoinColumn(
            name = "company",
            nullable = false
    )
    private Set<PhoneCompany> phonesCompany;

    @OneToMany
    @JoinColumn(
            name = "company",
            nullable = false
    )
    private Set<Transaction> transactions;
}
