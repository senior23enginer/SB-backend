package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultos;
import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultosQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.exceptions.DdDetalleBultosPersistenceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Servicio de dominio para consultas de {@link DdDetalleBultos}.
 */
@Service
public class DdDetalleBultosFinder {

    private final DdDetalleBultosQueryRepository queryRepository;

    public DdDetalleBultosFinder(DdDetalleBultosQueryRepository queryRepository) {
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdDetalleBultosQueryRepository no puede ser null");
    }

    /**
     * Retorna una lista paginada de entidades.
     */
    public List<DdDetalleBultos> findAll(int limit, int offset) {
        try {
            return queryRepository.find(limit, offset);
        } catch (Exception ex) {
            throw new DdDetalleBultosPersistenceException(ex);
        }
    }
}
