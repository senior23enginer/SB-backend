package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.application.find;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicion;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdLocalesDespReposicionFinderByIdTest  {
    private com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.find_by_id.DdLocalesDespReposicionFinderById domainFinder;
    private DdLocalesDespReposicionFinderById finder;
    @BeforeEach void setUp() {
        domainFinder = mock(com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.find_by_id.DdLocalesDespReposicionFinderById.class);
        finder = new DdLocalesDespReposicionFinderById(domainFinder);

    }
    @Test void execute_should_delegate() {
        DdLocalesDespReposicion expected = mock(DdLocalesDespReposicion.class);
        when(domainFinder.findById(any())).thenReturn(expected);
        DdLocalesDespReposicion result = finder.execute(new FindByIdDdLocalesDespReposicionQuery(1L, 1L, 1L, 1L));
        assertSame(expected, result);

    }

}
