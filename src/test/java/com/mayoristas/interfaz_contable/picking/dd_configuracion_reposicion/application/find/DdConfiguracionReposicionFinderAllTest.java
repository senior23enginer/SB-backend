package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.application.find;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.find.DdConfiguracionReposicionFinder;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdConfiguracionReposicionFinderAllTest  {
    DdConfiguracionReposicionFinder finder;
    DdConfiguracionReposicionFinderAll useCase;
    @BeforeEach void setUp() {
        finder=mock(DdConfiguracionReposicionFinder.class);
        useCase=new DdConfiguracionReposicionFinderAll(finder);

    }
    @Test void execute_should_delegate() {
        when(finder.findAll(anyInt(),anyInt())).thenReturn(List.of());
        assertNotNull(useCase.execute(new FindAllDdConfiguracionReposicionQuery(1,20)));

    }
}
