# budget-service

## Responsabilidade
- Gerir orcamento e centros de custo.
- Validar disponibilidade para despesas.

## Dados
- Budget
- CostCenter
- Allocation
- Balance

## API (sugestao)
- POST /budgets/check
- GET /budgets/{id}
- GET /cost-centers/{id}

## Dependencias (sincrono)
- audit-service: registrar bloqueios e consumos.

## Eventos (Kafka)
- BudgetReserved
- BudgetReleased

## Stack
- Java 17
- Spring Boot 3.2

## Como rodar (dev)
```bash
mvn spring-boot:run
```
