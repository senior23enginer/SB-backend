package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.valueObject.LocalCode;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.valueObject.UsuarioId;

import java.util.Optional;

public interface EstadoUsuarioQueryRepository {

    /**
     * Busca el estado actual del usuario en un local específico.
     *
     * @param usuarioId Identificador del usuario
     * @param localCode Código del local/despachador
     * @return Optional con el estado del usuario si existe
     */
    Optional<EstadoUsuario> findByUsuarioAndLocal(UsuarioId usuarioId, LocalCode localCode);

    /**
     * Verifica si existe un pedido con estado "En Picking" para el usuario en el local.
     *
     * @param usuarioId Identificador del usuario
     * @param localCode Código del local/despachador
     * @return true si existe un pedido con estado "EP", false en caso contrario
     */
    boolean existePickingEnCurso(UsuarioId usuarioId, LocalCode localCode);
}

