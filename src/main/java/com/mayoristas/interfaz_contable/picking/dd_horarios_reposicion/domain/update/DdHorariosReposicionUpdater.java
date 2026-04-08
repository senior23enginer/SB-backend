package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicion;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicionCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.create.DdHorariosReposicionMapper;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service public class DdHorariosReposicionUpdater  {
    private final DdHorariosReposicionCommandRepository repo;
    public DdHorariosReposicionUpdater(DdHorariosReposicionCommandRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public int execute(UpdateDdHorariosReposicionCommand c) {
        Objects.requireNonNull(c);
        DdHorariosReposicion a=DdHorariosReposicionMapper.from(c);
        try {
            int r=repo.update(a);
            if(r!=1) throw new DdHorariosReposicionUnexpectedRowsException(r);
            return r;

        }
        catch(DdHorariosReposicionUnexpectedRowsException e) {
            throw e;

        }
        catch(Exception e) {
            throw new DdHorariosReposicionPersistenceException(e);

        }

    }

}
