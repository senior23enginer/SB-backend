package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPicking;
import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPickingQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.exceptions.DdTemporalOrdenPickingPersistenceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Servicio de dominio para consultas de {@link DdTemporalOrdenPicking}.
 */
@Service
public class DdTemporalOrdenPickingFinder {

    private final DdTemporalOrdenPickingQueryRepository queryRepository;

    public DdTemporalOrdenPickingFinder(DdTemporalOrdenPickingQueryRepository queryRepository) {
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdTemporalOrdenPickingQueryRepository no puede ser null");
    }

    /**
     * Retorna una lista paginada de entidades.
     */
    public List<DdTemporalOrdenPicking> findAll(int limit, int offset) {
        try {
            return queryRepository.find(limit, offset);
        } catch (Exception ex) {
            throw new DdTemporalOrdenPickingPersistenceException(ex);
        }
    }
}
