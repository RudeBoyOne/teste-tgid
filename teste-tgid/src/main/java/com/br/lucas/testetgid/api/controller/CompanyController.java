package com.br.lucas.testetgid.api.controller;

import com.br.lucas.testetgid.api.model.input.CompanyInputDTO;
import com.br.lucas.testetgid.api.model.output.CompanyOutputDTO;
import com.br.lucas.testetgid.domain.service.CompanyService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<CompanyOutputDTO> create(@RequestBody @Valid CompanyInputDTO company) {
        CompanyInputDTO companyInputDTO = new CompanyInputDTO(
                company.name(),
                fomartCnpj(company.cnpj()),
                company.balance(),
                company.addresses(),
                company.phones()
        );

        CompanyOutputDTO companyOutputDTO = companyService.createCompany(companyInputDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(companyOutputDTO);
    }

    private String fomartCnpj(String cnpj) {
        return cnpj.replaceAll("\\D", "");
    }
}
