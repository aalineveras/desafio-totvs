
# Projeto de Pontos Turísticos

Este projeto permite o cadastro e visualização de pontos turísticos e comentários. Ele foi desenvolvido com **Angular 17.3.12**, **PO-UI 7.26.1** e **@totvs/po-theme 7.26.1** para o frontend, e **Spring Boot** para o backend.

## Funcionalidades

- **Tela Inicial**: Exibe a lista de pontos turísticos cadastrados, com barra de pesquisa, botão Novo.
- **Cadastro de Ponto Turístico**: Formulário para adicionar novos pontos com nome do Ponto Turistico, país, cidade, estação do ano e resumo.
- **Detalhes**: Modal exibe informações detalhadas do ponto turístico e seus comentários e botão para comentar.
- **Comentários**: Exibe e permite adicionar novos comentários aos pontos turísticos.

## Backend (Java - Spring Boot)

- **Endpoints**:
  - `GET /ponto-turistico`: Listar pontos turísticos.
  - `POST /ponto-turistico`: Criar um novo ponto turístico.
  - `GET /ponto-turistico/{id}`: Obter detalhes de um ponto turístico.
  - `DELETE /ponto-turistico/{id}`: Excluir ponto turístico.
  - `PUT /ponto-turistico/{id}`: Atualizar ponto turístico.
  - `GET /comentario/{pontoTuristicoId}`: Listar comentários de um ponto.
  - `POST /comentario`: Adicionar um comentário.

## Como Rodar o Projeto

1. Clone o repositório e entre no diretório:
   ```bash
   git clone <URL do seu repositório>
   cd <diretório>
   ```

2. Instale as dependências:
   ```bash
   npm install
   ```

3. Rode o servidor de desenvolvimento:
   ```bash
   ng serve
   ```

4. Acesse o frontend em: `http://localhost:4200/ponto-turistico`.

5. Para o backend, use o comando:
   ```bash
   ./gradlew bootRun
   ```
   Acesse a API em: `http://localhost:8080`.

## Tecnologias

- **Frontend**: Angular 17.3.12, PO-UI 7.26.1, @totvs/po-theme 7.26.1.
- **Backend**: Spring Boot, JPA, H2 (ou outro banco de dados).
- **Postman**: Para testar as APIs.
