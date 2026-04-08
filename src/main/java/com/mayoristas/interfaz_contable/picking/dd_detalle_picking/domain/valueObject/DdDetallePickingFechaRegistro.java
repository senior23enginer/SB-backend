package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.valueObject;

import java.time.LocalDateTime;
public class DdDetallePickingFechaRegistro  {
    private final LocalDateTime value;
    public DdDetallePickingFechaRegistro(LocalDateTime value) {
        this.value=value;

    }
    public LocalDateTime getValue() {
        return value;

    }

}
