# 🚗 FordCare API

Uma API robusta desenvolvida em Java com Spring Boot para o gerenciamento inteligente de clientes, veículos e históricos de manutenções automotivas. O sistema conta com documentação interativa e um módulo de análise preditiva para estimativa de custos futuros.

---

# 👨‍💻 Integrantes

- Paulo Poças - RM556080  
- André Luiz Fernandes de Queiroz - RM554503  
- Rafael Bocchi - RM557603  
- Rafael Federici de Oliveira - RM554736  
- Marcos Vinícius da Silva Costa - RM555490  

---

---

## 📌 Funcionalidades

* **Gestão de Clientes & Veículos:** Cadastro completo e associação de proprietários aos seus respectivos automóveis.
* **Histórico de Oficina:** Controle total de ordens de manutenção vinculadas a cada veículo.
* **CRUD Completo:** Operações de criação, leitura, atualização e exclusão para todas as entidades principais.
* **Análise Preditiva:** Algoritmo integrado para previsão de gastos na próxima parada mecânica.
* **Documentação Automática:** Interface interativa para testes de endpoints em tempo real.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 21
* **Framework Principal:** Spring Boot 3.x
* **Persistência de Dados:** Spring Data JPA
* **Banco de Dados:** MySQL
* **Documentação:** Swagger UI / OpenAPI 3
* **Gerenciador de Dependências:** Maven
* **Produtividade:** Lombok

---

## 📂 Estrutura do Projeto

```text
src/main/java/br/com/ford/fordcare
│
├── config/       # Configurações gerais (Swagger, Segurança, etc.)
├── controller/   # Endpoints e exposição da API
├── dto/          # Objetos de Transferência de Dados (Payloads de entrada/saída)
├── entity/       # Modelos de dados mapeados para o banco
├── repository/   # Interfaces de comunicação com o banco de dados
└── service/      # Regras de negócio e lógica de previsão de custos
```

⚙️ Configuração e Inicialização
1. Banco de Dados

Certifique-se de ter o MySQL ativo e configure as credenciais no arquivo src/main/main/resources/application.properties:
Properties

spring.datasource.url=jdbc:mysql://localhost:3306/fordcare?createDatabaseIfNotExist=true&serverTimezone=UTC
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

2. Executando a Aplicação

Abra o terminal na raiz do projeto e execute os comandos abaixo:
Bash

# Clonar o repositório
git clone [https://github.com/seu-usuario/fordcare-api.git](https://github.com/seu-usuario/fordcare-api.git)

# Acessar a pasta do projeto
cd fordcare-api

# Executar a aplicação com o Maven
mvn spring-boot:run

Após a inicialização, a API estará disponível em http://localhost:8080.
📖 Documentação da API (Swagger)

Para visualizar todos os endpoints disponíveis, parâmetros e realizar testes práticos, acesse a interface do Swagger com a aplicação rodando:

👉 http://localhost:8080/swagger-ui.html
📊 Módulo de Análise Preditiva

A API calcula a projeção de gastos para a próxima manutenção do veículo com base em dados históricos acumulados.

    Endpoint: GET /manutencoes/previsao/{veiculoId}

    Variáveis da Previsão:

        Média aritmética dos custos anteriores.

        Frequência/Quantidade de passagens pela oficina.

        Tendência de desgaste e crescimento linear baseada no histórico.

Exemplo de Retorno (JSON)
JSON

{
  "modeloVeiculo": "Ford Fusion Hybrid",
  "quantidadeManutencoes": 3,
  "mediaCustos": 1166.66,
  "previsaoCustoProximaManutencao": 1435.0
}

📝 Exemplos de Payload (JSON)
Criar/Mapear Cliente
JSON

{
  "nome": "Paulo Poças",
  "email": "paulo@email.com",
  "telefone": "11999999999",
  "cnh": "12345678900"
}

Cadastrar Veículo
JSON

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

Registrar Manutenção
JSON

{
  "descricao": "Revisão preventiva",
  "data": "2026-05-10",
  "quilometragem": 23000,
  "custo": 950,
  "veiculoId": 1
}

📚 Arquitetura de Relacionamentos

    Cliente ── (1:N) ──> Veículo: Um cliente cadastrado pode possuir uma frota ou múltiplos veículos vinculados ao seu perfil.

    Veículo ── (1:N) ──> Manutenção: Um veículo acumula um histórico contendo várias ordens de manutenção ao longo de sua vida útil.


