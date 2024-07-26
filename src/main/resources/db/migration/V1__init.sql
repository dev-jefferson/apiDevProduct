CREATE SCHEMA IF NOT EXISTS devproduct_schema;

CREATE TABLE IF NOT EXISTS devproduct_schema.produtos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    reponsavel VARCHAR(100) NOT NULL,
    data_criacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_modificacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    categoria VARCHAR(50)
);
