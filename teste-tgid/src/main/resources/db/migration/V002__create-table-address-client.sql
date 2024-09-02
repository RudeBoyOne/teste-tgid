CREATE TABLE address_client(
    id_address_client   INT AUTO_INCREMENT NOT NULL,
    cep                 VARCHAR(10) NOT NULL,
    street              VARCHAR(100) NOT NULL,
    number              VARCHAR(10) NOT NULL,
    city                VARCHAR(70) NOT NULL,
    client_id           INT          NOT NULL,
    CONSTRAINT pk_addressclient PRIMARY KEY (id_address_client)
);

ALTER TABLE address_client
    ADD CONSTRAINT FK_ADDRESSCLIENT_ON_ID_CLIENT FOREIGN KEY (client_id) REFERENCES client (id_client);