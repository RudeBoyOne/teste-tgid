package com.br.lucas.testetgid.domain.entity.company;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class AddressCompany {

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_address_company;

    @NonNull
    @Column(nullable = false)
    private String cep;

    @NonNull
    @Column(nullable = false)
    private String street;

    @NonNull
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private String number;

    @NonNull
    @Column(nullable = false)
    private String city;

    @ManyToOne
    @JoinColumn(
            name = "company_id",
            nullable = false
    )
    private Company company;
}
