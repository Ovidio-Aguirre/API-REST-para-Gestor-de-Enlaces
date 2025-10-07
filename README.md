# ☕ API REST: Gestor de Enlaces Personales con Spring Boot

Este proyecto es un back-end completo desarrollado en **Java** con el framework **Spring Boot**. Provee una API RESTful para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre una colección de enlaces personales, similar a la funcionalidad de un clon de Linktree.

---

## ✨ Características Principales

* **API REST** con endpoints claros y bien definidos para las cuatro operaciones CRUD.
* Comunicación con base de datos abstraída y gestionada por **Spring Data JPA**.
* Uso de una base de datos en memoria **(H2)** para un desarrollo y pruebas rápidas sin configuración externa.
* Estructura de proyecto profesional siguiendo el patrón **Modelo-Repositorio-Controlador**.
* Servidor web embebido **Tomcat**, configurado automáticamente por Spring Boot.

---

## 💻 Stack Tecnológico

* **Lenguaje**: Java 17
* **Framework**: Spring Boot 3+
* **Dependencias Clave**:
    * `Spring Web`: para la creación de la API REST.
    * `Spring Data JPA`: para la capa de persistencia de datos.
    * `H2 Database`: para la base de datos en memoria.
* **Gestor de Dependencias**: Maven

---

## Endpoints de la API

La API expone los siguientes endpoints bajo la ruta base `/api/enlaces`.

### 1. Obtener todos los enlaces
Recupera una lista de todos los enlaces guardados.

* **Método:** `GET`
* **URL:** `/api/enlaces`
* **Respuesta Exitosa (200 OK):**
    ```json
    [
        {
            "id": 1,
            "titulo": "Mi Portafolio",
            "url": "[https://mi-portafolio.vercel.app](https://mi-portafolio.vercel.app)"
        },
        {
            "id": 2,
            "titulo": "Perfil de LinkedIn",
            "url": "[https://linkedin.com/in/mi-usuario](https://linkedin.com/in/mi-usuario)"
        }
    ]
    ```

### 2. Crear un nuevo enlace
Guarda un nuevo enlace en la base de datos.

* **Método:** `POST`
* **URL:** `/api/enlaces`
* **Cuerpo de la Petición (Body):**
    ```json
    {
        "titulo": "Mi Perfil de GitHub",
        "url": "[https://github.com/mi-usuario](https://github.com/mi-usuario)"
    }
    ```
* **Respuesta Exitosa (200 OK):** Devuelve el objeto creado con su nuevo `id`.

### 3. Actualizar un enlace existente
Modifica la información de un enlace existente a través de su `id`.

* **Método:** `PUT`
* **URL:** `/api/enlaces/{id}` (ej: `/api/enlaces/1`)
* **Cuerpo de la Petición (Body):**
    ```json
    {
        "titulo": "Mi Perfil de GitHub (Actualizado)",
        "url": "[https://github.com/mi-usuario-nuevo](https://github.com/mi-usuario-nuevo)"
    }
    ```
* **Respuesta Exitosa (200 OK):** Devuelve el objeto actualizado.

### 4. Eliminar un enlace
Borra un enlace de la base de datos a través de su `id`.

* **Método:** `DELETE`
* **URL:** `/api/enlaces/{id}` (ej: `/api/enlaces/1`)
* **Respuesta Exitosa (204 No Content):** No devuelve contenido en el cuerpo de la respuesta.

---

## 🚀 Guía de Instalación y Ejecución

Sigue estos pasos para poner en funcionamiento la API en tu entorno local.

### Prerrequisitos
* **JDK 17** (o superior) instalado y configurado.
* **Apache Maven** instalado (opcional, ya que el proyecto incluye el Maven Wrapper).
* Un cliente de API como [Postman](https://www.postman.com/) o la herramienta de cliente HTTP de tu IDE.

### Pasos para Ejecutar

1.  **Clonar el Repositorio**
    * Clona este repositorio en tu máquina local.

2.  **Ejecutar la Aplicación**

    * **Opción A (Recomendada, desde un IDE como IntelliJ IDEA):**
        1.  Abre el proyecto como un proyecto existente (IntelliJ lo reconocerá como un proyecto Maven).
        2.  Navega a `src/main/java/com/portafolio/gestorenlaces/GestorEnlacesApplication.java`.
        3.  Haz clic en el icono de "play" verde al lado del método `main` para iniciar la aplicación.

    * **Opción B (Desde la terminal):**
        1.  Abre una terminal en la raíz del proyecto.
        2.  Ejecuta el siguiente comando (usando el Maven Wrapper incluido):
            ```bash
            ./mvnw spring-boot:run
            ```
            *(En Windows, podrías necesitar usar `mvnw.cmd spring-boot:run`)*

La aplicación se iniciará y estará escuchando peticiones en `http://localhost:8080`.
