package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.application.create;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePicking;
import java.time.LocalDateTime;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePickingQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.create.DdDetallePickingCreator;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.exceptions.DdDetallePickingAlreadyExistsException;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdDetallePickingCreatorWithoutExistsTest  {
    private DdDetallePickingCreator creator;
    private DdDetallePickingQueryRepository queryRepository;
    private DdDetallePickingCreatorWithoutExists useCase;
    @BeforeEach void setUp() {
        creator = mock(DdDetallePickingCreator.class);
        queryRepository = mock(DdDetallePickingQueryRepository.class);
        useCase = new DdDetallePickingCreatorWithoutExists(creator, queryRepository);

    }
    @Test void execute_should_throw_when_exists() {
        when(queryRepository.findById(any())).thenReturn(mock(DdDetallePicking.class));
        assertThrows(DdDetallePickingAlreadyExistsException.class, () -> useCase.execute(new DdDetallePickingCreateWithoutExistsCommand(1L, 1L, 1L, java.time.LocalDateTime.now(), "X", 1L)));

    }

}
