package com.br.lucas.testetgid.domain.service;

import com.br.lucas.testetgid.api.model.input.CompanyInputDTO;
import com.br.lucas.testetgid.api.model.output.ClientOutputDTO;
import com.br.lucas.testetgid.api.model.output.CompanyOutputDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface CompanyService {
    CompanyOutputDTO createCompany(CompanyInputDTO companyInputDTO);

    Page<CompanyOutputDTO> listAllCompanys(PageRequest pageRequest);

    CompanyOutputDTO searchCompanyForId(Integer CompanyId);

    void deleteACompany(Integer CompanyId);
}
