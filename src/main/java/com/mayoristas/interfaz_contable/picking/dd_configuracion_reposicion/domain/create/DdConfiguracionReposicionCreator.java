package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicion;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicionCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service public class DdConfiguracionReposicionCreator  {
    private final DdConfiguracionReposicionCommandRepository repo;
    public DdConfiguracionReposicionCreator(DdConfiguracionReposicionCommandRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public DdConfiguracionReposicion create(CreateDdConfiguracionReposicionCommand c) {
        Objects.requireNonNull(c);
        DdConfiguracionReposicion a=DdConfiguracionReposicionMapper.from(c);
        try {
            int r=repo.create(a);
            if(r!=1) throw new DdConfiguracionReposicionUnexpectedRowsException(r);
            return a;

        }
        catch(DdConfiguracionReposicionUnexpectedRowsException e) {
            throw e;

        }
        catch(Exception e) {
            throw new DdConfiguracionReposicionPersistenceException(e);

        }

    }

}
