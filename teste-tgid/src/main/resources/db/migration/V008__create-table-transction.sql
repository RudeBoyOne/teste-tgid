CREATE TABLE transaction (
    id_transaction INT AUTO_INCREMENT NOT NULL,
    value          DECIMAL(12,2)      NOT NULL,
    date_time      datetime           NOT NULL,
    client_id      INT                NOT NULL,
    company_id     INT                NOT NULL,
    tax_id         INT                NOT NULL,
    CONSTRAINT pk_transaction PRIMARY KEY (id_transaction)
);

ALTER TABLE transaction
    ADD CONSTRAINT FK_TRANSACTION_ON_ID_CLIENT FOREIGN KEY (client_id) REFERENCES client (id_client);

ALTER TABLE transaction
    ADD CONSTRAINT FK_TRANSACTION_ON_ID_COMPANY FOREIGN KEY (company_id) REFERENCES company (id_company);

ALTER TABLE transaction
    ADD CONSTRAINT FK_TRANSACTION_ON_ID_TAX FOREIGN KEY (tax_id) REFERENCES tax (id_tax);