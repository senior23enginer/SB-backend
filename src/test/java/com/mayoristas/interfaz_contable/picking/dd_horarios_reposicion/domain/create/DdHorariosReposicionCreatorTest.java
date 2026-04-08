package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicion;
import java.time.LocalDateTime;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicionCommandRepository;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdHorariosReposicionCreatorTest  {
    DdHorariosReposicionCommandRepository repo;
    DdHorariosReposicionCreator creator;
    @BeforeEach void setUp() {
        repo=mock(DdHorariosReposicionCommandRepository.class);
        creator=new DdHorariosReposicionCreator(repo);

    }
    @Test void ok() {
        when(repo.create(any(DdHorariosReposicion.class))).thenReturn(1);
        assertNotNull(creator.create(new CreateDdHorariosReposicionCommand(1L, 1L, java.time.LocalDateTime.now(), "X", java.time.LocalDateTime.now(), "X", java.time.LocalDateTime.now(), "X")));

    }

}
