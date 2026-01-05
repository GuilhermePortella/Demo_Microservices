# MSvsMM

Projeto de referencia para uma plataforma interna de aprovacao de despesas e reembolsos.
Este repositorio documenta o contexto, a arquitetura escolhida e a estrutura dos servicos.

## Contexto do produto
- Plataforma enterprise usada por 2-3 areas.
- Volume baixo/medio, com picos no fim do mes.
- Time: 6 devs (1 squad).
- Regras muito acopladas: politica de gastos, centro de custo, orcamento, compliance, anexos, auditoria.
- Necessidade forte: trilha de auditoria e consistencia (nao pode "sumir" estado).

## Arquitetura escolhida
- Microservicos com REST sincrono.
- Kafka no meio (uso atual limitado).
- Uma base por servico no papel, com duplicacao de dados e replicacao manual.

## Servicos
- `services/expense-service/README.md`
- `services/approval-service/README.md`
- `services/policy-service/README.md`
- `services/user-service/README.md`
- `services/budget-service/README.md`
- `services/notification-service/README.md`
- `services/attachment-service/README.md`
- `services/audit-service/README.md`

## Documentacao
- Visao geral: `docs/architecture.md`
- Fluxo "criar despesa": `docs/flows/create-expense.md`

## Estrutura do repositorio
```
.
├─ docs/
│  ├─ architecture.md
│  └─ flows/
│     └─ create-expense.md
└─ services/
   ├─ expense-service/
   ├─ approval-service/
   ├─ policy-service/
   ├─ user-service/
   ├─ budget-service/
   ├─ notification-service/
   ├─ attachment-service/
   └─ audit-service/
```
