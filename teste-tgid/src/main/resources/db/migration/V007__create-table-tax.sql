CREATE TABLE tax (
    id_tax          INT AUTO_INCREMENT NOT NULL,
    type            TINYINT           NOT NULL,
    value           DECIMAL(12,2)             NOT NULL,
    description     VARCHAR(255)       NOT NULL,
    CONSTRAINT pk_tax PRIMARY KEY (id_tax)
);