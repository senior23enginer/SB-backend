package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.update;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicion;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicionCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.create.DdConfiguracionReposicionMapper;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.exceptions.*;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service public class DdConfiguracionReposicionUpdater  {
    private final DdConfiguracionReposicionCommandRepository repo;
    public DdConfiguracionReposicionUpdater(DdConfiguracionReposicionCommandRepository repo) {
        this.repo=Objects.requireNonNull(repo);

    }
    public int execute(UpdateDdConfiguracionReposicionCommand c) {
        Objects.requireNonNull(c);
        DdConfiguracionReposicion a=DdConfiguracionReposicionMapper.from(c);
        try {
            int r=repo.update(a);
            if(r!=1) throw new DdConfiguracionReposicionUnexpectedRowsException(r);
            return r;

        }
        catch(DdConfiguracionReposicionUnexpectedRowsException e) {
            throw e;

        }
        catch(Exception e) {
            throw new DdConfiguracionReposicionPersistenceException(e);

        }

    }

}
