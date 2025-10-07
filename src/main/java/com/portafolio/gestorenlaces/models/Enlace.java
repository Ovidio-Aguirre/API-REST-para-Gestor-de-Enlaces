package com.portafolio.gestorenlaces.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// @Entity le dice a Spring que esta clase es una tabla en la base de datos.
@Entity
// @Table le da un nombre específico a la tabla.
@Table(name = "enlaces")
public class Enlace {

    // @Id marca este campo como la clave primaria (primary key).
    @Id
    // @GeneratedValue configura el ID para que se genere automáticamente y sea autoincremental.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String url;

    // JPA (la tecnología de base de datos) requiere un constructor vacío.
    public Enlace() {
    }

    // Constructor para crear nuevos enlaces fácilmente.
    public Enlace(String titulo, String url) {
        this.titulo = titulo;
        this.url = url;
    }

    // --- Getters y Setters ---
    // Son métodos para obtener y establecer los valores de las propiedades.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}