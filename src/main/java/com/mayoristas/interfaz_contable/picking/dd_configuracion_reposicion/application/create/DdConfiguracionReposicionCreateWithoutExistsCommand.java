package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.application.create;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.create.CreateDdConfiguracionReposicionCommand;
import java.time.LocalDateTime;

/**
 * Comando de aplicación para crear {@link com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicion}
 * validando previamente que no exista por llave primaria.
 */
public class DdConfiguracionReposicionCreateWithoutExistsCommand extends CreateDdConfiguracionReposicionCommand {

    public DdConfiguracionReposicionCreateWithoutExistsCommand(Long codigoEmpresaDt, Long idReposicion, String nombre, LocalDateTime fechaUltEjec, String indDeActivo, LocalDateTime fechaCreacion, String creadoPor, LocalDateTime fechaActualizacion, String actualizadoPor) {
        super(codigoEmpresaDt, idReposicion, nombre, fechaUltEjec, indDeActivo, fechaCreacion, creadoPor, fechaActualizacion, actualizadoPor);
    }
}
