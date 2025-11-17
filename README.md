Email Microservice

Desafio Backend Uber
Java Spring | Amazon SES | REST API

Este projeto é um microserviço de envio de e-mails desenvolvido em Java, utilizando Spring Boot e AWS Simple Email Service (SES).
Ele faz parte do desafio técnico do backend da Uber e demonstra como implementar uma solução completa para envio de e-mails usando boas práticas e arquitetura limpa.

📑 Tabela de Conteúdos

Instalação

Configuração

Uso

Endpoints da API

Arquitetura

Contribuição

🚀 Instalação
1. Clone o repositório
git clone https://github.com/seu-usuario/seu-repositorio.git

2. Instale as dependências com Maven
mvn install

🔧 Configuração

Antes de iniciar a aplicação, configure suas credenciais da AWS no arquivo:

src/main/resources/application.properties

Exemplo:

aws.region=us-east-1
aws.accessKeyId=SUA_ACCESS_KEY
aws.secretKey=SUA_SECRET_KEY
server.port=8080


⚠️ Importante:
Sua conta AWS SES deve ter:

Identidade (e-mail remetente) verificada

Destinatário verificado se estiver em modo sandbox

Região configurada corretamente (ex: us-east-1)

▶️ Uso

Inicie a aplicação com o Maven:

mvn spring-boot:run


A API ficará acessível em:

http://localhost:8080

✉️ Endpoints da API
Enviar e-mail

POST /api/email/send

📝 Corpo da requisição (JSON)
{
  "to": "destinatario@email.com",
  "subject": "Assunto do e-mail",
  "body": "Conteúdo da mensagem"
}

✔️ Resposta esperada
{
  "message": "E-mail enviado com sucesso!"
}

🏗 Arquitetura

A estrutura do microserviço segue princípios de arquitetura limpa:

Controllers: recebem as requisições

UseCases/Services: contêm a lógica de negócios

Infra/Ses: comunicação com o AWS SES

Configuration: gerenciamento de beans AWS via Spring

Tecnologias utilizadas:

Java 17

Spring Boot

Maven

AWS SES (Simple Email Service)

🤝 Contribuição

Contribuições são bem-vindas!
Se encontrar algum problema, sugestão ou melhoria:

Abra uma issue

Crie um pull request com uma nova branch

Descreva bem as mudanças feitas

Siga o padrão de estilo e organização já existente no projeto.
