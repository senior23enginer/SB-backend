package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicion;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicionCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service public class DdHorariosReposicionCreator  {
    private final DdHorariosReposicionCommandRepository repo;
    public DdHorariosReposicionCreator(DdHorariosReposicionCommandRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdHorariosReposicion create(CreateDdHorariosReposicionCommand c) {
        Objects.requireNonNull(c);
        DdHorariosReposicion a=DdHorariosReposicionMapper.from(c);
        try {
            int r=repo.create(a);
            if(r!=1) throw new DdHorariosReposicionUnexpectedRowsException(r);
            return a;

        }
        catch(DdHorariosReposicionUnexpectedRowsException e) {
            throw e;

        }
        catch(Exception e) {
            throw new DdHorariosReposicionPersistenceException(e);

        }

    }

}
