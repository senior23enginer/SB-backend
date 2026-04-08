package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain;

public interface DdHorariosReposicionCommandRepository  {

    int create(DdHorariosReposicion entity);

    int update(DdHorariosReposicion entity);

    int delete(DdHorariosReposicionKey key);

}
