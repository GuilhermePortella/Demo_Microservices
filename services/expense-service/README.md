# expense-service

## Responsabilidade
- Manter o ciclo de vida da despesa (rascunho, enviada, aprovada, rejeitada).
- Orquestrar validacoes e integracoes sincrono.

## Dados
- Expense
- ExpenseItem
- ExpenseStatus
- ExpenseTotals

## API (sugestao)
- POST /expenses
- GET /expenses/{id}
- PATCH /expenses/{id}
- GET /expenses?status=&ownerId=

## Dependencias (sincrono)
- policy-service: validar politica de gastos.
- budget-service: checar orcamento e centro de custo.
- approval-service: iniciar workflow.
- user-service: dados de usuario (direto ou via approval-service).
- attachment-service: upload e vinculo.
- audit-service: registro de eventos.
- notification-service: envio de alertas.

## Eventos (Kafka)
- ExpenseCreated
- ExpenseSubmitted
- ExpenseApproved
- ExpenseRejected

## Observacoes
- Consistencia e trilha de auditoria sao criticas.
