package com.mayoristas.interfaz_contable.picking.dd_bultos.domain.create;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultos;
import java.time.LocalDateTime;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.DdBultosCommandRepository;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
class DdBultosCreatorTest  {
    DdBultosCommandRepository repo;
    DdBultosCreator creator;
    @BeforeEach void setUp() {
        repo=mock(DdBultosCommandRepository.class);
        creator=new DdBultosCreator(repo);

    }
    @Test void ok() {
        when(repo.create(any(DdBultos.class))).thenReturn(1);
        assertNotNull(creator.create(new CreateDdBultosCommand(1L, 1L, "X", java.time.LocalDateTime.now(), "X", "X")));

    }

}
