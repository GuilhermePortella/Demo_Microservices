# policy-service

## Responsabilidade
- Centralizar politicas e regras de gastos.
- Validar despesas e determinar limites.

## Dados
- Policy
- Rule
- Limit

## API (sugestao)
- POST /policies/validate
- GET /policies/{id}
- GET /policies?area=

## Dependencias (sincrono)
- Nenhuma dependencia direta.

## Eventos (Kafka)
- PolicyChanged

## Observacoes
- Alteracoes em politicas impactam varios fluxos.
