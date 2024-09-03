package com.br.lucas.testetgid.domain.service.implementation;

import com.br.lucas.testetgid.api.model.input.ClientInputDTO;
import com.br.lucas.testetgid.api.model.output.ClientOutputDTO;
import com.br.lucas.testetgid.common.exceptions.ResourceNotFoundException;
import com.br.lucas.testetgid.common.exceptions.ResourceWasNotCreatedException;
import com.br.lucas.testetgid.domain.entity.client.AddressClient;
import com.br.lucas.testetgid.domain.entity.client.Client;
import com.br.lucas.testetgid.domain.entity.client.PhoneClient;
import com.br.lucas.testetgid.domain.repository.ClientRepository;
import com.br.lucas.testetgid.domain.service.ClientService;
import com.br.lucas.testetgid.domain.service.ExtractedAddressAndPhones;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ExtractedAddressAndPhones extractedAddressAndPhones;


    @Override
    public ClientOutputDTO createClient(ClientInputDTO clientInputDTO) {
        checkExistsClientByCpf(clientInputDTO);

        Client clientToPersist = new Client(clientInputDTO.name(), clientInputDTO.cpf());

        LinkedHashSet<AddressClient> addressClient = extractedAddressAndPhones.
                extractedAddressesClient(clientInputDTO.addresses(), clientToPersist);

        clientToPersist.setAddressesClient(addressClient);

        LinkedHashSet<PhoneClient> phoneClient = extractedAddressAndPhones.
                extractedPhonesClient(clientInputDTO.phones(), clientToPersist);

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


    private void checkExistsClientByCpf(ClientInputDTO client) {
        Boolean existingClient = clientRepository.findByCpf(client.cpf()).isPresent();

        if (existingClient) throw new ResourceWasNotCreatedException("Não foi possível o criar o Cliente "
                + client.name() + ". Já existe um cliente com o CPF " + client.cpf());
    }

    private ClientOutputDTO outputClientAssembler(Client client) {
        return new ClientOutputDTO(
                client.getIdClient(),
                client.getName(),
                client.getCpf()
        );
    }
}
