package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidos;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidosQueryRepository;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.ArgumentMatchers.anyInt;

import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;

class DdOrdenPedidosFinderTest  {

    private DdOrdenPedidosQueryRepository queryRepository;

    private DdOrdenPedidosFinder finder;

    @BeforeEach
    void setUp()  {

        queryRepository = mock(DdOrdenPedidosQueryRepository.class);

        finder = new DdOrdenPedidosFinder(queryRepository);

    }

    @Test
    void findAll_should_delegate()  {

        when(queryRepository.find(anyInt(), anyInt())).thenReturn(List.of());

        assertNotNull(finder.findAll(20, 0));

    }

}
