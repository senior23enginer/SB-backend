package com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultos;

import com.mayoristas.interfaz_contable.picking.dd_detalle_bultos.domain.DdDetalleBultosCommandRepository;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdDetalleBultosCreatorTest  {
    DdDetalleBultosCommandRepository repo;
    DdDetalleBultosCreator creator;
    @BeforeEach void setUp() {
        repo=mock(DdDetalleBultosCommandRepository.class);
        creator=new DdDetalleBultosCreator(repo);

    }
    @Test void ok() {
        when(repo.create(any(DdDetalleBultos.class))).thenReturn(1);
        assertNotNull(creator.create(new CreateDdDetalleBultosCommand(1L, 1L, 1L)));

    }

}
