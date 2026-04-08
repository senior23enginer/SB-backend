package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.application.update;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.update.DdDetallePickingUpdater;
import java.time.LocalDateTime;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdDetallePickingUpdaterWithoutExistsTest  {
    DdDetallePickingUpdater d;
    DdDetallePickingUpdaterWithoutExists u;
    @BeforeEach void setUp() {
        d=mock(DdDetallePickingUpdater.class);
        u=new DdDetallePickingUpdaterWithoutExists(d);

    }
    @Test void ok() {
        when(d.execute(any())).thenReturn(1);
        assertEquals(1,u.execute(new UpdateDdDetallePickingByIdCommand(1L, 1L, 1L, java.time.LocalDateTime.now(), "X", 1L)));

    }

}
