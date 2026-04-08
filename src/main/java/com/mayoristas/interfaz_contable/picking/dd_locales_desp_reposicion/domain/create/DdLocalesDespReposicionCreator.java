package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicion;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicionCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service public class DdLocalesDespReposicionCreator  {
    private final DdLocalesDespReposicionCommandRepository repo;
    public DdLocalesDespReposicionCreator(DdLocalesDespReposicionCommandRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdLocalesDespReposicion create(CreateDdLocalesDespReposicionCommand c) {
        Objects.requireNonNull(c);
        DdLocalesDespReposicion a=DdLocalesDespReposicionMapper.from(c);
        try {
            int r=repo.create(a);
            if(r!=1) throw new DdLocalesDespReposicionUnexpectedRowsException(r);
            return a;

        }
        catch(DdLocalesDespReposicionUnexpectedRowsException e) {
            throw e;

        }
        catch(Exception e) {
            throw new DdLocalesDespReposicionPersistenceException(e);

        }

    }

}
