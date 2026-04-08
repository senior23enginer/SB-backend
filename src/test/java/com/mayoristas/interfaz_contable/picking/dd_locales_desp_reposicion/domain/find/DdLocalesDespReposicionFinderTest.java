package com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicion;

import com.mayoristas.interfaz_contable.picking.dd_locales_desp_reposicion.domain.DdLocalesDespReposicionQueryRepository;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.ArgumentMatchers.anyInt;

import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;

class DdLocalesDespReposicionFinderTest  {

    private DdLocalesDespReposicionQueryRepository queryRepository;

    private DdLocalesDespReposicionFinder finder;

    @BeforeEach
    void setUp()  {

        queryRepository = mock(DdLocalesDespReposicionQueryRepository.class);

        finder = new DdLocalesDespReposicionFinder(queryRepository);

    }

    @Test
    void findAll_should_delegate()  {

        when(queryRepository.find(anyInt(), anyInt())).thenReturn(List.of());

        assertNotNull(finder.findAll(20, 0));

    }

}
