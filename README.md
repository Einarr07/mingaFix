# 🚀 Minga Fix

Aplicación para reportar problemas en la ciudad, donde cualquier persona puede generar un reporte sobre algo que
considere incorrecto o que necesite atención (ej: baches, daños, basura, etc.).

## 📌 Objetivo

El propósito de la aplicación es **centralizar los reportes ciudadanos** en una sola plataforma digital, de manera que
la administración pública o entidades responsables puedan identificar y dar seguimiento a incidencias dentro de la
ciudad.

## 🧑🏽‍💻 Entidades

- **Reporte:** Representa un reporte ciudadano sobre un problema detectado en la ciudad (con foto, categoría, ubicación
  geográfica).

## 🚀 Funcionalidades

### Reporte Controller

- `GET /api-reportes/todos` → Lista todos los reportes
- `GET /api-reportes/unico/{id}` → Obtiene un reporte por su id
- `POST /api-reportes/crear` → Crea un nuevo reporte
- `PUT /api-reportes/actualizar/{id}` → Actualiza un reporte existente
- `DELETE /api-reportes/eliminar/{id}` → Elimina un reporte

### Home Controller

- `GET /` → Página de bienvenida o endpoint raíz

---

## ⚙️ Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL (Base de datos)
- Gradle
- Docker
- Swagger (documentación de la API)

---

## 📂 Estructura del proyecto

```bash
src/main/java/com/mingaFix/mingaFix/
├── MingaFixApplication.java
├── config/         # Configuraciones (Swagger, etc.)
├── domain/         # Lógica de dominio (DTOs, excepciones, repositorios, servicios)
│   ├── dto/        # Clases DTO (ReporteDto, ActualizarReporteDto)
│   ├── exception/  # Excepciones personalizadas
│   ├── repository/ # Interfaces del dominio
│   ├── service/    # Servicios de dominio
│   └── translate/  # Utilidades (ej: categorías)
├── persistence/    # Capa de persistencia
│   ├── crud/       # Interfaces CRUD (JPA)
│   ├── entity/     # Entidades JPA (ReporteEntity)
│   ├── mapper/     # Mappers con MapStruct
│   └── repository/ # Repositorios de persistencia
├── web/            # Capa web
│   ├── config/     # Configuración adicional
│   ├── controller/ # Controladores REST
│   └── exception/  # Manejo global de errores
```

---

## Base de datos

- **Motor:** PostgreSQL

### Tabla principal: `reporte`

| Campo     | Tipo   | Restricciones           |
|-----------|--------|-------------------------|
| idReporte | Long   | PK, autoincrement       |
| photo     | String | Not Null                |
| category  | String | Not Null, máx 100 chars |
| latitude  | Double | Not Null                |
| longitude | Double | Not Null                |

