# API de Produtos

Esta Api é um modelo de um crud básico para cadastrar produtos

[EndPoint Principal](localhost:8080/api/v1/produtos)

# Instruções

Está API foi desenvolvida com o banco Postgress.
Na pasta /src/main/resources/db/insomnia temos um arquivo Api-Endpoints.json no qual pode estar sendo importado no Insomnia para auxiliar na utilização dos endpoints disponíveis

### Requisitos
* Java 17
* Maven
* Docker

### IDE
* Eclipse, Intellij, Vscode ou STS

### Iniciar Container da API

Para executar o container da api é necessário executar os seguintes comandos:
    
    ./mvnw -DskipTests=true clean package

#### Iniciar imagem docker postgress
* docker-compose -f "docker-compose.yml" up -d --build

Com o container de pé teremos disponível a api, o banco de dados postgress e pgadmin

* API http://localhost:8080/api/v1/produtos
* PGADMIN: http://localhost:4040/login
  *     EMAIL: pgadmin4@pgadmin.org
  *     PASSWORD: admin

#### Parar imagem docker postgress
* docker-compose -f "docker-compose.yml" down


