package com.mayoristas.interfaz_contable.picking.dd_orden_picking.application.update;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.update.DdOrdenPickingUpdater;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdOrdenPickingUpdaterWithoutExistsTest  {
    DdOrdenPickingUpdater d;
    DdOrdenPickingUpdaterWithoutExists u;
    @BeforeEach void setUp() {
        d=mock(DdOrdenPickingUpdater.class);
        u=new DdOrdenPickingUpdaterWithoutExists(d);

    }
    @Test void ok() {
        when(d.execute(any())).thenReturn(1);
        assertEquals(1,u.execute(new UpdateDdOrdenPickingByIdCommand(1L, 1L, "X", 1L, "X", "X", "X")));

    }

}
