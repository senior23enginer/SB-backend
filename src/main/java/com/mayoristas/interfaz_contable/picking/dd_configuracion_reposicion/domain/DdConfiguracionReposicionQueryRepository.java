package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain;

import java.util.List;

public interface DdConfiguracionReposicionQueryRepository  {

    List<DdConfiguracionReposicion> find();

    List<DdConfiguracionReposicion> find(int limit, int offset);

    DdConfiguracionReposicion findById(DdConfiguracionReposicionKey key);

}
