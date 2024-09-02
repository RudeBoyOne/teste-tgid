package com.br.lucas.testetgid.domain.service;

import com.br.lucas.testetgid.api.model.input.ClientInputDTO;
import com.br.lucas.testetgid.api.model.output.ClientOutputDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ClientService {

    ClientOutputDTO createClient(ClientInputDTO clientInputDTO);

    Page<ClientOutputDTO> listAllClients(PageRequest pageRequest);

    ClientOutputDTO searchClientForId(Integer ClientId);

    void deleteAClient(Integer ClientId);

    ClientOutputDTO updateClient(Integer id, ClientInputDTO clientInputDTO);
}
