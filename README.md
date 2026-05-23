🚗 FordCare API

API desenvolvida em Java com Spring Boot para gerenciamento de clientes, veículos e manutenções automotivas, incluindo uma funcionalidade de análise preditiva de custos de manutenção.

📌 Funcionalidades
Cadastro de clientes
Cadastro de veículos
Cadastro de manutenções
Relacionamento entre cliente e veículo
Relacionamento entre veículo e manutenção
CRUD completo
Documentação com Swagger
Simulação de análise preditiva de manutenção
🛠️ Tecnologias Utilizadas
Java 21
Spring Boot
Spring Data JPA
MySQL
Lombok
Swagger / OpenAPI
Maven
📂 Estrutura do Projeto
src/main/java/br/com/ford/fordcare
│
├── controller
├── dto
├── entity
├── repository
├── service
└── config
⚙️ Configuração do Banco de Dados

Configure o arquivo application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/fordcare?createDatabaseIfNotExist=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
▶️ Como Executar o Projeto
1. Clone o projeto
git clone https://github.com/seu-usuario/fordcare-api.git
2. Entre na pasta
cd fordcare-api
3. Execute o projeto
mvn spring-boot:run
📖 Swagger

Após iniciar a aplicação:

http://localhost:8080/swagger-ui.html
👤 Exemplo de Cliente
{
  "nome": "Paulo Poças",
  "email": "paulo@email.com",
  "telefone": "11999999999",
  "cnh": "12345678900"
}
🚘 Exemplo de Veículo
{
  "modelo": "Ford Fusion Hybrid",
  "dataCompra": "2024-11-18",
  "especificacoes": {
    "ano": 2024,
    "quilometragem": 12000,
    "tipodeCombustivel": "HIBRIDO"
  },
  "clienteId": 1
}
🔧 Exemplo de Manutenção
{
  "descricao": "Revisão preventiva",
  "data": "2026-05-10",
  "quilometragem": 23000,
  "custo": 950,
  "veiculoId": 1
}
📊 Análise Preditiva

O sistema possui uma funcionalidade de previsão de custos de manutenção baseada no histórico do veículo.

Endpoint
GET /manutencoes/previsao/{id}
Exemplo de retorno
{
  "modeloVeiculo": "Ford Fusion Hybrid",
  "quantidadeManutencoes": 3,
  "mediaCustos": 1166.66,
  "previsaoCustoProximaManutencao": 1435.0
}

A previsão é calculada utilizando:

média de custos anteriores
quantidade de manutenções
tendência de crescimento baseada no histórico
📚 Relacionamentos
Cliente → Veículo
Um cliente pode possuir vários veículos
Veículo → Manutenção
Um veículo pode possuir várias manutenções
