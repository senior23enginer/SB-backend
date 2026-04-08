package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.application.find;

/**
 * Query de aplicación para obtener una entidad por su llave primaria.
 */
public class FindByIdDdLocalesDespReposicionQuery extends com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.find_by_id.FindByIdDdLocalesDespReposicionQuery {

    public FindByIdDdLocalesDespReposicionQuery(Long codigoEmpresaDt, Long idReposicion, Long codigoEmpresaDesp, Long loCodigoDesp) {
        super(codigoEmpresaDt, idReposicion, codigoEmpresaDesp, loCodigoDesp);
    }
}
