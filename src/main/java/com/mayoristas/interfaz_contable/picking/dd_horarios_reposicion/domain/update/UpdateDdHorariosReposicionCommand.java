package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.create.CreateDdHorariosReposicionCommand;
import java.time.LocalDateTime;

public class UpdateDdHorariosReposicionCommand extends CreateDdHorariosReposicionCommand  {
    public UpdateDdHorariosReposicionCommand(Long codigoEmpresaDt, Long idReposicion, LocalDateTime hora, String indDeActivo, LocalDateTime fechaCreacion, String creadoPor, LocalDateTime fechaActualizacion, String actualizadoPor) {
        super(codigoEmpresaDt, idReposicion, hora, indDeActivo, fechaCreacion, creadoPor, fechaActualizacion, actualizadoPor);

    }

}
