package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.application.create;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultos;
import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultosKey;
import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultosQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.create.DdDetalleBultosCreator;
import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.exceptions.DdDetalleBultosAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación que crea una entidad solo si no existe.
 */
@Service
public class DdDetalleBultosCreatorWithoutExists {

    private final DdDetalleBultosCreator creator;
    private final DdDetalleBultosQueryRepository queryRepository;

    public DdDetalleBultosCreatorWithoutExists(DdDetalleBultosCreator creator, DdDetalleBultosQueryRepository queryRepository) {
        this.creator = Objects.requireNonNull(creator, "DdDetalleBultosCreator no puede ser null");
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdDetalleBultosQueryRepository no puede ser null");
    }

    public DdDetalleBultos execute(DdDetalleBultosCreateWithoutExistsCommand command) {
        Objects.requireNonNull(command, "DdDetalleBultosCreateWithoutExistsCommand no puede ser null");

        if (queryRepository.findById(new DdDetalleBultosKey(command.getCodigoEtiqueta(), command.getInventoryItemId())) != null) {
            throw new DdDetalleBultosAlreadyExistsException(command.getCodigoEtiqueta() + "|" + command.getInventoryItemId());
        }

        return creator.create(command);
    }
}
