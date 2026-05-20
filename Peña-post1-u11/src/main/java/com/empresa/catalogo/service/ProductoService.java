package com.empresa.catalogo.service;

import com.empresa.catalogo.dto.ProductoRequestDTO;
import com.empresa.catalogo.dto.ProductoResponseDTO;

import java.util.List;

/**
 * Contrato del servicio de productos.
 *
 * Aplica DIP (Dependency Inversion Principle): el controlador depende de
 * esta abstraccion y no de su implementacion concreta. Permite, por ejemplo,
 * sustituir la implementacion por un mock en tests o por otra fuente de
 * datos sin tocar el controlador.
 */
public interface ProductoService {

    ProductoResponseDTO crear(ProductoRequestDTO dto);

    ProductoResponseDTO buscarPorId(Long id);

    List<ProductoResponseDTO> listarActivos();

    void eliminar(Long id);
}
