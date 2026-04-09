package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidos;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidosQueryRepository;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidosKey;

import org.springframework.dao.DataAccessException;

import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Objects;

@Repository
public class PostgrelJDBCDdOrdenPedidosQueryRepository implements DdOrdenPedidosQueryRepository  {

    private final JdbcTemplate jdbcTemplate;

    private final DdOrdenPedidosRowMapper mapper;

    public PostgrelJDBCDdOrdenPedidosQueryRepository(JdbcTemplate jdbcTemplate)  {

        this.jdbcTemplate = Objects.requireNonNull(jdbcTemplate, "JdbcTemplate no puede ser null");

        this.mapper = new DdOrdenPedidosRowMapper();

    }

    @Override
    public List<DdOrdenPedidos> find()  {

        String sql = """
        SELECT
        codigo_empresa,
        lo_codigo_desp,
        check_comuna,
        check_marca,
        check_producto,
        ind_and_or_prod,
        ind_inc_exc,
        check_stock,
        sin_stock,
        con_stock,
        check_cant_prod,
        cant_prod_desde,
        cant_prod_hasta,
        chec_precio,
        precio_desde,
        precio_hasta,
        fecha_creacion,
        creado_por,
        fecha_actualicacion,
        actualizado_por
        FROM interfaz_contable.dd_orden_pedidos
        ORDER BY codigo_empresa, lo_codigo_desp
        """;

        return jdbcTemplate.query(sql, mapper);

    }

    @Override
    public List<DdOrdenPedidos> find(int limit, int offset) {

        String sql = """
        SELECT
        codigo_empresa,
        lo_codigo_desp,
        check_comuna,
        check_marca,
        check_producto,
        ind_and_or_prod,
        ind_inc_exc,
        check_stock,
        sin_stock,
        con_stock,
        check_cant_prod,
        cant_prod_desde,
        cant_prod_hasta,
        chec_precio,
        precio_desde,
        precio_hasta,
        fecha_creacion,
        creado_por,
        fecha_actualicacion,
        actualizado_por
        FROM interfaz_contable.dd_orden_pedidos
        ORDER BY codigo_empresa, lo_codigo_desp
        OFFSET ? ROWS FETCH NEXT ? ROWS ONLY
        """;

        return jdbcTemplate.query(sql, mapper, offset, limit);

    }


    @Override
    public DdOrdenPedidos findById(DdOrdenPedidosKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        SELECT
        codigo_empresa,
        lo_codigo_desp,
        check_comuna,
        check_marca,
        check_producto,
        ind_and_or_prod,
        ind_inc_exc,
        check_stock,
        sin_stock,
        con_stock,
        check_cant_prod,
        cant_prod_desde,
        cant_prod_hasta,
        chec_precio,
        precio_desde,
        precio_hasta,
        fecha_creacion,
        creado_por,
        fecha_actualicacion,
        actualizado_por
        FROM interfaz_contable.dd_orden_pedidos
        WHERE codigo_empresa = ? AND lo_codigo_desp = ?
        """;

        try  {

            return jdbcTemplate.queryForObject(sql, mapper, key.getCodigoEmpresa(), key.getLoCodigoDesp());

        }
        catch (EmptyResultDataAccessException ex)  {

            return null;

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error consultando DdOrdenPedidos por id", ex);

        }

    }

}
