package com.br.lucas.testetgid.domain.service.implementation;

import com.br.lucas.testetgid.api.model.input.AddressClientInputDTO;
import com.br.lucas.testetgid.api.model.input.ClientInputDTO;
import com.br.lucas.testetgid.api.model.input.PhonesClientInputDTO;
import com.br.lucas.testetgid.api.model.output.ClientOutputDTO;
import com.br.lucas.testetgid.common.exceptions.ResourceNotFoundException;
import com.br.lucas.testetgid.common.exceptions.ResourceWasNotCreatedException;
import com.br.lucas.testetgid.domain.entity.client.AddressClient;
import com.br.lucas.testetgid.domain.entity.client.Client;
import com.br.lucas.testetgid.domain.entity.client.PhoneClient;
import com.br.lucas.testetgid.domain.repository.ClientRepository;
import com.br.lucas.testetgid.domain.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;


    @Override
    public ClientOutputDTO createClient(ClientInputDTO clientInputDTO) {
        checkExistsClientByCpf(clientInputDTO);

        Client clientToPersist = new Client(clientInputDTO.name(), clientInputDTO.cpf());

        LinkedHashSet<AddressClient> addressClient = extractedAddresses(clientInputDTO.addresses(), clientToPersist);

        clientToPersist.setAddressesClient(addressClient);

        LinkedHashSet<PhoneClient> phoneClient = extractedPhones(clientInputDTO.phones(), clientToPersist);

        clientToPersist.setPhonesClient(phoneClient);

        Client persistentClient = clientRepository.save(clientToPersist);

        return this.outputClientAssembler(persistentClient);
    }

    @Override
    public Page<ClientOutputDTO> listAllClients(PageRequest pageRequest) {
        Page<Client> clientPage = clientRepository.findAll(pageRequest);
        return clientPage.map(this::outputClientAssembler);
    }

    @Override
    public ClientOutputDTO searchClientForId(Integer clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(
                () -> new ResourceNotFoundException("Client com id: " + clientId + " não encontrado!")
        );

        return outputClientAssembler(client);
    }

    @Override
    public void deleteAClient(Integer clientId) {
        Optional<Client> idBuilding = clientRepository.findById(clientId);

        if (idBuilding.isEmpty()) throw new ResourceNotFoundException("Client com id: " + clientId + " não encontrado!");

        clientRepository.deleteById(clientId);
    }

    @Override
    public ClientOutputDTO updateClient(Integer id, ClientInputDTO clientInputDTO) {
        return null;
    }

    private void checkExistsClientByCpf(ClientInputDTO client) {
        boolean existingClient = clientRepository.findByCpf(client.cpf())
                .stream()
                .anyMatch(c -> !c.getCpf().equals(client.cpf()));

        if(existingClient) throw new ResourceWasNotCreatedException
                ("Não foi possível o criar o Cliente " + client.name() + ". O mesmo já existe!");
    }

    private LinkedHashSet<PhoneClient> extractedPhones(List<PhonesClientInputDTO> phonesClientDTOs, Client client) {
        LinkedHashSet<PhoneClient> phones = new LinkedHashSet<>();
        for (PhonesClientInputDTO phoneDTO : phonesClientDTOs) {
            PhoneClient phone = new PhoneClient(
                    phoneDTO.phone()
            );
            phone.setClient(client);
            phones.add(phone);
        }
        return phones;
    }


    private LinkedHashSet<AddressClient> extractedAddresses(List<AddressClientInputDTO> addressClientDTOs, Client client) {
        LinkedHashSet<AddressClient> addresses = new LinkedHashSet<>();
        for (AddressClientInputDTO addressDTO : addressClientDTOs) {
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

    private ClientOutputDTO outputClientAssembler(Client client) {
        return new ClientOutputDTO(
                client.getIdClient(),
                client.getName(),
                client.getCpf()
        );
    }
}
