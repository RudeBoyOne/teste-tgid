package com.br.lucas.testetgid.domain.entity.client;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class PhoneClient {

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_phone_client;

    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private String phone;

    @ManyToOne
    @JoinColumn(
            name = "id_client",
            nullable = false
    )
    private Client client;
}
