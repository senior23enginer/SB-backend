package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.application.create;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidos;
import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidosKey;
import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidosQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.create.DdListaOrdenPedidosCreator;
import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.exceptions.DdListaOrdenPedidosAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Caso de uso de aplicación que crea una entidad solo si no existe.
 */
@Service
public class DdListaOrdenPedidosCreatorWithoutExists {

    private final DdListaOrdenPedidosCreator creator;
    private final DdListaOrdenPedidosQueryRepository queryRepository;

    public DdListaOrdenPedidosCreatorWithoutExists(DdListaOrdenPedidosCreator creator, DdListaOrdenPedidosQueryRepository queryRepository) {
        this.creator = Objects.requireNonNull(creator, "DdListaOrdenPedidosCreator no puede ser null");
        this.queryRepository = Objects.requireNonNull(queryRepository, "DdListaOrdenPedidosQueryRepository no puede ser null");
    }

    public DdListaOrdenPedidos execute(DdListaOrdenPedidosCreateWithoutExistsCommand command) {
        Objects.requireNonNull(command, "DdListaOrdenPedidosCreateWithoutExistsCommand no puede ser null");

        if (queryRepository.findById(new DdListaOrdenPedidosKey(command.getCodigoEmpresa(), command.getLoCodigoDesp(), command.getCodigoLista(), command.getCodigoElemento())) != null) {
            throw new DdListaOrdenPedidosAlreadyExistsException(command.getCodigoEmpresa() + "|" + command.getLoCodigoDesp() + "|" + command.getCodigoLista() + "|" + command.getCodigoElemento());
        }

        return creator.create(command);
    }
}
