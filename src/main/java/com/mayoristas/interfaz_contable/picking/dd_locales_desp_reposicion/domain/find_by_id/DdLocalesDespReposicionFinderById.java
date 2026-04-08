package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.find_by_id;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicion;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicionKey;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicionQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.exceptions.DdLocalesDespReposicionNotFoundException;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("ddLocalesDespReposicionFinderByIdDomain") public class DdLocalesDespReposicionFinderById  {
    private final DdLocalesDespReposicionQueryRepository repo;
    public DdLocalesDespReposicionFinderById(DdLocalesDespReposicionQueryRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdLocalesDespReposicion findById(FindByIdDdLocalesDespReposicionQuery query) {
        Objects.requireNonNull(query);
        DdLocalesDespReposicion x=repo.findById(new DdLocalesDespReposicionKey(query.getCodigoEmpresaDt(), query.getIdReposicion(), query.getCodigoEmpresaDesp(), query.getLoCodigoDesp()));
        if(x==null) throw new DdLocalesDespReposicionNotFoundException(query);
        return x;

    }

}
