package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.infrastructure.repository;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidos;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidosCommandRepository;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.DdOrdenPedidosKey;

import org.springframework.dao.DataAccessException;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;

import java.sql.Types;

import java.util.Objects;

@Repository
public class PostgresJDBCDdOrdenPedidosCommandRepository implements DdOrdenPedidosCommandRepository  {

    private final NamedParameterJdbcTemplate jdbc;

    public PostgresJDBCDdOrdenPedidosCommandRepository(NamedParameterJdbcTemplate jdbc)  {

        this.jdbc = Objects.requireNonNull(jdbc, "NamedParameterJdbcTemplate no puede ser null");

    }

    @Override
    public int create(DdOrdenPedidos entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        INSERT INTO interfaz_contable.dd_orden_pedidos (codigo_empresa, lo_codigo_desp, check_comuna, check_marca, check_producto, ind_and_or_prod, ind_inc_exc, check_stock, sin_stock, con_stock, check_cant_prod, cant_prod_desde, cant_prod_hasta, chec_precio, precio_desde, precio_hasta, fecha_creacion, creado_por, fecha_actualicacion, actualizado_por)
        VALUES (:codigoEmpresa, :loCodigoDesp, :checkComuna, :checkMarca, :checkProducto, :indAndOrProd, :indIncExc, :checkStock, :sinStock, :conStock, :checkCantProd, :cantProdDesde, :cantProdHasta, :checkPrecio, :precioDesde, :precioHasta, :fechaCreacion, :creadoPor, :fechaActualicacion, :actualizadoPor)
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEmpresa", entity.getCodigoEmpresa(), Types.NUMERIC)
        .addValue("loCodigoDesp", entity.getLoCodigoDesp(), Types.NUMERIC)
        .addValue("checkComuna", entity.getCheckComuna(), Types.VARCHAR)
        .addValue("checkMarca", entity.getCheckMarca(), Types.VARCHAR)
        .addValue("checkProducto", entity.getCheckProducto(), Types.VARCHAR)
        .addValue("indAndOrProd", entity.getIndAndOrProd(), Types.VARCHAR)
        .addValue("indIncExc", entity.getIndIncExc(), Types.VARCHAR)
        .addValue("checkStock", entity.getCheckStock(), Types.VARCHAR)
        .addValue("sinStock", entity.getSinStock(), Types.VARCHAR)
        .addValue("conStock", entity.getConStock(), Types.VARCHAR)
        .addValue("checkCantProd", entity.getCheckCantProd(), Types.VARCHAR)
        .addValue("cantProdDesde", entity.getCantProdDesde(), Types.NUMERIC)
        .addValue("cantProdHasta", entity.getCantProdHasta(), Types.NUMERIC)
        .addValue("checkPrecio", entity.getCheckPrecio(), Types.VARCHAR)
        .addValue("precioDesde", entity.getPrecioDesde(), Types.NUMERIC)
        .addValue("precioHasta", entity.getPrecioHasta(), Types.NUMERIC)
        .addValue("fechaCreacion", entity.getFechaCreacion(), Types.TIMESTAMP)
        .addValue("creadoPor", entity.getCreadoPor(), Types.VARCHAR)
        .addValue("fechaActualicacion", entity.getFechaActualicacion(), Types.TIMESTAMP)
        .addValue("actualizadoPor", entity.getActualizadoPor(), Types.VARCHAR);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error creando DdOrdenPedidos", ex);

        }

    }

    @Override
    public int update(DdOrdenPedidos entity)  {

        Objects.requireNonNull(entity, "Entity no puede ser null");

        String sql = """
        UPDATE interfaz_contable.dd_orden_pedidos
        SET check_comuna = :checkComuna,
        check_marca = :checkMarca,
        check_producto = :checkProducto,
        ind_and_or_prod = :indAndOrProd,
        ind_inc_exc = :indIncExc,
        check_stock = :checkStock,
        sin_stock = :sinStock,
        con_stock = :conStock,
        check_cant_prod = :checkCantProd,
        cant_prod_desde = :cantProdDesde,
        cant_prod_hasta = :cantProdHasta,
        chec_precio = :checkPrecio,
        precio_desde = :precioDesde,
        precio_hasta = :precioHasta,
        fecha_creacion = :fechaCreacion,
        creado_por = :creadoPor,
        fecha_actualicacion = :fechaActualicacion,
        actualizado_por = :actualizadoPor
        WHERE codigo_empresa = :codigoEmpresa AND lo_codigo_desp = :loCodigoDesp
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEmpresa", entity.getCodigoEmpresa(), Types.NUMERIC)
        .addValue("loCodigoDesp", entity.getLoCodigoDesp(), Types.NUMERIC)
        .addValue("checkComuna", entity.getCheckComuna(), Types.VARCHAR)
        .addValue("checkMarca", entity.getCheckMarca(), Types.VARCHAR)
        .addValue("checkProducto", entity.getCheckProducto(), Types.VARCHAR)
        .addValue("indAndOrProd", entity.getIndAndOrProd(), Types.VARCHAR)
        .addValue("indIncExc", entity.getIndIncExc(), Types.VARCHAR)
        .addValue("checkStock", entity.getCheckStock(), Types.VARCHAR)
        .addValue("sinStock", entity.getSinStock(), Types.VARCHAR)
        .addValue("conStock", entity.getConStock(), Types.VARCHAR)
        .addValue("checkCantProd", entity.getCheckCantProd(), Types.VARCHAR)
        .addValue("cantProdDesde", entity.getCantProdDesde(), Types.NUMERIC)
        .addValue("cantProdHasta", entity.getCantProdHasta(), Types.NUMERIC)
        .addValue("checkPrecio", entity.getCheckPrecio(), Types.VARCHAR)
        .addValue("precioDesde", entity.getPrecioDesde(), Types.NUMERIC)
        .addValue("precioHasta", entity.getPrecioHasta(), Types.NUMERIC)
        .addValue("fechaCreacion", entity.getFechaCreacion(), Types.TIMESTAMP)
        .addValue("creadoPor", entity.getCreadoPor(), Types.VARCHAR)
        .addValue("fechaActualicacion", entity.getFechaActualicacion(), Types.TIMESTAMP)
        .addValue("actualizadoPor", entity.getActualizadoPor(), Types.VARCHAR);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error actualizando DdOrdenPedidos", ex);

        }

    }

    @Override
    public int delete(DdOrdenPedidosKey key)  {

        Objects.requireNonNull(key, "Key no puede ser null");

        String sql = """
        DELETE FROM interfaz_contable.dd_orden_pedidos
        WHERE codigo_empresa = :codigoEmpresa AND lo_codigo_desp = :loCodigoDesp
        """;

        MapSqlParameterSource params = new MapSqlParameterSource()
        .addValue("codigoEmpresa", key.getCodigoEmpresa(), Types.NUMERIC)
        .addValue("loCodigoDesp", key.getLoCodigoDesp(), Types.NUMERIC);

        try  {

            return jdbc.update(sql, params);

        }
        catch (DataAccessException ex)  {

            throw new RuntimeException("Error eliminando DdOrdenPedidos", ex);

        }

    }

}
