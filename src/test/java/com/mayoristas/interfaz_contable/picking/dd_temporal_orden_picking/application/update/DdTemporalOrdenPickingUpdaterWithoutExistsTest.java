package com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.application.update;

import com.mayoristas.interfaz_contable.picking.dd_temporal_orden_picking.domain.update.DdTemporalOrdenPickingUpdater;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdTemporalOrdenPickingUpdaterWithoutExistsTest  {
    DdTemporalOrdenPickingUpdater d;
    DdTemporalOrdenPickingUpdaterWithoutExists u;
    @BeforeEach void setUp() {
        d=mock(DdTemporalOrdenPickingUpdater.class);
        u=new DdTemporalOrdenPickingUpdaterWithoutExists(d);

    }
    @Test void ok() {
        when(d.execute(any())).thenReturn(1);
        assertEquals(1,u.execute(new UpdateDdTemporalOrdenPickingByIdCommand(1L, 1L, "X", 1L, "X", "X", "X")));

    }

}
