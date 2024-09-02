package com.br.lucas.testetgid.api.controller;

import com.br.lucas.testetgid.api.model.input.ClientInputDTO;
import com.br.lucas.testetgid.api.model.output.ClientOutputDTO;
import com.br.lucas.testetgid.domain.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientOutputDTO> create(@RequestBody ClientInputDTO client) {
           ClientOutputDTO clientOutput = clientService.createClient(client);

           return ResponseEntity.status(HttpStatus.CREATED).body(clientOutput);
    }
}
