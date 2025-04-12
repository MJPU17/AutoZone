# AutoZone - Aplicación Spring Boot para Gestión de Vehículos

Este proyecto es una aplicación RESTful desarrollada con **Spring Boot 3.4.4**, que permite la gestión de vehículos de diferentes marcas y tipos (Carros, Motos, Camiones), implementando los patrones de diseño **Singleton**, **Builder**, **Factory** y **Abstract Factory**.

## 🛠 IDE utilizado

- **Eclipse IDE for Enterprise Java and Web Developers - 2024-09**

## 📦 Tecnologías y dependencias principales

- Java 21
- Spring Boot (Data JPA, Web, Validation)
- MySQL
- Hibernate
- Swagger/OpenAPI (Documentación API)
- Maven

## 🏗️ Estructura general

El sistema sigue una arquitectura por capas:

- `model`: Clases entidad que representan los vehículos.
- `repository`: Repositorios JPA.
- `service`: Servicios que implementan operaciones CRUD.
- `controller`: Controladores REST con endpoints documentados.
- `pattern`: Implementaciones de los patrones de diseño.

## 📋 Configuración de base de datos

La aplicación se conecta a una base de datos MySQL. Asegúrate de que exista la base de datos `autozone_database` en tu servidor MySQL antes de ejecutar la aplicación.
