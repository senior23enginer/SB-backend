package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.application.find;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.find.DdLocalesDespReposicionFinder;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdLocalesDespReposicionFinderAllTest  {
    DdLocalesDespReposicionFinder finder;
    DdLocalesDespReposicionFinderAll useCase;
    @BeforeEach void setUp() {
        finder=mock(DdLocalesDespReposicionFinder.class);
        useCase=new DdLocalesDespReposicionFinderAll(finder);

    }
    @Test void execute_should_delegate() {
        when(finder.findAll(anyInt(),anyInt())).thenReturn(List.of());
        assertNotNull(useCase.execute(new FindAllDdLocalesDespReposicionQuery(1,20)));

    }
}
