package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.valueObject;

import java.time.LocalDateTime;
public class DdConfiguracionReposicionFechaUltEjec  {
    private final LocalDateTime value;
    public DdConfiguracionReposicionFechaUltEjec(LocalDateTime value) {
        this.value=value;

    }
    public LocalDateTime getValue() {
        return value;

    }

}
