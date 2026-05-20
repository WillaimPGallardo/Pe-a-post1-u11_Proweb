package com.empresa.catalogo.exception;

/**
 * Excepcion de negocio lanzada cuando no se encuentra un recurso por su id.
 * Es capturada por GlobalExceptionHandler y traducida a HTTP 404.
 */
public class RecursoNoEncontradoException extends RuntimeException {

    public RecursoNoEncontradoException(String recurso, Long id) {
        super(recurso + " con id " + id + " no encontrado.");
    }
}
