package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain;

import java.util.List;

public interface DdHorariosReposicionQueryRepository  {

    List<DdHorariosReposicion> find();

    List<DdHorariosReposicion> find(int limit, int offset);

    DdHorariosReposicion findById(DdHorariosReposicionKey key);

}
