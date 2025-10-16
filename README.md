## Projects
- `backend-springboot/` — Spring Boot CRUD API (JPA, Validation, Security, Swagger)
- `backend-javaee/` — Jakarta EE (JAX-RS, CDI, JPA, JAAS) deployable to WildFly/JBoss
- `frontend-angular/` — Angular UI (service + component to call the backend)
- `infra/` — Jenkinsfile, Dockerfiles, local dev helpers

## Quickstart
```bash
# Spring Boot
cd backend-springboot
./mvnw spring-boot:run  # or: mvn spring-boot:run

# Java EE (WildFly)
cd backend-javaee
mvn clean package
# copy target/*.war to WILDFLY_HOME/standalone/deployments

# Angular (requires Node + @angular/cli)
cd frontend-angular
npm install
npm start
```

## Endpoints
- Spring Boot CRUD: `http://localhost:8080/employees`
- Angular dev server: `http://localhost:4200`

## Security & Compliance Highlights
- Constructor-based DI, layered arch, bean validation, global error handler.
- Spring Security (RBAC), EE roles via `web.xml`/`@RolesAllowed`.
- No secrets in code; use env vars. Structured logging without PII.
- CI pipeline with Maven build + test; add SonarQube gate as needed.
```

