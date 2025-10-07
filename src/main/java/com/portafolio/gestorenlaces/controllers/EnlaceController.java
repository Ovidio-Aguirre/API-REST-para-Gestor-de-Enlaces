package com.portafolio.gestorenlaces.controllers;

import com.portafolio.gestorenlaces.models.Enlace;
import com.portafolio.gestorenlaces.repositories.EnlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// @RestController combina @Controller y @ResponseBody, marcando esta clase para manejar peticiones REST.
// Spring convertirá automáticamente los objetos Java a JSON.
@RestController
// @RequestMapping establece la ruta base para todos los endpoints en esta clase.
@RequestMapping("/api/enlaces")
public class EnlaceController {

    // @Autowired realiza la inyección de dependencias. Spring automáticamente nos dará una instancia
    // de EnlaceRepository para que podamos usarla.
    @Autowired
    private EnlaceRepository enlaceRepository;

    // --- READ (Leer Todos) ---
    // @GetMapping mapea este método a peticiones GET en "/api/enlaces".
    @GetMapping
    public List<Enlace> getAllEnlaces() {
        return enlaceRepository.findAll();
    }

    // --- READ (Leer por ID) ---
    // @GetMapping mapea este método a peticiones GET en "/api/enlaces/{id}".
    @GetMapping("/{id}")
    public ResponseEntity<Enlace> getEnlaceById(@PathVariable Long id) {
        Optional<Enlace> enlace = enlaceRepository.findById(id);
        // ResponseEntity nos permite controlar la respuesta HTTP, como devolver 404 si no se encuentra.
        return enlace.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // --- CREATE (Crear) ---
    // @PostMapping mapea este método a peticiones POST en "/api/enlaces".
    // @RequestBody le dice a Spring que convierta el JSON del cuerpo de la petición en un objeto Enlace.
    @PostMapping
    public Enlace createEnlace(@RequestBody Enlace enlace) {
        return enlaceRepository.save(enlace);
    }

    // --- UPDATE (Actualizar) ---
    // @PutMapping mapea este método a peticiones PUT en "/api/enlaces/{id}".
    @PutMapping("/{id}")
    public ResponseEntity<Enlace> updateEnlace(@PathVariable Long id, @RequestBody Enlace enlaceDetails) {
        return enlaceRepository.findById(id)
                .map(enlace -> {
                    enlace.setTitulo(enlaceDetails.getTitulo());
                    enlace.setUrl(enlaceDetails.getUrl());
                    Enlace updatedEnlace = enlaceRepository.save(enlace);
                    return ResponseEntity.ok(updatedEnlace);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // --- DELETE (Eliminar) ---
    // @DeleteMapping mapea este método a peticiones DELETE en "/api/enlaces/{id}".
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnlace(@PathVariable Long id) {
        if (!enlaceRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        enlaceRepository.deleteById(id);
        // Devolvemos una respuesta 204 No Content, que es el estándar para un DELETE exitoso.
        return ResponseEntity.noContent().build();
    }
}