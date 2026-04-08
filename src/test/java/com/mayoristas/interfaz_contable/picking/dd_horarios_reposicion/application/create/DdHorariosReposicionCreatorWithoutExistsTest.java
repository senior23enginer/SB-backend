package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.application.create;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicion;
import java.time.LocalDateTime;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicionQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.create.DdHorariosReposicionCreator;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.exceptions.DdHorariosReposicionAlreadyExistsException;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdHorariosReposicionCreatorWithoutExistsTest  {
    private DdHorariosReposicionCreator creator;
    private DdHorariosReposicionQueryRepository queryRepository;
    private DdHorariosReposicionCreatorWithoutExists useCase;
    @BeforeEach void setUp() {
        creator = mock(DdHorariosReposicionCreator.class);
        queryRepository = mock(DdHorariosReposicionQueryRepository.class);
        useCase = new DdHorariosReposicionCreatorWithoutExists(creator, queryRepository);

    }
    @Test void execute_should_throw_when_exists() {
        when(queryRepository.findById(any())).thenReturn(mock(DdHorariosReposicion.class));
        assertThrows(DdHorariosReposicionAlreadyExistsException.class, () -> useCase.execute(new DdHorariosReposicionCreateWithoutExistsCommand(1L, 1L, java.time.LocalDateTime.now(), "X", java.time.LocalDateTime.now(), "X", java.time.LocalDateTime.now(), "X")));

    }

}
