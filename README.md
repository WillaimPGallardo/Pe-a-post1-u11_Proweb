# Catálogo de Productos — Post-Contenido 1 (U11)

**Refactorización con SOLID, DAO/DTO, Factory y `@RestControllerAdvice`**



---

## 1. Descripción

Aplicación Spring Boot que expone una API REST para gestionar un catálogo de productos.

---


## 2. Ejecución

Desde la raíz del proyecto:

```bash
# Compilar
mvn clean compile

# Ejecutar
mvn spring-boot:run
```

La aplicación queda disponible en `http://localhost:8080`.
Consola H2 (opcional) en `http://localhost:8080/h2-console` con JDBC URL `jdbc:h2:mem:catalogodb`, usuario `sa` y contraseña vacía.

---

### Checkpoint 1 — Entidad, DTOs y Factory

```bash
mvn clean compile
```

Debe terminar con `BUILD SUCCESS`. Capturar la salida como <img width="590" height="292" alt="image" src="https://github.com/user-attachments/assets/4f66954a-3966-4ce5-8673-dbe2d2df8c97" />


### Checkpoint 2 — Service con DIP y Repository (DAO)

Arrancar:

```bash
mvn spring-boot:run
```

Listar (vacío):

```bash
curl -i http://localhost:8080/api/productos
# 200 OK, body: []
```

Crear:

```bash
curl -i -X POST http://localhost:8080/api/productos \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Laptop","precio":3500000,"categoria":"ELECTRONICA"}'
# 201 Created, body: {"id":1,"nombre":"Laptop","precio":3500000.0,"categoria":"ELECTRONICA"}
```

Capturar como  <img width="973" height="576" alt="image" src="https://github.com/user-attachments/assets/2252bf0d-8b3b-48f6-9ec9-4953fff4b89d" />


### Checkpoint 3 — GlobalExceptionHandler

Recurso inexistente (404):

```bash
curl -i http://localhost:8080/api/productos/999
# 404 Not Found
# {"status":404,"error":"Not Found","mensaje":"Producto con id 999 no encontrado.","timestamp":"...","path":"/api/productos/999"}
```

Capturar como <img width="973" height="609" alt="image" src="https://github.com/user-attachments/assets/70346e6a-04cb-41f7-b7c0-0651c555ff4c" />
.
