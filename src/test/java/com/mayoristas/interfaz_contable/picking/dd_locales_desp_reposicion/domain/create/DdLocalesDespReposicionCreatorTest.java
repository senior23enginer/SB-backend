package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicion;
import java.time.LocalDateTime;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicionCommandRepository;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdLocalesDespReposicionCreatorTest  {
    DdLocalesDespReposicionCommandRepository repo;
    DdLocalesDespReposicionCreator creator;
    @BeforeEach void setUp() {
        repo=mock(DdLocalesDespReposicionCommandRepository.class);
        creator=new DdLocalesDespReposicionCreator(repo);

    }
    @Test void ok() {
        when(repo.create(any(DdLocalesDespReposicion.class))).thenReturn(1);
        assertNotNull(creator.create(new CreateDdLocalesDespReposicionCommand(1L, 1L, 1L, 1L, java.time.LocalDateTime.now(), "X")));

    }

}
