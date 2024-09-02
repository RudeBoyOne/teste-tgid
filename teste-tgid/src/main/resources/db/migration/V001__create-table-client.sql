CREATE TABLE client(
    id_client   INT AUTO_INCREMENT NOT NULL,
    name        VARCHAR(100) NOT NULL,
    cpf         VARCHAR(11) NOT NULL,
    CONSTRAINT pk_client PRIMARY KEY (id_client)
);

ALTER TABLE client
    ADD CONSTRAINT uc_client_cpf UNIQUE (cpf);