package com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.EstadoUsuario;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.EstadoUsuarioQueryRepository;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.exceptions.EstadoUsuarioPersistenceException;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.valueObject.LocalCode;
import com.mayoristas.interfaz_contable.picking.dd_pedido_picking.domain.valueObject.UsuarioId;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * Servicio de dominio para consultas de {@link EstadoUsuario}.
 */
@Service
public class EstadoUsuarioFinder {

    private final EstadoUsuarioQueryRepository queryRepository;

    public EstadoUsuarioFinder(EstadoUsuarioQueryRepository queryRepository) {
        this.queryRepository = Objects.requireNonNull(queryRepository, "EstadoUsuarioQueryRepository no puede ser null");
    }

    /**
     * Obtiene el estado actual del usuario en un local específico.
     *
     * @param usuarioId Identificador del usuario
     * @param localCode Código del local
     * @return Optional con el estado del usuario si existe
     */
    public Optional<EstadoUsuario> obtenerEstado(UsuarioId usuarioId, LocalCode localCode) {
        try {
            return queryRepository.findByUsuarioAndLocal(usuarioId, localCode);
        } catch (Exception ex) {
            throw new EstadoUsuarioPersistenceException(ex);
        }
    }

    /**
     * Verifica si existe un picking en curso para el usuario.
     *
     * @param usuarioId Identificador del usuario
     * @param localCode Código del local
     * @return true si existe un picking con estado "EP"
     */
    public boolean existePickingEnCurso(UsuarioId usuarioId, LocalCode localCode) {
        try {
            return queryRepository.existePickingEnCurso(usuarioId, localCode);
        } catch (Exception ex) {
            throw new EstadoUsuarioPersistenceException(ex);
        }
    }
}

