package com.empresa.catalogo.service;

import com.empresa.catalogo.dto.ProductoRequestDTO;
import com.empresa.catalogo.dto.ProductoResponseDTO;
import com.empresa.catalogo.entity.Producto;
import com.empresa.catalogo.exception.RecursoNoEncontradoException;
import com.empresa.catalogo.factory.ProductoFactory;
import com.empresa.catalogo.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementacion del servicio de productos.
 *
 * Cumple SRP (Single Responsibility): solo contiene logica de negocio.
 * No accede directamente a la BD (delega en ProductoRepository) ni se ocupa
 * de la conversion entidad/DTO (delega en ProductoFactory).
 *
 * Cumple DIP: depende de las abstracciones (ProductoRepository es interfaz,
 * ProductoFactory esta inyectado por Spring) y se inyectan por constructor.
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repo;
    private final ProductoFactory factory;

    public ProductoServiceImpl(ProductoRepository repo, ProductoFactory factory) {
        this.repo = repo;
        this.factory = factory;
    }

    @Override
    public ProductoResponseDTO crear(ProductoRequestDTO dto) {
        Producto p = factory.toEntity(dto);
        return factory.toResponseDTO(repo.save(p));
    }

    @Override
    public ProductoResponseDTO buscarPorId(Long id) {
        Producto p = repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Producto", id));
        return factory.toResponseDTO(p);
    }

    @Override
    public List<ProductoResponseDTO> listarActivos() {
        return repo.findByActivoTrue().stream()
                .map(factory::toResponseDTO)
                .toList();
    }

    @Override
    public void eliminar(Long id) {
        buscarPorId(id); // valida existencia (lanza 404 si no existe)
        repo.deleteById(id);
    }
}
