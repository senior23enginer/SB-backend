package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.application.create;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidos;
import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidosKey;
import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidosQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.create.DdOrdenPedidosCreator;
import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.exceptions.DdOrdenPedidosAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación que crea una entidad solo si no existe.
 */
@Service
public class DdOrdenPedidosCreatorWithoutExists {

    private final DdOrdenPedidosCreator creator;
    private final DdOrdenPedidosQueryRepository queryRepository;

    public DdOrdenPedidosCreatorWithoutExists(DdOrdenPedidosCreator creator, DdOrdenPedidosQueryRepository queryRepository) {
        this.creator = Objects.requireNonNull(creator, "DdOrdenPedidosCreator no puede ser null");
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdOrdenPedidosQueryRepository no puede ser null");
    }

    public DdOrdenPedidos execute(DdOrdenPedidosCreateWithoutExistsCommand command) {
        Objects.requireNonNull(command, "DdOrdenPedidosCreateWithoutExistsCommand no puede ser null");

        if (queryRepository.findById(new DdOrdenPedidosKey(command.getCodigoEmpresa(), command.getLoCodigoDesp())) != null) {
            throw new DdOrdenPedidosAlreadyExistsException(command.getCodigoEmpresa() + "|" + command.getLoCodigoDesp());
        }

        return creator.create(command);
    }
}
