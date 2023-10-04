# Tareas

API administración de tareas.

## Requisitos

- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) - versión 11 o superior
- [Apache Maven](https://maven.apache.org/download.cgi) - Gestor de la API
- [Git](https://git-scm.com/downloads) - para clonar el repositorio

## Configuración del Proyecto

1. **Clona el Repositorio:**

   ```bash
   git clone https://github.com/RicardoCruzParra/Administradortareas 

2. **Ejecuta la Aplicación:**

   ```bash
   ./mvnw spring-boot:run

- **O si tienes Maven instalado globalmente:**

   ```bash
  mvn spring-boot:run

3. **Endpoints de la API:**

- **Obtener Todas las Tareas:**

   ```bash 
   GET /api/tareas

- **Crear Nueva Tarea:**

   ```bash
   POST /api/tareas

**Body de ejemplo:**

   ```json
   {
   "titulo": "Tarea 1",
   "descripcion": "Descripción de la tarea 1",
   "fechaVencimiento": "2023-12-31",
   "estado": "PENDIENTE"
   }
   ```

**Obtener Tarea por ID:**
   ```bash
   GET /api/tareas/{id}
   ```

**Actualizar Tarea:**

   ```bash
   PUT /api/tareas/{id}
   ```
**Body de ejemplo (para actualizar la tarea con ID 1):**

```json
{
"titulo": "Tarea Actualizada",
"descripcion": "Descripción actualizada",
"fechaVencimiento": "2023-12-31",
"estado": "COMPLETADA"
}
```
**Eliminar Tarea:**

   ```bash
   DELETE /api/tareas/{id}
   ```
4. **Pruebas Locales**

**Puedes utilizar herramientas como Postman para realizar solicitudes a los endpoints de la API y probar diferentes escenarios.**



