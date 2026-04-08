package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain;

import java.util.List;

public interface DdLocalesDespReposicionQueryRepository  {

    List<DdLocalesDespReposicion> find();

    List<DdLocalesDespReposicion> find(int limit, int offset);

    DdLocalesDespReposicion findById(DdLocalesDespReposicionKey key);

}
