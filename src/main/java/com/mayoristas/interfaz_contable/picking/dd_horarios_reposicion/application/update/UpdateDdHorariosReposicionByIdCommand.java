package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.application.update;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.update.UpdateDdHorariosReposicionCommand;
import java.time.LocalDateTime;

public class UpdateDdHorariosReposicionByIdCommand extends UpdateDdHorariosReposicionCommand  {
    public UpdateDdHorariosReposicionByIdCommand(Long codigoEmpresaDt, Long idReposicion, LocalDateTime hora, String indDeActivo, LocalDateTime fechaCreacion, String creadoPor, LocalDateTime fechaActualizacion, String actualizadoPor) {
        super(codigoEmpresaDt, idReposicion, hora, indDeActivo, fechaCreacion, creadoPor, fechaActualizacion, actualizadoPor);

    }

}
