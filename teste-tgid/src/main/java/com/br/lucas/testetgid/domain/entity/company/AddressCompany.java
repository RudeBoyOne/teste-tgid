package com.br.lucas.testetgid.domain.entity.company;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class AddressCompany {

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_address_company;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String street;

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String city;

    @ManyToOne
    @JoinColumn(
            name = "id_company",
            nullable = false
    )
    private Company company;
}
