package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicion;
import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicionQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.exceptions.DdHorariosReposicionPersistenceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Servicio de dominio para consultas de {@link DdHorariosReposicion}.
 */
@Service
public class DdHorariosReposicionFinder {

    private final DdHorariosReposicionQueryRepository queryRepository;

    public DdHorariosReposicionFinder(DdHorariosReposicionQueryRepository queryRepository) {
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdHorariosReposicionQueryRepository no puede ser null");
    }

    /**
     * Retorna una lista paginada de entidades.
     */
    public List<DdHorariosReposicion> findAll(int limit, int offset) {
        try {
            return queryRepository.find(limit, offset);
        } catch (Exception ex) {
            throw new DdHorariosReposicionPersistenceException(ex);
        }
    }
}
