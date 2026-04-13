package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.exceptions;

public class EstadoUsuarioNotFoundException extends RuntimeException {
    public EstadoUsuarioNotFoundException(String message) {
        super(message);
    }

    public EstadoUsuarioNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

