# 📧 Microserviço de Notificação por Email

Este microserviço é responsável pelo **envio de notificações por email** relacionadas às tarefas dos usuários dentro da arquitetura de microsserviços.

Ele recebe informações de tarefas e dispara emails formatados, utilizando templates HTML.

---

## 🧩 Papel na Arquitetura

Este serviço atua como o **responsável pelas notificações do sistema**, sendo integrado com:

* 📅 **Microserviço de Tarefas** → fornece os dados da tarefa
* 👤 **Microserviço de Usuários** → fornece o email do usuário

---

## 🚀 Funcionalidades

* 📧 Envio de email baseado em tarefas
* 🧾 Template HTML dinâmico (Thymeleaf)
* 📨 Personalização de conteúdo (nome, data, descrição)
* ⚠️ Tratamento de falhas no envio

---

## ⚙️ Como Funciona

1. O microserviço recebe uma requisição com os dados da tarefa
2. Processa as informações
3. Injeta os dados em um template HTML
4. Envia o email para o usuário

---

## 📂 Estrutura

### 📌 Service (`EmailService`)

Responsável pelo envio de emails:

* Criação da mensagem (`MimeMessage`)
* Configuração de remetente e destinatário
* Processamento de template com Thymeleaf
* Envio via `JavaMailSender`

---

### 🌐 Controller (`EmailController`)

Disponibiliza endpoint para envio de emails:

---

## 🔗 Endpoint

### 📧 Enviar notificação por email

```id="e1"
POST /email
```

**Body:**

```json id="e2"
{
  "nomeTarefa": "Reunião com cliente",
  "dataEvento": "2026-03-18T15:00:00",
  "descricao": "Reunião para alinhamento do projeto",
  "emailUsuario": "usuario@email.com"
}
```

**Resposta:**

* `200 OK` → Email enviado com sucesso

---

## 🧠 Regras de Negócio

* 📌 O email é enviado com base nos dados da tarefa
* 🧾 O conteúdo é gerado via template HTML (`notificacao.html`)
* 📬 O destinatário é o email do usuário vinculado à tarefa
* ❌ Em caso de erro, é lançada exceção personalizada

---

## 🎨 Template de Email

O serviço utiliza **Thymeleaf** para renderizar templates HTML dinâmicos:

Variáveis disponíveis no template:

* `nomeTarefa`
* `dataEvento`
* `descricao`

---

## 🔒 Configuração de Email

As configurações são feitas via `application.properties` ou variáveis de ambiente:

```id="e3"
envio.email.remetente=seuemail@email.com
envio.email.nomeRemetente=Sistema de Tarefas
```

---

## ⚠️ Tratamento de Erros

* `EmailException` → Erro ao enviar email
* Possíveis causas:

  * Falha de conexão SMTP
  * Credenciais inválidas
  * Erro no template

---

## 🛠️ Tecnologias Utilizadas

* Java 21
* Spring Boot
* Spring Mail (`JavaMailSender`)
* Thymeleaf
* Lombok

---

## 🔄 Fluxo na Arquitetura

1. 📅 Tarefa é criada no microserviço de tarefas
2. 📤 Dados da tarefa são enviados para o microserviço de notificação
3. 📧 Email é gerado e enviado ao usuário
4. 🔄 Status da tarefa pode ser atualizado (ex: ENVIADO)

---

## 🔗 Integração com Outros Microsserviços

* 📅 **Tarefas Service**

  * Envia dados da tarefa para notificação

* 👤 **Usuário Service**

  * Fornece email do destinatário

---


## 📌 Observações

* O envio atual é **síncrono**
* Pode ser facilmente adaptado para processamento assíncrono
* Ideal para ser integrado com mensageria em produção

---

## 👨‍💻 Autor

Projeto desenvolvido com foco em:

* Arquitetura de microsserviços
* Envio de emails com Spring
* Templates dinâmicos com Thymeleaf
* Integração entre serviços
