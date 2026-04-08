package com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePicking;
import java.time.LocalDateTime;

import com.mayoristas.interfaz_contable.picking.dd_detalle_picking.domain.DdDetallePickingCommandRepository;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdDetallePickingCreatorTest  {
    DdDetallePickingCommandRepository repo;
    DdDetallePickingCreator creator;
    @BeforeEach void setUp() {
        repo=mock(DdDetallePickingCommandRepository.class);
        creator=new DdDetallePickingCreator(repo);

    }
    @Test void ok() {
        when(repo.create(any(DdDetallePicking.class))).thenReturn(1);
        assertNotNull(creator.create(new CreateDdDetallePickingCommand(1L, 1L, 1L, java.time.LocalDateTime.now(), "X", 1L)));

    }

}
