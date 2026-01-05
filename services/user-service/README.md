# user-service

## Responsabilidade
- Manter colaboradores, perfis e hierarquia.
- Expor dados para aprovadores e notificacoes.

## Dados
- User
- Role
- ManagerRelation
- CostCenterLink

## API (sugestao)
- GET /users/{id}
- GET /users?managerId=
- GET /users?costCenterId=
- PATCH /users/{id}

## Dependencias (sincrono)
- Nenhuma dependencia direta.

## Eventos (Kafka)
- UserUpdated
- RoleUpdated
