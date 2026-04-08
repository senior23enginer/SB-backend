package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.application.create;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.create.CreateDdHorariosReposicionCommand;
import java.time.LocalDateTime;

/**
 * Comando de aplicación para crear {@link com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicion}
 * validando previamente que no exista por llave primaria.
 */
public class DdHorariosReposicionCreateWithoutExistsCommand extends CreateDdHorariosReposicionCommand {

    public DdHorariosReposicionCreateWithoutExistsCommand(Long codigoEmpresaDt, Long idReposicion, LocalDateTime hora, String indDeActivo, LocalDateTime fechaCreacion, String creadoPor, LocalDateTime fechaActualizacion, String actualizadoPor) {
        super(codigoEmpresaDt, idReposicion, hora, indDeActivo, fechaCreacion, creadoPor, fechaActualizacion, actualizadoPor);
    }
}
