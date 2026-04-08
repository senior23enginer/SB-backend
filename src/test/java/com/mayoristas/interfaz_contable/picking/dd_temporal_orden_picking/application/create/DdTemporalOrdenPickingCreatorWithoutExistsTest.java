package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.application.create;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPicking;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPickingQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.create.DdTemporalOrdenPickingCreator;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.exceptions.DdTemporalOrdenPickingAlreadyExistsException;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdTemporalOrdenPickingCreatorWithoutExistsTest  {
    private DdTemporalOrdenPickingCreator creator;
    private DdTemporalOrdenPickingQueryRepository queryRepository;
    private DdTemporalOrdenPickingCreatorWithoutExists useCase;
    @BeforeEach void setUp() {
        creator = mock(DdTemporalOrdenPickingCreator.class);
        queryRepository = mock(DdTemporalOrdenPickingQueryRepository.class);
        useCase = new DdTemporalOrdenPickingCreatorWithoutExists(creator, queryRepository);

    }
    @Test void execute_should_throw_when_exists() {
        when(queryRepository.findById(any())).thenReturn(mock(DdTemporalOrdenPicking.class));
        assertThrows(DdTemporalOrdenPickingAlreadyExistsException.class, () -> useCase.execute(new DdTemporalOrdenPickingCreateWithoutExistsCommand(1L, 1L, "X", 1L, "X", "X", "X")));

    }

}
