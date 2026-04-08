package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain;

import java.time.LocalDateTime;

public class DdOrdenPedidos  {

    private final Long codigoEmpresa;

    private final Long loCodigoDesp;

    private final String checkComuna;

    private final String checkMarca;

    private final String checkProducto;

    private final String indAndOrProd;

    private final String indIncExc;

    private final String checkStock;

    private final String sinStock;

    private final String conStock;

    private final String checkCantProd;

    private final Long cantProdDesde;

    private final Long cantProdHasta;

    private final String checkPrecio;

    private final Long precioDesde;

    private final Long precioHasta;

    private final LocalDateTime fechaCreacion;

    private final String creadoPor;

    private final LocalDateTime fechaActualicacion;

    private final String actualizadoPor;

    public DdOrdenPedidos(
    Long codigoEmpresa,
    Long loCodigoDesp,
    String checkComuna,
    String checkMarca,
    String checkProducto,
    String indAndOrProd,
    String indIncExc,
    String checkStock,
    String sinStock,
    String conStock,
    String checkCantProd,
    Long cantProdDesde,
    Long cantProdHasta,
    String checkPrecio,
    Long precioDesde,
    Long precioHasta,
    LocalDateTime fechaCreacion,
    String creadoPor,
    LocalDateTime fechaActualicacion,
    String actualizadoPor
    )  {

        this.codigoEmpresa = codigoEmpresa;

        this.loCodigoDesp = loCodigoDesp;

        this.checkComuna = checkComuna;

        this.checkMarca = checkMarca;

        this.checkProducto = checkProducto;

        this.indAndOrProd = indAndOrProd;

        this.indIncExc = indIncExc;

        this.checkStock = checkStock;

        this.sinStock = sinStock;

        this.conStock = conStock;

        this.checkCantProd = checkCantProd;

        this.cantProdDesde = cantProdDesde;

        this.cantProdHasta = cantProdHasta;

        this.checkPrecio = checkPrecio;

        this.precioDesde = precioDesde;

        this.precioHasta = precioHasta;

        this.fechaCreacion = fechaCreacion;

        this.creadoPor = creadoPor;

        this.fechaActualicacion = fechaActualicacion;

        this.actualizadoPor = actualizadoPor;

    }

    public Long getCodigoEmpresa()  {

        return codigoEmpresa;

    }

    public Long getLoCodigoDesp()  {

        return loCodigoDesp;

    }

    public String getCheckComuna()  {

        return checkComuna;

    }

    public String getCheckMarca()  {

        return checkMarca;

    }

    public String getCheckProducto()  {

        return checkProducto;

    }

    public String getIndAndOrProd()  {

        return indAndOrProd;

    }

    public String getIndIncExc()  {

        return indIncExc;

    }

    public String getCheckStock()  {

        return checkStock;

    }

    public String getSinStock()  {

        return sinStock;

    }

    public String getConStock()  {

        return conStock;

    }

    public String getCheckCantProd()  {

        return checkCantProd;

    }

    public Long getCantProdDesde()  {

        return cantProdDesde;

    }

    public Long getCantProdHasta()  {

        return cantProdHasta;

    }

    public String getCheckPrecio()  {

        return checkPrecio;

    }

    public Long getPrecioDesde()  {

        return precioDesde;

    }

    public Long getPrecioHasta()  {

        return precioHasta;

    }

    public LocalDateTime getFechaCreacion()  {

        return fechaCreacion;

    }

    public String getCreadoPor()  {

        return creadoPor;

    }

    public LocalDateTime getFechaActualicacion()  {

        return fechaActualicacion;

    }

    public String getActualizadoPor()  {

        return actualizadoPor;

    }

}
