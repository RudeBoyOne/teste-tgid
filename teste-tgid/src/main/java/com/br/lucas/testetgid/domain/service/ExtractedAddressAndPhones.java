package com.br.lucas.testetgid.domain.service;

import com.br.lucas.testetgid.api.model.input.AddressInputDTO;
import com.br.lucas.testetgid.api.model.input.PhonesInputDTO;
import com.br.lucas.testetgid.domain.entity.client.AddressClient;
import com.br.lucas.testetgid.domain.entity.client.Client;
import com.br.lucas.testetgid.domain.entity.client.PhoneClient;
import com.br.lucas.testetgid.domain.entity.company.AddressCompany;
import com.br.lucas.testetgid.domain.entity.company.Company;
import com.br.lucas.testetgid.domain.entity.company.PhoneCompany;

import java.util.LinkedHashSet;
import java.util.List;

public interface ExtractedAddressAndPhones {

    LinkedHashSet<AddressCompany> extractedAddressesCompany(List<AddressInputDTO> addressDTOs, Company company);

    LinkedHashSet<PhoneCompany> extractedPhonesCompany(List<PhonesInputDTO> phonesDTOs, Company company);

    LinkedHashSet<PhoneClient> extractedPhonesClient(List<PhonesInputDTO> phonesClientDTOs, Client client);

    LinkedHashSet<AddressClient> extractedAddressesClient(List<AddressInputDTO> addressClientDTOs, Client client);
}
