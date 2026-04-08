package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.valueObject;

import java.time.LocalDateTime;
public class DdConfiguracionReposicionFechaActualizacion  {
    private final LocalDateTime value;
    public DdConfiguracionReposicionFechaActualizacion(LocalDateTime value) {
        this.value=value;

    }
    public LocalDateTime getValue() {
        return value;

    }

}
