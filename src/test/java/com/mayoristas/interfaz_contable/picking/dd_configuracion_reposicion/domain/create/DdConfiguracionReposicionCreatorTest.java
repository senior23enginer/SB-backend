package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicion;
import java.time.LocalDateTime;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicionCommandRepository;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdConfiguracionReposicionCreatorTest  {
    DdConfiguracionReposicionCommandRepository repo;
    DdConfiguracionReposicionCreator creator;
    @BeforeEach void setUp() {
        repo=mock(DdConfiguracionReposicionCommandRepository.class);
        creator=new DdConfiguracionReposicionCreator(repo);

    }
    @Test void ok() {
        when(repo.create(any(DdConfiguracionReposicion.class))).thenReturn(1);
        assertNotNull(creator.create(new CreateDdConfiguracionReposicionCommand(1L, 1L, "X", java.time.LocalDateTime.now(), "X", java.time.LocalDateTime.now(), "X", java.time.LocalDateTime.now(), "X")));

    }

}
