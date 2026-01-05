# notification-service

## Responsabilidade
- Enviar email/slack e registrar status.
- Abstrair provedores de notificacao.

## Dados
- Notification
- Channel
- DeliveryStatus

## API (sugestao)
- POST /notifications
- GET /notifications/{id}

## Dependencias (sincrono)
- user-service: resolver canais/contatos.
- audit-service: registrar envio.

## Eventos (Kafka)
- NotificationSent
- NotificationFailed

## Stack
- Java 17
- Spring Boot 3.2

## Como rodar (dev)
```bash
mvn spring-boot:run
```
