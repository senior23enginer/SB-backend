package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPicking;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.DdTemporalOrdenPickingCommandRepository;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdTemporalOrdenPickingCreatorTest  {
    DdTemporalOrdenPickingCommandRepository repo;
    DdTemporalOrdenPickingCreator creator;
    @BeforeEach void setUp() {
        repo=mock(DdTemporalOrdenPickingCommandRepository.class);
        creator=new DdTemporalOrdenPickingCreator(repo);

    }
    @Test void ok() {
        when(repo.create(any(DdTemporalOrdenPicking.class))).thenReturn(1);
        assertNotNull(creator.create(new CreateDdTemporalOrdenPickingCommand(1L, 1L, "X", 1L, "X", "X", "X")));

    }

}
