# Sample app

Uma aplicação fullstack de exemplo para demonstrar habilidades de desenvolvimento backend (Java/Spring) e frontend (Node/React).

## Descrição

Esta aplicação é essencialmente um cadastro simples de clientes para demonstrar habilidades em desenvolvimento backend e frontend.

O backend é implementado em Java com Spring Boot e consiste numa API REST.  Tendo-se uma entidade `Client` que contém as propriedades: *cod*, *nome*, *cpf* e *idade*.

Já o frontend é uma aplicação React simples que basicamente faz chamadas aos endpoints da API por meio da biblioteca axios.

Ao final, a aplicação como um todo é empacotada como um container Docker.


## Pré-requisitos

- Java 17 ou superior
- Docker

## Executando

```
$ git clone https://github.com/mfandrade/sampleapp
$ cd sampleapp
$ docker compose up --build
$ firefox http://localhost:3000
```

## Autor

- Marcelo F Andrade 

## Licença

[MIT License](https://opensource.org/license/mit)
