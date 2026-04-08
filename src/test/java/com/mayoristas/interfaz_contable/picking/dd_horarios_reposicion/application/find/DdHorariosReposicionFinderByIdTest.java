package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.application.find;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.DdHorariosReposicion;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdHorariosReposicionFinderByIdTest  {
    private com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.find_by_id.DdHorariosReposicionFinderById domainFinder;
    private DdHorariosReposicionFinderById finder;
    @BeforeEach void setUp() {
        domainFinder = mock(com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.find_by_id.DdHorariosReposicionFinderById.class);
        finder = new DdHorariosReposicionFinderById(domainFinder);

    }
    @Test void execute_should_delegate() {
        DdHorariosReposicion expected = mock(DdHorariosReposicion.class);
        when(domainFinder.findById(any())).thenReturn(expected);
        DdHorariosReposicion result = finder.execute(new FindByIdDdHorariosReposicionQuery(1L, 1L, java.time.LocalDateTime.now()));
        assertSame(expected, result);

    }

}
