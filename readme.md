# Sistema de Gerenciamento de Projetos e Desenvolvimento de Software

Este projeto é um sistema de gerenciamento de projetos, desenvolvido para integrar times, clientes e tarefas. Ele proporciona acompanhamento em tempo real dos status dos projetos e atividades, permitindo um gerenciamento eficaz.

## Funcionalidades

- Cadastro de Clientes.
- Cadastro de Projetos e Atividades.
- Relacionamento de atividades aos projetos e clientes.
- Acompanhamento de status de projetos (abertos, concluídos, etc.).
- Listagem de atividades cadastradas em projetos específicos.

## Tecnologias Utilizadas

### Back-end

- **Java 11**: Utilizado como linguagem de programação principal.
- **Spring Boot**: Framework para construção da API e lógica de negócios.
- **Hibernate**: ORM utilizado para persistência de dados.
- **PostgreSQL**: Banco de dados relacional para armazenamento de informações.
## Estrutura de Banco de Dados

O banco de dados utilizado é o **PostgreSQL**, com a persistência feita via **Hibernate**. As principais entidades do sistema são:

- **Cliente**: Armazena informações sobre os clientes da empresa.
- **Projeto**: Registra os projetos em andamento, seus status e informações relevantes.
- **Atividade**: Cada atividade é associada a um projeto e cliente, podendo ser criada a qualquer momento.

## Diagrama

O diagrama do banco de dados pode ser visualizado [aqui](https://app.eraser.io/workspace/9JSXCl8VP71xGeLPAqA5?origin=share).

## Como Rodar o Projeto

### Requisitos

Antes de rodar o projeto, certifique-se de ter as seguintes ferramentas instaladas:

- [Java 11+](https://adoptopenjdk.net/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [PostgreSQL](https://www.postgresql.org/)
- IDE (como IntelliJ IDEA ou VS Code)

### Passos para Configuração Local

1. Clone o repositório:

    ```bash
    git clone https://github.com/seu-usuario/seu-repositorio.git
    ```

2. Acesse o diretório do projeto:

    ```bash
    cd seu-repositorio
    ```

3. Configure o banco de dados **PostgreSQL**:

    - Crie um banco de dados no PostgreSQL com as credenciais apropriadas.
    - Configure as credenciais no arquivo `application.properties` ou `application.yml`:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    spring.jpa.hibernate.ddl-auto=update
    ```

4. Rode a aplicação:

    - Utilize o Maven ou Gradle para compilar e rodar o projeto.

    ```bash
    ./mvnw spring-boot:run
    ```

   Ou, se estiver usando Gradle:

    ```bash
    ./gradlew bootRun
    ```

5. Acesse a API pelo endereço `http://localhost:8080`.

### Endpoints da API

- **GET** `/gerenciamento/clientes`: Retorna todos os clientes.
- **POST** `/gerenciamento/clientes`: Cria um novo cliente.
- **GET** `/gerenciamento/atividades`: Retorna todas as atividades.
- **POST** `/gerenciamento/atividades`: Cria uma nova atividade.
- **PATCH** `/gerenciamento/atividades/{atividadeId}`: Atualiza uma atividade existente.

