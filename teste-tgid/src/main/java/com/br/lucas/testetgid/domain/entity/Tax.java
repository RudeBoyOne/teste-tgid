package com.br.lucas.testetgid.domain.entity;

import com.br.lucas.testetgid.domain.entity.enums.TypeTax;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Tax {

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tax;

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private TypeTax type;

    @Column(nullable = false)
    private Double value;

    @Column(nullable = false)
    private String description;
}
