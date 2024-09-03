package com.br.lucas.testetgid.domain.service.implementation;

import com.br.lucas.testetgid.api.model.input.AddressInputDTO;
import com.br.lucas.testetgid.api.model.input.PhonesInputDTO;
import com.br.lucas.testetgid.domain.entity.client.AddressClient;
import com.br.lucas.testetgid.domain.entity.client.Client;
import com.br.lucas.testetgid.domain.entity.client.PhoneClient;
import com.br.lucas.testetgid.domain.entity.company.AddressCompany;
import com.br.lucas.testetgid.domain.entity.company.Company;
import com.br.lucas.testetgid.domain.entity.company.PhoneCompany;
import com.br.lucas.testetgid.domain.service.ExtractedAddressAndPhones;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;

@Service
public class ExtractedAddressAndPhonesImpl implements ExtractedAddressAndPhones {

    @Override
    public LinkedHashSet<AddressCompany> extractedAddressesCompany(List<AddressInputDTO> addressDTOs, Company company) {
        LinkedHashSet<AddressCompany> addresses = new LinkedHashSet<>();
        for (AddressInputDTO addressDTO : addressDTOs) {
            AddressCompany address = new AddressCompany(
                    addressDTO.cep(),
                    addressDTO.street(),
                    addressDTO.number(),
                    addressDTO.city()
            );
            address.setCompany(company);
            addresses.add(address);
        }
        return addresses;
    }

    @Override
    public LinkedHashSet<PhoneCompany> extractedPhonesCompany(List<PhonesInputDTO> phonesDTOs, Company company) {
        LinkedHashSet<PhoneCompany> phones = new LinkedHashSet<>();
        for (PhonesInputDTO phoneDTO : phonesDTOs) {
            PhoneCompany phone = new PhoneCompany(
                    phoneDTO.phone()
            );
            phone.setCompany(company);
            phones.add(phone);
        }
        return phones;
    }

    @Override
    public LinkedHashSet<PhoneClient> extractedPhonesClient(List<PhonesInputDTO> phonesClientDTOs, Client client) {
        LinkedHashSet<PhoneClient> phones = new LinkedHashSet<>();
        for (PhonesInputDTO phoneDTO : phonesClientDTOs) {
            PhoneClient phone = new PhoneClient(
                    phoneDTO.phone()
            );
            phone.setClient(client);
            phones.add(phone);
        }
        return phones;
    }

    @Override
    public LinkedHashSet<AddressClient> extractedAddressesClient(List<AddressInputDTO> addressClientDTOs, Client client) {
        LinkedHashSet<AddressClient> addresses = new LinkedHashSet<>();
        for (AddressInputDTO addressDTO : addressClientDTOs) {
            AddressClient address = new AddressClient(
                    addressDTO.cep(),
                    addressDTO.street(),
                    addressDTO.number(),
                    addressDTO.city()
            );
            address.setClient(client);
            addresses.add(address);
        }
        return addresses;
    }
}
