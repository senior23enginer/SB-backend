package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.application.find;

/**
 * Query de aplicación para obtener una entidad por su llave primaria.
 */
public class FindByIdDdConfiguracionReposicionQuery extends com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.find_by_id.FindByIdDdConfiguracionReposicionQuery {

    public FindByIdDdConfiguracionReposicionQuery(Long codigoEmpresaDt, Long idReposicion) {
        super(codigoEmpresaDt, idReposicion);
    }
}
