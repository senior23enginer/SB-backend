package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.valueObject;

import java.time.LocalDateTime;
public class DdLocalesDespReposicionFechaCreacion  {
    private final LocalDateTime value;
    public DdLocalesDespReposicionFechaCreacion(LocalDateTime value) {
        this.value=value;

    }
    public LocalDateTime getValue() {
        return value;

    }

}
