package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.application.find;

import java.time.LocalDateTime;
/**
 * Query de aplicación para obtener una entidad por su llave primaria.
 */
public class FindByIdDdHorariosReposicionQuery extends com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.find_by_id.FindByIdDdHorariosReposicionQuery {

    public FindByIdDdHorariosReposicionQuery(Long codigoEmpresaDt, Long idReposicion, LocalDateTime hora) {
        super(codigoEmpresaDt, idReposicion, hora);
    }
}
