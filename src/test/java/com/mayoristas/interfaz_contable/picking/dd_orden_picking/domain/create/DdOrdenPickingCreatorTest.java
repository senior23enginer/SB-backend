package com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPicking;

import com.mayoristas.interfaz_contable.picking.dd_orden_picking.domain.DdOrdenPickingCommandRepository;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdOrdenPickingCreatorTest  {
    DdOrdenPickingCommandRepository repo;
    DdOrdenPickingCreator creator;
    @BeforeEach void setUp() {
        repo=mock(DdOrdenPickingCommandRepository.class);
        creator=new DdOrdenPickingCreator(repo);

    }
    @Test void ok() {
        when(repo.create(any(DdOrdenPicking.class))).thenReturn(1);
        assertNotNull(creator.create(new CreateDdOrdenPickingCommand(1L, 1L, "X", 1L, "X", "X", "X")));

    }

}
