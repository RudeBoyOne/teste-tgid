CREATE TABLE phone_client (
    id_phone_client INT AUTO_INCREMENT  NOT NULL,
    phone           VARCHAR(15)         NOT NULL,
    client_id          INT                 NOT NULL,
    CONSTRAINT pk_phoneclient PRIMARY KEY (id_phone_client)
);

ALTER TABLE phone_client
    ADD CONSTRAINT FK_PHONECLIENT_ON_CLIENT FOREIGN KEY (client_id) REFERENCES client (id_client);