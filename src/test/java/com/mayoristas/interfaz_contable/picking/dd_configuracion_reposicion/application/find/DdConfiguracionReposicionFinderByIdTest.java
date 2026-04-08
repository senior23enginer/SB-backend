package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.application.find;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicion;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdConfiguracionReposicionFinderByIdTest  {
    private com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.find_by_id.DdConfiguracionReposicionFinderById domainFinder;
    private DdConfiguracionReposicionFinderById finder;
    @BeforeEach void setUp() {
        domainFinder = mock(com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.find_by_id.DdConfiguracionReposicionFinderById.class);
        finder = new DdConfiguracionReposicionFinderById(domainFinder);

    }
    @Test void execute_should_delegate() {
        DdConfiguracionReposicion expected = mock(DdConfiguracionReposicion.class);
        when(domainFinder.findById(any())).thenReturn(expected);
        DdConfiguracionReposicion result = finder.execute(new FindByIdDdConfiguracionReposicionQuery(1L, 1L));
        assertSame(expected, result);

    }

}
