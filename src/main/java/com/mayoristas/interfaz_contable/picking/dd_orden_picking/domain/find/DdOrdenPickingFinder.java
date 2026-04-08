package com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPicking;
import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPickingQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.exceptions.DdOrdenPickingPersistenceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Servicio de dominio para consultas de {@link DdOrdenPicking}.
 */
@Service
public class DdOrdenPickingFinder {

    private final DdOrdenPickingQueryRepository queryRepository;

    public DdOrdenPickingFinder(DdOrdenPickingQueryRepository queryRepository) {
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdOrdenPickingQueryRepository no puede ser null");
    }

    /**
     * Retorna una lista paginada de entidades.
     */
    public List<DdOrdenPicking> findAll(int limit, int offset) {
        try {
            return queryRepository.find(limit, offset);
        } catch (Exception ex) {
            throw new DdOrdenPickingPersistenceException(ex);
        }
    }
}
