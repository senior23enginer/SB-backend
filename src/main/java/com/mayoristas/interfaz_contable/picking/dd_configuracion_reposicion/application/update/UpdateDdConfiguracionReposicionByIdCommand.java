package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.application.update;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.update.UpdateDdConfiguracionReposicionCommand;

import java.time.LocalDateTime;

public class UpdateDdConfiguracionReposicionByIdCommand extends UpdateDdConfiguracionReposicionCommand  {

    public UpdateDdConfiguracionReposicionByIdCommand(Long codigoEmpresaDt, Long idReposicion, String nombre, LocalDateTime fechaUltEjec, String indDeActivo, LocalDateTime fechaCreacion, String creadoPor, LocalDateTime fechaActualizacion, String actualizadoPor)  {

        super(codigoEmpresaDt, idReposicion, nombre, fechaUltEjec, indDeActivo, fechaCreacion, creadoPor, fechaActualizacion, actualizadoPor);

    }

}
