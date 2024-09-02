package com.br.lucas.testetgid.domain.entity.client;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class PhoneClient {

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_phone_client;

    @NonNull
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "client_id",
            nullable = false
    )
    private Client client;
}
