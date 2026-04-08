package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicion;
import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicionQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.exceptions.DdConfiguracionReposicionPersistenceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Servicio de dominio para consultas de {@link DdConfiguracionReposicion}.
 */
@Service
public class DdConfiguracionReposicionFinder {

    private final DdConfiguracionReposicionQueryRepository queryRepository;

    public DdConfiguracionReposicionFinder(DdConfiguracionReposicionQueryRepository queryRepository) {
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdConfiguracionReposicionQueryRepository no puede ser null");
    }

    /**
     * Retorna una lista paginada de entidades.
     */
    public List<DdConfiguracionReposicion> findAll(int limit, int offset) {
        try {
            return queryRepository.find(limit, offset);
        } catch (Exception ex) {
            throw new DdConfiguracionReposicionPersistenceException(ex);
        }
    }
}
