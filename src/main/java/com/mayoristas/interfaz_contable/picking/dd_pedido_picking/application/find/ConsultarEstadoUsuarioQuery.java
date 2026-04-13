package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.application.find;

import java.util.Objects;

public class ConsultarEstadoUsuarioQuery {

    private final String usuarioId;
    private final Long localCode;

    public ConsultarEstadoUsuarioQuery(String usuarioId, Long localCode) {
        this.usuarioId = Objects.requireNonNull(usuarioId, "usuarioId no puede ser null");
        this.localCode = Objects.requireNonNull(localCode, "localCode no puede ser null");
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public Long getLocalCode() {
        return localCode;
    }
}

