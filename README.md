# 🛡️ Spring Boot Web API – Sistema de Autenticação de Usuários

Este projeto é uma API backend desenvolvida com **Spring Boot** e **Java**, como parte de um desafio técnico. A aplicação simula um sistema de autenticação com funcionalidades como:

- Criação de usuários
- Login
- Reset de senha
- Tela inicial (home)

A base de dados utilizada é o **H2 em memória**, integrada via **Spring Data JPA**, com documentação interativa via **Swagger**.

---

## ⚙️ Tecnologias e ferramentas utilizadas

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- Banco de dados H2 (em memória)
- Swagger (OpenAPI)
- Gradle (groovy)

---

## 🧱 Estrutura e boas práticas

O projeto segue boas práticas de arquitetura e organização de código:

- Separação clara em camadas: `controller`, `service`, `repository`, `dto`, `model`, e `infra`
- Uso de `DTOs` para transporte seguro de dados
- Autenticação e autorização configuradas com Spring Security
- Tratamento de exceções centralizado
- Código limpo e comentado quando necessário
- Swagger disponível para facilitar testes manuais

---

## 🚀 Como executar o projeto localmente

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/FelipeIgansi/usersystemlogin-back.git
   cd nome-do-repositorio (usersystemlogin)

🔐 Segurança

A API implementa autenticação baseada em token (ex: JWT) com o uso do Spring Security, garantindo:

    Senhas criptografadas (BCrypt)

    Proteção de endpoints sensíveis

    Controle de sessão por token

👤 Usuário padrão para testes

A aplicação cria automaticamente um usuário padrão na inicialização, útil para testes manuais:

    E-mail: user@teste.com

    Senha: 123456789

Você pode usar essas credenciais para testar os endpoints de autenticação.
📚 Endpoints disponíveis

Todos os endpoints estão documentados via Swagger:

    Acesse: http://localhost:8080/swagger-ui/index.html


Endpoints principais:

| Método | Endpoint                   | Descrição                  |
| ------ | -------------------------- | -------------------------- |
| POST   | `/api/auth/register`       | Cadastro de novo usuário   |
| POST   | `/api/auth/login`          | Login e geração de token   |
| POST   | `/api/auth/reset-password` | Reset de senha             |
| GET    | `/api/home`                | Página inicial autenticada |

