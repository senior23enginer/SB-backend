package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain;

public interface DdLocalesDespReposicionCommandRepository  {

    int create(DdLocalesDespReposicion entity);

    int update(DdLocalesDespReposicion entity);

    int delete(DdLocalesDespReposicionKey key);

}
