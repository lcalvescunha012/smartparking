# Sistema de Parquímetro
Este projeto é um sistema de controle de estacionamento que utiliza Spring Boot no back-end e MongoDB como banco de dados. A aplicação permite gerenciar zonas de estacionamento, controlar parquímetros, registrar veículos, processar pagamentos e monitorar o tempo de estacionamento.

# Funcionalidades Principais:
Gestão de Zonas de Estacionamento: Controle e configuração de diferentes áreas de estacionamento.
Controle de Parquímetros: Gerenciamento e monitoramento do status dos parquímetros.
Registro de Veículos: Cadastro e consulta de veículos estacionados.
Pagamentos e Controle de Tempo: Processamento de pagamentos e acompanhamento do tempo de uso do estacionamento.

# Documentação da API:
A documentação da API está disponível no Swagger, que pode ser acessada em:

http://localhost:8080/swagger-ui/index.html

# Executando o Projeto com Docker:
Caso não tenha o Docker instalado, acesse https://docs.docker.com/compose/install/ para baixar e instalar.

Com o Docker instalado, siga os passos abaixo para subir o projeto:

Navegue até o diretório do projeto.
Execute o comando:
``` shell script
docker-compose up -d
```
Após a execução, a aplicação estará disponível em http://localhost:8080.

