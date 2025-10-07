package com.portafolio.gestorenlaces.repositories;

import com.portafolio.gestorenlaces.models.Enlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository le indica a Spring que esta interfaz es un componente de acceso a datos.
@Repository
public interface EnlaceRepository extends JpaRepository<Enlace, Long> {
    // ¡Eso es todo!
    // Al extender JpaRepository<Enlace, Long>, Spring Data JPA nos proveerá automáticamente
    // todos los métodos CRUD que necesitamos para la entidad "Enlace" cuya clave primaria es de tipo "Long".
    //
    // Métodos ya disponibles:
    // - save(Enlace enlace) -> para crear o actualizar
    // - findAll() -> para obtener todos
    // - findById(Long id) -> para buscar uno por ID
    // - deleteById(Long id) -> para eliminar uno por ID
    // - y muchos más...
}