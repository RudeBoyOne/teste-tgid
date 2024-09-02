package com.br.lucas.testetgid.domain.entity.client;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class AddressClient {

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_address_client;

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
            name = "id_client",
            nullable = false
    )
    private Client client;
}
