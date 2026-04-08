package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.valueObject;

import java.time.LocalDateTime;
public class DdHorariosReposicionHora  {
    private final LocalDateTime value;
    public DdHorariosReposicionHora(LocalDateTime value) {
        this.value=value;

    }
    public LocalDateTime getValue() {
        return value;

    }

}
