package com.br.lucas.testetgid.domain.entity.company;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class PhoneCompany {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_phone_company;

    @NonNull
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private String phone;

    @ManyToOne
    @JoinColumn(
            name = "company_id",
            nullable = false
    )
    private Company company;
}
