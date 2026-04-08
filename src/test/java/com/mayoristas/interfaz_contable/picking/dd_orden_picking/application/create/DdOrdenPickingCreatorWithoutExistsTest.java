package com.mayoristas.interfaz_contable.picking.dd_orden_picking.application.create;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPicking;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPickingQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.create.DdOrdenPickingCreator;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.exceptions.DdOrdenPickingAlreadyExistsException;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdOrdenPickingCreatorWithoutExistsTest  {
    private DdOrdenPickingCreator creator;
    private DdOrdenPickingQueryRepository queryRepository;
    private DdOrdenPickingCreatorWithoutExists useCase;
    @BeforeEach void setUp() {
        creator = mock(DdOrdenPickingCreator.class);
        queryRepository = mock(DdOrdenPickingQueryRepository.class);
        useCase = new DdOrdenPickingCreatorWithoutExists(creator, queryRepository);

    }
    @Test void execute_should_throw_when_exists() {
        when(queryRepository.findById(any())).thenReturn(mock(DdOrdenPicking.class));
        assertThrows(DdOrdenPickingAlreadyExistsException.class, () -> useCase.execute(new DdOrdenPickingCreateWithoutExistsCommand(1L, 1L, "X", 1L, "X", "X", "X")));

    }

}
