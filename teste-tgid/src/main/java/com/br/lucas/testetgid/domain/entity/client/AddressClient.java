package com.br.lucas.testetgid.domain.entity.client;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class AddressClient {

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_address_client;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "client_id",
            nullable = false
    )
    private Client client;
}
