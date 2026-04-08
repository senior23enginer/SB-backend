package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.application.create;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPicking;
import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPickingKey;
import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPickingQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.create.DdTemporalOrdenPickingCreator;
import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.exceptions.DdTemporalOrdenPickingAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación que crea una entidad solo si no existe.
 */
@Service
public class DdTemporalOrdenPickingCreatorWithoutExists {

    private final DdTemporalOrdenPickingCreator creator;
    private final DdTemporalOrdenPickingQueryRepository queryRepository;

    public DdTemporalOrdenPickingCreatorWithoutExists(DdTemporalOrdenPickingCreator creator, DdTemporalOrdenPickingQueryRepository queryRepository) {
        this.creator = Objects.requireNonNull(creator, "DdTemporalOrdenPickingCreator no puede ser null");
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdTemporalOrdenPickingQueryRepository no puede ser null");
    }

    public DdTemporalOrdenPicking execute(DdTemporalOrdenPickingCreateWithoutExistsCommand command) {
        Objects.requireNonNull(command, "DdTemporalOrdenPickingCreateWithoutExistsCommand no puede ser null");

        if (queryRepository.findById(new DdTemporalOrdenPickingKey(command.getCodigoEmpresa(), command.getLoCodigo(), command.getSku())) != null) {
            throw new DdTemporalOrdenPickingAlreadyExistsException(command.getCodigoEmpresa() + "|" + command.getLoCodigo() + "|" + command.getSku());
        }

        return creator.create(command);
    }
}
