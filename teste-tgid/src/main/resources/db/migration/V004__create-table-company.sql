CREATE TABLE company (
    id_company  INT AUTO_INCREMENT  NOT NULL,
    name        VARCHAR(100)        NOT NULL,
    cnpj        VARCHAR(14)         NOT NULL,
    balance     DECIMAL(15, 2)      NOT NULL,
    CONSTRAINT pk_company PRIMARY KEY (id_company)
);

ALTER TABLE company
    ADD CONSTRAINT uc_company_cnpj UNIQUE (cnpj);