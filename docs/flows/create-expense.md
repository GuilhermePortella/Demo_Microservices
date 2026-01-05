# Fluxo: criar despesa

## Objetivo
Registrar uma despesa com validacao de politica, checagem de orcamento, aprovadores, anexos,
auditoria e notificacao.

## Passos sincronos (estado atual)
1) Cliente envia `POST /expenses` para o expense-service.
2) expense-service valida politica no policy-service.
3) expense-service checa orcamento no budget-service.
4) expense-service inicia workflow no approval-service.
5) approval-service busca aprovadores no user-service.
6) expense-service envia anexos ao attachment-service.
7) expense-service registra auditoria no audit-service.
8) expense-service envia notificacao no notification-service.

## Diagrama de sequencia (simplificado)
```mermaid
sequenceDiagram
  autonumber
  participant Client as Cliente
  participant Expense as expense-service
  participant Policy as policy-service
  participant Budget as budget-service
  participant Approval as approval-service
  participant User as user-service
  participant Attachment as attachment-service
  participant Audit as audit-service
  participant Notification as notification-service

  Client->>Expense: POST /expenses
  Expense->>Policy: validar politica
  Policy-->>Expense: ok/erro
  Expense->>Budget: checar orcamento
  Budget-->>Expense: ok/erro
  Expense->>Approval: iniciar workflow
  Approval->>User: obter aprovadores
  User-->>Approval: lista
  Approval-->>Expense: workflowId
  Expense->>Attachment: upload/vinculo de anexos
  Attachment-->>Expense: attachmentIds
  Expense->>Audit: registrar evento
  Audit-->>Expense: ok
  Expense->>Notification: enviar alerta
  Notification-->>Expense: ok
  Expense-->>Client: despesa criada
```

## Pontos criticos
- Falha em qualquer passo exige compensacao ou reprocesso.
- Consistencia deve ser observada no ciclo de vida da despesa.
- Auditoria nao pode perder eventos, mesmo em erro parcial.
