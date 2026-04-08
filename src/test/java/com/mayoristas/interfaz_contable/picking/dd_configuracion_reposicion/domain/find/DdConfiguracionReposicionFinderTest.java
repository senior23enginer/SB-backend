package com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicion;

import com.mayoristas.interfaz_contable.picking.dd_configuracion_reposicion.domain.DdConfiguracionReposicionQueryRepository;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.ArgumentMatchers.anyInt;

import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;

class DdConfiguracionReposicionFinderTest  {

    private DdConfiguracionReposicionQueryRepository queryRepository;

    private DdConfiguracionReposicionFinder finder;

    @BeforeEach
    void setUp()  {

        queryRepository = mock(DdConfiguracionReposicionQueryRepository.class);

        finder = new DdConfiguracionReposicionFinder(queryRepository);

    }

    @Test
    void findAll_should_delegate()  {

        when(queryRepository.find(anyInt(), anyInt())).thenReturn(List.of());

        assertNotNull(finder.findAll(20, 0));

    }

}
