package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.valueObject;

import java.time.LocalDateTime;
public class DdHorariosReposicionFechaCreacion  {
    private final LocalDateTime value;
    public DdHorariosReposicionFechaCreacion(LocalDateTime value) {
        this.value=value;

    }
    public LocalDateTime getValue() {
        return value;

    }

}
