package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.find_by_id;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicion;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicionKey;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicionQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.exceptions.DdHorariosReposicionNotFoundException;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("ddHorariosReposicionFinderByIdDomain") public class DdHorariosReposicionFinderById  {
    private final DdHorariosReposicionQueryRepository repo;
    public DdHorariosReposicionFinderById(DdHorariosReposicionQueryRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdHorariosReposicion findById(FindByIdDdHorariosReposicionQuery query) {
        Objects.requireNonNull(query);
        DdHorariosReposicion x=repo.findById(new DdHorariosReposicionKey(query.getCodigoEmpresaDt(), query.getIdReposicion(), query.getHora()));
        if(x==null) throw new DdHorariosReposicionNotFoundException(query);
        return x;

    }

}
