package com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.application.find;

import com.mayoristas.interfaz_contable.picking.dd_horarios_reposicion.domain.find.DdHorariosReposicionFinder;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdHorariosReposicionFinderAllTest  {
    DdHorariosReposicionFinder finder;
    DdHorariosReposicionFinderAll useCase;
    @BeforeEach void setUp() {
        finder=mock(DdHorariosReposicionFinder.class);
        useCase=new DdHorariosReposicionFinderAll(finder);

    }
    @Test void execute_should_delegate() {
        when(finder.findAll(anyInt(),anyInt())).thenReturn(List.of());
        assertNotNull(useCase.execute(new FindAllDdHorariosReposicionQuery(1,20)));

    }
}
