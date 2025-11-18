# 🎓 Student Course Management System - Backend

Sistema de gestión universitaria desarrollado con Spring Boot que implementa una API RESTful para administrar estudiantes, cursos y matrículas con relación muchos a muchos.

## 👨‍💻 Autor

**Matias Galvan Guerrero**  
TECSUP - Instituto de Educación Superior Tecnológica  
Ciclo: 4to | Curso: Desarrollo de Aplicaciones Web

---

## 🚀 Tecnologías Utilizadas

- **Java 17** - Lenguaje de programación
- **Spring Boot 3.2.0** - Framework principal
- **Spring Data JPA** - Persistencia de datos
- **PostgreSQL** - Base de datos relacional
- **Maven** - Gestión de dependencias
- **Docker** - Contenedorización
- **Render** - Plataforma de despliegue

---

## 📋 Características

- ✅ API RESTful con arquitectura MVC
- ✅ Operaciones CRUD completas para Estudiantes y Cursos
- ✅ Gestión de relación Many-to-Many (Estudiante-Curso)
- ✅ Endpoints para matricular y desmatricular estudiantes
- ✅ Configuración de CORS para integración con frontend
- ✅ Validación de datos con anotaciones JPA
- ✅ Persistencia con PostgreSQL
- ✅ Despliegue automatizado con Docker

---

## 🗂️ Estructura del Proyecto
```
backend/
├── src/
│   ├── main/
│   │   ├── java/com/tecsup/studentcourse/
│   │   │   ├── model/
│   │   │   │   ├── Student.java
│   │   │   │   └── Course.java
│   │   │   ├── repository/
│   │   │   │   ├── StudentRepository.java
│   │   │   │   └── CourseRepository.java
│   │   │   ├── controller/
│   │   │   │   ├── StudentController.java
│   │   │   │   └── CourseController.java
│   │   │   └── StudentCourseApplication.java
│   │   └── resources/
│   │       └── application.properties
├── pom.xml
├── Dockerfile
└── README.md
```

---

## 📡 Endpoints de la API

### **Estudiantes**

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/students` | Listar todos los estudiantes |
| GET | `/api/students/{id}` | Obtener estudiante por ID |
| POST | `/api/students` | Crear nuevo estudiante |
| PUT | `/api/students/{id}` | Actualizar estudiante |
| DELETE | `/api/students/{id}` | Eliminar estudiante |

### **Cursos**

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/courses` | Listar todos los cursos |
| GET | `/api/courses/{id}` | Obtener curso por ID |
| POST | `/api/courses` | Crear nuevo curso |
| PUT | `/api/courses/{id}` | Actualizar curso |
| DELETE | `/api/courses/{id}` | Eliminar curso |

### **Matrículas**

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| POST | `/api/students/{studentId}/courses/{courseId}` | Matricular estudiante en curso |
| DELETE | `/api/students/{studentId}/courses/{courseId}` | Desmatricular estudiante de curso |

---

## 🔧 Configuración Local

### **Requisitos Previos**

- Java JDK 17 o superior
- Maven 3.8+
- PostgreSQL 14+
- Git

### **Instalación**

1. **Clonar el repositorio:**
```bash
git clone https://github.com/iam127/student-course-backend.git
cd student-course-backend
```

2. **Configurar base de datos:**

Crea una base de datos en PostgreSQL:
```sql
CREATE DATABASE university_db;
```

3. **Configurar variables de entorno:**

Edita `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/university_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

4. **Compilar y ejecutar:**
```bash
mvn clean install
mvn spring-boot:run
```

La API estará disponible en: `http://localhost:8080`

---

## 🐳 Despliegue con Docker

### **Construir imagen:**
```bash
docker build -t student-course-api .
```

### **Ejecutar contenedor:**
```bash
docker run -p 8080:8080 \
  -e DB_HOST=tu_host \
  -e DB_PORT=5432 \
  -e DB_NAME=university_db \
  -e DB_USERNAME=tu_usuario \
  -e DB_PASSWORD=tu_password \
  student-course-api
```

---

## 🌐 Despliegue en Render

La aplicación está desplegada en Render y disponible en:

**URL de la API:** https://student-course-api-42yh.onrender.com

### **Variables de Entorno en Render:**
- `DB_HOST`
- `DB_PORT`
- `DB_NAME`
- `DB_USERNAME`
- `DB_PASSWORD`

---

## 📦 Modelo de Datos

### **Student (Estudiante)**
```java
{
  "id": Long,
  "name": String,
  "email": String,
  "phone": String,
  "courses": List<Course>
}
```

### **Course (Curso)**
```java
{
  "id": Long,
  "name": String,
  "code": String,
  "credits": Integer,
  "students": List<Student>
}
```

---

## 🧪 Ejemplos de Uso

### **Crear un estudiante:**
```bash
curl -X POST http://localhost:8080/api/students \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Juan Pérez",
    "email": "juan.perez@tecsup.edu.pe",
    "phone": "987654321"
  }'
```

### **Matricular estudiante en curso:**
```bash
curl -X POST http://localhost:8080/api/students/1/courses/1
```

---

## 🤝 Contribuciones

Este proyecto es parte de un laboratorio académico de TECSUP.

---

## 📄 Licencia

Este proyecto es de uso académico para TECSUP - 2025.

---

## 🔗 Enlaces Relacionados

- **Frontend:** [student-course-frontend](https://github.com/iam127/student-course-frontend)
- **API en Producción:** [https://student-course-api-42yh.onrender.com](https://student-course-api-42yh.onrender.com)
- **Documentación Spring Boot:** [https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)

---

## 📞 Contacto

**Matias Galvan Guerrero**  
Estudiante de Desarrollo de Software - TECSUP  
📧 Email: [tu-email@tecsup.edu.pe]  
🔗 GitHub: [@iam127](https://github.com/iam127)
