package com.br.lucas.testetgid.domain.entity.company;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class PhoneCompany {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_phone_company;

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private String phone;

    @ManyToOne
    @JoinColumn(
            name = "id_company",
            nullable = false
    )
    private Company company;
}
