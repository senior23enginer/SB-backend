package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.application.update;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.update.DdConfiguracionReposicionUpdater;
import java.time.LocalDateTime;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdConfiguracionReposicionUpdaterWithoutExistsTest  {
    DdConfiguracionReposicionUpdater d;
    DdConfiguracionReposicionUpdaterWithoutExists u;
    @BeforeEach void setUp() {
        d=mock(DdConfiguracionReposicionUpdater.class);
        u=new DdConfiguracionReposicionUpdaterWithoutExists(d);

    }
    @Test void ok() {
        when(d.execute(any())).thenReturn(1);
        assertEquals(1,u.execute(new UpdateDdConfiguracionReposicionByIdCommand(1L, 1L, "X", java.time.LocalDateTime.now(), "X", java.time.LocalDateTime.now(), "X", java.time.LocalDateTime.now(), "X")));

    }

}
