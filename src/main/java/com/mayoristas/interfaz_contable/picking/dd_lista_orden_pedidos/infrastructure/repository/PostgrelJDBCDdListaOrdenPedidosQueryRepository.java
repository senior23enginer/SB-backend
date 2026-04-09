package com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidos;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidosQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_lista_orden_pedidos.domain.DdListaOrdenPedidosKey;

import org.springframework.dao.DataAccessException;

import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Objects;

@Repository
public class PostgrelJDBCDdListaOrdenPedidosQueryRepository implements DdListaOrdenPedidosQueryRepository  {

    private final JdbcTemplate jdbcTemplate;

    private final DdListaOrdenPedidosRowMapper mapper;

    public PostgrelJDBCDdListaOrdenPedidosQueryRepository(JdbcTemplate jdbcTemplate)  {

        this.jdbcTemplate = Objects.requireNonNull(jdbcTemplate, "JdbcTemplate no puede ser null");

        this.mapper = new DdListaOrdenPedidosRowMapper();

    }

    @Override
    public List<DdListaOrdenPedidos> find()  {

        String sql = """
        SELECT
        codigo_empresa,
        lo_codigo_desp,
        codigo_lista,
        codigo_elemento,
        org_id_inv,
        orden_elemento,
        fecha_creacion,
        creado_por
        FROM interfaz_contable.dd_lista_orden_pedidos
        ORDER BY codigo_empresa, lo_codigo_desp, codigo_lista, codigo_elemento
        """;

        return jdbcTemplate.query(sql, mapper);

    }

    @Override
    public List<DdListaOrdenPedidos> find(int limit, int offset) {

        String sql = """
        SELECT
        codigo_empresa,
        lo_codigo_desp,
        codigo_lista,
        codigo_elemento,
        org_id_inv,
        orden_elemento,
        fecha_creacion,
        creado_por
        FROM interfaz_contable.dd_lista_orden_pedidos
        ORDER BY codigo_empresa, lo_codigo_desp, codigo_lista, codigo_elemento
        OFFSET ? ROWS FETCH NEXT ? ROWS ONLY
        """;

        return jdbcTemplate.query(sql, mapper, offset, limit);

    }


    @Override
    public DdListaOrdenPedidos findById(DdListaOrdenPedidosKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        SELECT
        codigo_empresa,
        lo_codigo_desp,
        codigo_lista,
        codigo_elemento,
        org_id_inv,
        orden_elemento,
        fecha_creacion,
        creado_por
        FROM interfaz_contable.dd_lista_orden_pedidos
        WHERE codigo_empresa = ? AND lo_codigo_desp = ? AND codigo_lista = ? AND codigo_elemento = ?
        """;

        try  {

            return jdbcTemplate.queryForObject(sql, mapper, key.getCodigoEmpresa(), key.getLoCodigoDesp(), key.getCodigoLista(), key.getCodigoElemento());

        }
        catch (EmptyResultDataAccessException ex)  {

            return null;

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error consultando DdListaOrdenPedidos por id", ex);

        }

    }

}
