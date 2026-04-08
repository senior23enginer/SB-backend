package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.create.CreateDdConfiguracionReposicionCommand;
import java.time.LocalDateTime;

public class UpdateDdConfiguracionReposicionCommand extends CreateDdConfiguracionReposicionCommand  {
    public UpdateDdConfiguracionReposicionCommand(Long codigoEmpresaDt, Long idReposicion, String nombre, LocalDateTime fechaUltEjec, String indDeActivo, LocalDateTime fechaCreacion, String creadoPor, LocalDateTime fechaActualizacion, String actualizadoPor) {
        super(codigoEmpresaDt, idReposicion, nombre, fechaUltEjec, indDeActivo, fechaCreacion, creadoPor, fechaActualizacion, actualizadoPor);

    }

}
