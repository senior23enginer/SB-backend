package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.exceptions;

public class EstadoUsuarioPersistenceException extends RuntimeException {
    public EstadoUsuarioPersistenceException(String message) {
        super(message);
    }

    public EstadoUsuarioPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public EstadoUsuarioPersistenceException(Throwable cause) {
        super("Error en la persistencia de EstadoUsuario", cause);
    }
}

