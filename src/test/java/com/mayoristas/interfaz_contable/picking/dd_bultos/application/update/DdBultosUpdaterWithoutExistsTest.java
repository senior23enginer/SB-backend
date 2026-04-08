package com.mayoristas.interfaz_contable.picking.dd_bultos.application.update;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.update.DdBultosUpdater;
import java.time.LocalDateTime;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdBultosUpdaterWithoutExistsTest  {
    DdBultosUpdater d;
    DdBultosUpdaterWithoutExists u;
    @BeforeEach void setUp() {
        d=mock(DdBultosUpdater.class);
        u=new DdBultosUpdaterWithoutExists(d);

    }
    @Test void ok() {
        when(d.execute(any())).thenReturn(1);
        assertEquals(1,u.execute(new UpdateDdBultosByIdCommand(1L, 1L, "X", java.time.LocalDateTime.now(), "X", "X")));

    }

}
