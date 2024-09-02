CREATE TABLE phone_company (
    id_phone_company    INT AUTO_INCREMENT NOT NULL,
    phone               VARCHAR(15)       NOT NULL,
    company             INT                NOT NULL,
    CONSTRAINT pk_phonecompany PRIMARY KEY (id_phone_company)
);

ALTER TABLE phone_company
    ADD CONSTRAINT FK_PHONECOMPANY_ON_COMPANY FOREIGN KEY (company) REFERENCES company (id_company);