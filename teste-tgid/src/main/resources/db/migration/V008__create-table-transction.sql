CREATE TABLE transaction (
    id_transaction INT AUTO_INCREMENT NOT NULL,
    value          DECIMAL(12,2)      NOT NULL,
    date_time      datetime           NOT NULL,
    id_client      INT                NOT NULL,
    id_company     INT                NOT NULL,
    id_tax         INT                NOT NULL,
    CONSTRAINT pk_transaction PRIMARY KEY (id_transaction)
);

ALTER TABLE transaction
    ADD CONSTRAINT FK_TRANSACTION_ON_ID_CLIENT FOREIGN KEY (id_client) REFERENCES client (id_client);

ALTER TABLE transaction
    ADD CONSTRAINT FK_TRANSACTION_ON_ID_COMPANY FOREIGN KEY (id_company) REFERENCES company (id_company);

ALTER TABLE transaction
    ADD CONSTRAINT FK_TRANSACTION_ON_ID_TAX FOREIGN KEY (id_tax) REFERENCES tax (id_tax);