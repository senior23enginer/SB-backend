package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.find;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidos;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidosQueryRepository;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.ArgumentMatchers.anyInt;

import static org.mockito.Mockito.mock;

import static org.mockito.Mockito.when;

class DdListaOrdenPedidosFinderTest  {

    private DdListaOrdenPedidosQueryRepository queryRepository;

    private DdListaOrdenPedidosFinder finder;

    @BeforeEach
    void setUp()  {

        queryRepository = mock(DdListaOrdenPedidosQueryRepository.class);

        finder = new DdListaOrdenPedidosFinder(queryRepository);

    }

    @Test
    void findAll_should_delegate()  {

        when(queryRepository.find(anyInt(), anyInt())).thenReturn(List.of());

        assertNotNull(finder.findAll(20, 0));

    }

}
