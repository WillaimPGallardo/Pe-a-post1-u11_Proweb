package com.empresa.catalogo.factory;

import com.empresa.catalogo.dto.ProductoRequestDTO;
import com.empresa.catalogo.dto.ProductoResponseDTO;
import com.empresa.catalogo.entity.Producto;
import org.springframework.stereotype.Component;

/**
 * Factory que centraliza la construccion y conversion entre Entidad y DTOs.
 * Aplica SRP: su unica responsabilidad es la transformacion de objetos.
 * Inyectable como @Component para uso desde la capa de servicio.
 */
@Component
public class ProductoFactory {

    /**
     * Construye una entidad Producto a partir del DTO de entrada.
     * No asigna el id (lo genera la BD) ni el campo activo (default = true).
     */
    public Producto toEntity(ProductoRequestDTO dto) {
        Producto p = new Producto();
        p.setNombre(dto.getNombre());
        p.setPrecio(dto.getPrecio());
        p.setCategoria(dto.getCategoria());
        return p;
    }

    /**
     * Construye el DTO de respuesta a partir de la entidad persistida.
     * Omite el campo "activo" para no exponer detalles internos.
     */
    public ProductoResponseDTO toResponseDTO(Producto p) {
        ProductoResponseDTO dto = new ProductoResponseDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setPrecio(p.getPrecio());
        dto.setCategoria(p.getCategoria());
        return dto;
    }
}
