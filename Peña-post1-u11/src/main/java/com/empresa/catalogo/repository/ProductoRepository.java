package com.empresa.catalogo.repository;

import com.empresa.catalogo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Patron DAO implementado mediante Spring Data JPA.
 * Hereda CRUD y paginacion de JpaRepository, y declara un query method
 * derivado del nombre para listar solo los productos activos.
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByActivoTrue();
}
