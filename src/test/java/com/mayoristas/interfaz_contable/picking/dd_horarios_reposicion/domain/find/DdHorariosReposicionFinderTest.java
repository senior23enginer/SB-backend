package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicion;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicionQueryRepository;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.ArgumentMatchers.anyInt;

import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;

class DdHorariosReposicionFinderTest  {

    private DdHorariosReposicionQueryRepository queryRepository;

    private DdHorariosReposicionFinder finder;

    @BeforeEach
    void setUp()  {

        queryRepository = mock(DdHorariosReposicionQueryRepository.class);

        finder = new DdHorariosReposicionFinder(queryRepository);

    }

    @Test
    void findAll_should_delegate()  {

        when(queryRepository.find(anyInt(), anyInt())).thenReturn(List.of());

        assertNotNull(finder.findAll(20, 0));

    }

}
