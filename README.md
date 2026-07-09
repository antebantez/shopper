# shopper
Shopping list application

## Komma igång

### Förutsättningar
- Docker och Docker Compose installerat

### Starta databasen

Projektets använder PostgreSQL som databas, som körs i en Docker-container.

**Starta PostgreSQL:**
```bash
docker-compose up -d
```

Detta startar en PostgreSQL-databas med följande konfiguration:
- **Databas**: `shopper`
- **Användare**: `shopper`
- **Lösenord**: `shopper`
- **Port**: `5433` (mappad till 5432 i containern)
- **Volym**: `shopper-postgres-data` (för att lagra data mellan omstarter)

**Verifiera att databasen är igång:**
```bash
docker-compose ps
```

Du bör se `shopper-postgres` med status `Up`.

### Stoppa databasen

```bash
docker-compose down
```

För att även ta bort volymen med data:
```bash
docker-compose down -v
```
