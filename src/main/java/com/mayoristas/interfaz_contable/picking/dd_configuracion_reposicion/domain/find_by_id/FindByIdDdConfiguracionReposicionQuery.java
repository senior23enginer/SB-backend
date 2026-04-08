package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.find_by_id;

public class FindByIdDdConfiguracionReposicionQuery  {
    private final Long codigoEmpresaDt;
    private final Long idReposicion;
    public FindByIdDdConfiguracionReposicionQuery(Long codigoEmpresaDt, Long idReposicion) {
        this.codigoEmpresaDt=codigoEmpresaDt;
        this.idReposicion=idReposicion;

    }
    public Long getCodigoEmpresaDt() {
        return codigoEmpresaDt;

    }
    public Long getIdReposicion() {
        return idReposicion;

    }

}
