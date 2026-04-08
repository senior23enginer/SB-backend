package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePicking;
import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePickingQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.exceptions.DdDetallePickingPersistenceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Servicio de dominio para consultas de {@link DdDetallePicking}.
 */
@Service
public class DdDetallePickingFinder {

    private final DdDetallePickingQueryRepository queryRepository;

    public DdDetallePickingFinder(DdDetallePickingQueryRepository queryRepository) {
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdDetallePickingQueryRepository no puede ser null");
    }

    /**
     * Retorna una lista paginada de entidades.
     */
    public List<DdDetallePicking> findAll(int limit, int offset) {
        try {
            return queryRepository.find(limit, offset);
        } catch (Exception ex) {
            throw new DdDetallePickingPersistenceException(ex);
        }
    }
}
