# 📅 Sistema de Agendamento API

API REST para gerenciamento de agendamentos (clínica/barbearia), desenvolvida com **Spring Boot**, seguindo boas práticas de arquitetura e organização de código.

---

## 🚀 Tecnologias Utilizadas

* ☕ Java 21
* 🌱 Spring Boot
* 📦 Spring Data JPA
* 🐬 MySQL
* 🧰 Lombok
* 📄 Swagger (OpenAPI)

---

## 📌 Funcionalidades

✔ Cadastro de clientes
✔ Cadastro de serviços
✔ Criação de agendamentos
✔ Validação para evitar horários duplicados
✔ Uso de DTOs (Request/Response)
✔ API documentada com Swagger

---

## 🧱 Arquitetura do Projeto

O projeto segue o padrão:

Controller → Service → Repository

Além disso:

* Uso de DTO para entrada e saída de dados
* Separação de responsabilidades
* Código limpo e organizado

---

## 🔗 Endpoints Principais

### 👤 Clientes

* `POST /clientes` → Criar cliente
* `GET /clientes` → Listar clientes

### ✂️ Serviços

* `POST /servicos` → Criar serviço
* `GET /servicos` → Listar serviços

### 📅 Agendamentos

* `POST /agendamentos` → Criar agendamento
* `GET /agendamentos` → Listar agendamentos

---

## 🧪 Exemplo de Requisição

```json
{
  "dataHora": "2026-05-10T15:00:00",
  "clienteId": 1,
  "servicoId": 1
}
```

---

## 📖 Documentação (Swagger)

Acesse no navegador:

```
http://localhost:8080/swagger
```

---

## ⚙️ Como rodar o projeto

### 1. Clonar repositório

```
git clone https://github.com/SEU_USUARIO/sistema-agendamento-api.git
```

### 2. Entrar na pasta

```
cd sistema-agendamento-api
```

### 3. Configurar banco de dados

No `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/agendamento_db
spring.datasource.username=root
spring.datasource.password=sua_senha
```

---

### 4. Rodar o projeto

```
./mvnw spring-boot:run
```

---

## 🧠 Regras de Negócio

* Não é permitido criar dois agendamentos no mesmo horário
* Data do agendamento deve ser futura

---

## 🔥 Melhorias Futuras

* Autenticação com JWT
* Controle de usuários (admin/cliente)
* Bloqueio de horários sobrepostos (considerando duração do serviço)
* Deploy com Docker

---

## 👨‍💻 Autor

**Lucas Viana Souza**
Desenvolvedor em formação focado em Backend Java ☕
