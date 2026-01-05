# audit-service

## Responsabilidade
- Manter trilha de auditoria append-only.
- Expor consultas para compliance.

## Dados
- AuditEvent
- Actor
- ResourceRef

## API (sugestao)
- POST /audit/events
- GET /audit/events?resource=&resourceId=
- GET /audit/events/{id}

## Dependencias (sincrono)
- Nenhuma dependencia direta.

## Eventos (Kafka)
- AuditEventRecorded

## Observacoes
- Dados de auditoria nao podem ser alterados ou apagados.
