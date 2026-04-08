package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.application.update;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.update.DdHorariosReposicionUpdater;
import java.time.LocalDateTime;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdHorariosReposicionUpdaterWithoutExistsTest  {
    DdHorariosReposicionUpdater d;
    DdHorariosReposicionUpdaterWithoutExists u;
    @BeforeEach void setUp() {
        d=mock(DdHorariosReposicionUpdater.class);
        u=new DdHorariosReposicionUpdaterWithoutExists(d);

    }
    @Test void ok() {
        when(d.execute(any())).thenReturn(1);
        assertEquals(1,u.execute(new UpdateDdHorariosReposicionByIdCommand(1L, 1L, java.time.LocalDateTime.now(), "X", java.time.LocalDateTime.now(), "X", java.time.LocalDateTime.now(), "X")));

    }

}
