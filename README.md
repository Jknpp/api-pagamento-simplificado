# Sistema de Pagamentos

Uma API REST desenvolvida em Java utilizando Spring Boot para gerenciar transferências financeiras entre usuários.

O projeto foi desenvolvido com foco em arquitetura em camadas, organização de código e aplicação de regras de negócio, utilizando persistência em banco de dados relacional e integração com serviços externos.

---

## 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Docker
- OpenFeign
- Maven
- Lombok

---

## 📋 Funcionalidades

- Cadastro de usuários
- Gerenciamento de carteiras
- Transferência de valores entre usuários
- Validação de saldo disponível
- Restrição para usuários do tipo lojista
- Integração com serviço externo para autorização da transferência
- Integração com serviço externo para envio de notificações
- Persistência de dados utilizando MySQL

---

## 🏗 Arquitetura

```
src
├── controller
├── service
├── infrastructure
│   ├── entity
│   ├── repository
│   ├── clients
│   └── exceptions
```

---

## ⚙️ Executando o projeto

### Clone o repositório

```bash
git clone https://github.com/Jknpp/api-pagamento-simplificado.git
```

### Execute o banco de dados

```bash
docker start mysql-spring
```

### Configure o arquivo `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3307/springdb
spring.datasource.username=root
spring.datasource.password=******
```

### Execute a aplicação

Pelo IntelliJ IDEA ou utilizando:

```bash
./mvnw spring-boot:run
```

---

## 📡 Endpoint disponível

### Transferência

**POST** `/transferencia`

```json
{
  "valor": 100.00,
  "pagador": 1,
  "recebedor": 2
}
```

---

## 👨‍💻 Autor

Jairo Karnopp

GitHub: https://github.com/Jknpp
