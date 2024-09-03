package com.br.lucas.testetgid.domain.service.implementation;

import com.br.lucas.testetgid.api.model.input.CompanyInputDTO;
import com.br.lucas.testetgid.api.model.output.ClientOutputDTO;
import com.br.lucas.testetgid.api.model.output.CompanyOutputDTO;
import com.br.lucas.testetgid.common.exceptions.ResourceWasNotCreatedException;
import com.br.lucas.testetgid.domain.entity.company.AddressCompany;
import com.br.lucas.testetgid.domain.entity.company.Company;
import com.br.lucas.testetgid.domain.entity.company.PhoneCompany;
import com.br.lucas.testetgid.domain.repository.CompanyRepository;
import com.br.lucas.testetgid.domain.service.CompanyService;
import com.br.lucas.testetgid.domain.service.ExtractedAddressAndPhones;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ExtractedAddressAndPhones extractedAddressAndPhones;

    @Override
    public CompanyOutputDTO createCompany(CompanyInputDTO companyInputDTO) {
        checkExistsCompanyByCnpj(companyInputDTO);

        Company companyToPersist = new Company(
                companyInputDTO.name(),
                companyInputDTO.cnpj(),
                companyInputDTO.balance()
        );

        LinkedHashSet<AddressCompany> addresses = extractedAddressAndPhones.
                extractedAddressesCompany(companyInputDTO.addresses(), companyToPersist);

        companyToPersist.setAddressesCompany(addresses);

        LinkedHashSet<PhoneCompany> phones = extractedAddressAndPhones.
                extractedPhonesCompany(companyInputDTO.phones(), companyToPersist);

        companyToPersist.setPhonesCompany(phones);

        Company persistentCompany = companyRepository.save(companyToPersist);

        return this.outputCompanyAssembler(persistentCompany);
    }

    @Override
    public Page<CompanyOutputDTO> listAllCompanys(PageRequest pageRequest) {
        Page<Company> companyPage = companyRepository.findAll(pageRequest);
        return companyPage.map(this::outputCompanyAssembler);
    }

    @Override
    public CompanyOutputDTO searchCompanyForId(Integer CompanyId) {
        return null;
    }

    @Override
    public void deleteACompany(Integer CompanyId) {

    }

    private void checkExistsCompanyByCnpj(CompanyInputDTO company) {
        Boolean existingCompany = companyRepository.findByCnpj(company.cnpj()).isPresent();

        if (existingCompany) throw new ResourceWasNotCreatedException(
                "Não foi possível criar a company " + company.name() +
                        ", pois CNPJ já existe!"
        );
    }

    private CompanyOutputDTO outputCompanyAssembler(Company company) {
        return new CompanyOutputDTO(
                company.getName(),
                company.getCnpj(),
                company.getBalance()
        );

    }


}
