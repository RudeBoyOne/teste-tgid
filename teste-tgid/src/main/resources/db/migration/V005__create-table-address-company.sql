CREATE TABLE address_company (
    id_address_company  INT AUTO_INCREMENT NOT NULL,
    cep                 VARCHAR(10) NOT NULL,
    street              VARCHAR(100) NOT NULL,
    number              VARCHAR(10) NOT NULL,
    city                VARCHAR(70) NOT NULL,
    company_id          INT                NOT NULL,
    CONSTRAINT pk_addresscompany PRIMARY KEY (id_address_company)
);

ALTER TABLE address_company
    ADD CONSTRAINT FK_ADDRESSCOMPANY_ON_ID_COMPANY FOREIGN KEY (company_id) REFERENCES company (id_company);