package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.valueObject.EstadoPedido;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.valueObject.LocalCode;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.valueObject.UsuarioId;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entidad de dominio que representa el estado actual de un usuario en el sistema de picking.
 */
public class EstadoUsuario {

    private final UsuarioId usuarioId;
    private final LocalCode localCode;
    private final Long idRecvta;
    private final EstadoPedido estadoPedido;
    private final LocalDateTime fechaEstado;

    public EstadoUsuario(
            UsuarioId usuarioId,
            LocalCode localCode,
            Long idRecvta,
            EstadoPedido estadoPedido,
            LocalDateTime fechaEstado
    ) {
        this.usuarioId = Objects.requireNonNull(usuarioId, "usuarioId no puede ser nulo");
        this.localCode = Objects.requireNonNull(localCode, "localCode no puede ser nulo");
        this.idRecvta = Objects.requireNonNull(idRecvta, "idRecvta no puede ser nulo");
        this.estadoPedido = Objects.requireNonNull(estadoPedido, "estadoPedido no puede ser nulo");
        this.fechaEstado = Objects.requireNonNull(fechaEstado, "fechaEstado no puede ser nulo");
    }

    public UsuarioId getUsuarioId() {
        return usuarioId;
    }

    public LocalCode getLocalCode() {
        return localCode;
    }

    public Long getIdRecvta() {
        return idRecvta;
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public LocalDateTime getFechaEstado() {
        return fechaEstado;
    }

    public boolean tienePickingEnCurso() {
        return estadoPedido.isEnPicking();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoUsuario that = (EstadoUsuario) o;
        return Objects.equals(usuarioId, that.usuarioId) &&
                Objects.equals(localCode, that.localCode) &&
                Objects.equals(idRecvta, that.idRecvta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, localCode, idRecvta);
    }

    @Override
    public String toString() {
        return "EstadoUsuario{" +
                "usuarioId=" + usuarioId +
                ", localCode=" + localCode +
                ", idRecvta=" + idRecvta +
                ", estadoPedido=" + estadoPedido +
                ", fechaEstado=" + fechaEstado +
                '}';
    }
}

