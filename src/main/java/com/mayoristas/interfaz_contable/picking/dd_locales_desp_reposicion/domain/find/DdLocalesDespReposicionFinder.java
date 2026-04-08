package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicion;
import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicionQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.exceptions.DdLocalesDespReposicionPersistenceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Servicio de dominio para consultas de {@link DdLocalesDespReposicion}.
 */
@Service
public class DdLocalesDespReposicionFinder {

    private final DdLocalesDespReposicionQueryRepository queryRepository;

    public DdLocalesDespReposicionFinder(DdLocalesDespReposicionQueryRepository queryRepository) {
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdLocalesDespReposicionQueryRepository no puede ser null");
    }

    /**
     * Retorna una lista paginada de entidades.
     */
    public List<DdLocalesDespReposicion> findAll(int limit, int offset) {
        try {
            return queryRepository.find(limit, offset);
        } catch (Exception ex) {
            throw new DdLocalesDespReposicionPersistenceException(ex);
        }
    }
}
