package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.find_by_id;

import java.time.LocalDateTime;
public class FindByIdDdHorariosReposicionQuery  {
    private final Long codigoEmpresaDt;
    private final Long idReposicion;
    private final LocalDateTime hora;
    public FindByIdDdHorariosReposicionQuery(Long codigoEmpresaDt, Long idReposicion, LocalDateTime hora) {
        this.codigoEmpresaDt=codigoEmpresaDt;
        this.idReposicion=idReposicion;
        this.hora=hora;

    }
    public Long getCodigoEmpresaDt() {
        return codigoEmpresaDt;

    }
    public Long getIdReposicion() {
        return idReposicion;

    }
    public LocalDateTime getHora() {
        return hora;

    }

}
