package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.application.update;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.update.DdDetalleBultosUpdater;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdDetalleBultosUpdaterWithoutExistsTest  {
    DdDetalleBultosUpdater d;
    DdDetalleBultosUpdaterWithoutExists u;
    @BeforeEach void setUp() {
        d=mock(DdDetalleBultosUpdater.class);
        u=new DdDetalleBultosUpdaterWithoutExists(d);

    }
    @Test void ok() {
        when(d.execute(any())).thenReturn(1);
        assertEquals(1,u.execute(new UpdateDdDetalleBultosByIdCommand(1L, 1L, 1L)));

    }

}
