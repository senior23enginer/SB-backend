package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.application.update;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.update.DdLocalesDespReposicionUpdater;
import java.time.LocalDateTime;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdLocalesDespReposicionUpdaterWithoutExistsTest  {
    DdLocalesDespReposicionUpdater d;
    DdLocalesDespReposicionUpdaterWithoutExists u;
    @BeforeEach void setUp() {
        d=mock(DdLocalesDespReposicionUpdater.class);
        u=new DdLocalesDespReposicionUpdaterWithoutExists(d);

    }
    @Test void ok() {
        when(d.execute(any())).thenReturn(1);
        assertEquals(1,u.execute(new UpdateDdLocalesDespReposicionByIdCommand(1L, 1L, 1L, 1L, java.time.LocalDateTime.now(), "X")));

    }

}
