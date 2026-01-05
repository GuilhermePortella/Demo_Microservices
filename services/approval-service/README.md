# approval-service

## Responsabilidade
- Gerir workflow de aprovacao e decisoes.
- Determinar aprovadores com base em regras e hierarquia.

## Dados
- Approval
- ApprovalStep
- ApproverDecision

## API (sugestao)
- POST /approvals
- GET /approvals/{id}
- POST /approvals/{id}/decisions
- GET /approvals?expenseId=

## Dependencias (sincrono)
- user-service: hierarquia e perfis.
- policy-service: regras de aprovacao.
- audit-service: registrar decisoes.

## Eventos (Kafka)
- ApprovalStarted
- ApprovalStepCompleted
- ApprovalCompleted

## Stack
- Java 17
- Spring Boot 3.2

## Como rodar (dev)
```bash
mvn spring-boot:run
```
