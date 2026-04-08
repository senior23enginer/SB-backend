package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.find_by_id;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicion;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicionKey;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicionQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.exceptions.DdConfiguracionReposicionNotFoundException;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("ddConfiguracionReposicionFinderByIdDomain") public class DdConfiguracionReposicionFinderById  {
    private final DdConfiguracionReposicionQueryRepository repo;
    public DdConfiguracionReposicionFinderById(DdConfiguracionReposicionQueryRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdConfiguracionReposicion findById(FindByIdDdConfiguracionReposicionQuery query) {
        Objects.requireNonNull(query);
        DdConfiguracionReposicion x=repo.findById(new DdConfiguracionReposicionKey(query.getCodigoEmpresaDt(), query.getIdReposicion()));
        if(x==null) throw new DdConfiguracionReposicionNotFoundException(query);
        return x;

    }

}
