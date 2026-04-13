package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.application.find;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.EstadoUsuario;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.find.EstadoUsuarioFinder;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.valueObject.LocalCode;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.valueObject.UsuarioId;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class ConsultarEstadoUsuarioHandler {

    private final EstadoUsuarioFinder finder;

    public ConsultarEstadoUsuarioHandler(EstadoUsuarioFinder finder) {
        this.finder = Objects.requireNonNull(finder, "EstadoUsuarioFinder no puede ser null");
    }

    public Optional<EstadoUsuario> execute(ConsultarEstadoUsuarioQuery query) {
        Objects.requireNonNull(query, "ConsultarEstadoUsuarioQuery no puede ser null");

        UsuarioId usuarioId = new UsuarioId(query.getUsuarioId());
        LocalCode localCode = new LocalCode(query.getLocalCode());

        return finder.obtenerEstado(usuarioId, localCode);
    }
}

