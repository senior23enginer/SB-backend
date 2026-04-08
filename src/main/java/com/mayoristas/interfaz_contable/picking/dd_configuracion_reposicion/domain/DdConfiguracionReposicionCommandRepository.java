package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain;

public interface DdConfiguracionReposicionCommandRepository  {

    int create(DdConfiguracionReposicion entity);

    int update(DdConfiguracionReposicion entity);

    int delete(DdConfiguracionReposicionKey key);

}
