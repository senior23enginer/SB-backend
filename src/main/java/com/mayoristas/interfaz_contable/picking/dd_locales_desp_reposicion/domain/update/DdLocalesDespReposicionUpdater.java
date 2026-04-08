package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicion;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicionCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.create.DdLocalesDespReposicionMapper;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service public class DdLocalesDespReposicionUpdater  {
    private final DdLocalesDespReposicionCommandRepository repo;
    public DdLocalesDespReposicionUpdater(DdLocalesDespReposicionCommandRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public int execute(UpdateDdLocalesDespReposicionCommand c) {
        Objects.requireNonNull(c);
        DdLocalesDespReposicion a=DdLocalesDespReposicionMapper.from(c);
        try {
            int r=repo.update(a);
            if(r!=1) throw new DdLocalesDespReposicionUnexpectedRowsException(r);
            return r;

        }
        catch(DdLocalesDespReposicionUnexpectedRowsException e) {
            throw e;

        }
        catch(Exception e) {
            throw new DdLocalesDespReposicionPersistenceException(e);

        }

    }

}
