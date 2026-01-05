# attachment-service

## Responsabilidade
- Upload e storage de anexos.
- Vincular anexos a despesas e auditoria.

## Dados
- Attachment
- AttachmentLink
- StorageRef

## API (sugestao)
- POST /attachments
- GET /attachments/{id}
- DELETE /attachments/{id}

## Dependencias (sincrono)
- audit-service: registrar upload/remocao.

## Eventos (Kafka)
- AttachmentUploaded
- AttachmentDeleted
