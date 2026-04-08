package com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.application.update;

import com.mayoristas.interfaz_contable.picking.dd_orden_pedidos.domain.update.UpdateDdOrdenPedidosCommand;
import java.time.LocalDateTime;

public class UpdateDdOrdenPedidosByIdCommand extends UpdateDdOrdenPedidosCommand  {
    public UpdateDdOrdenPedidosByIdCommand(Long codigoEmpresa, Long loCodigoDesp, String checkComuna, String checkMarca, String checkProducto, String indAndOrProd, String indIncExc, String checkStock, String sinStock, String conStock, String checkCantProd, Long cantProdDesde, Long cantProdHasta, String checkPrecio, Long precioDesde, Long precioHasta, LocalDateTime fechaCreacion, String creadoPor, LocalDateTime fechaActualicacion, String actualizadoPor) {
        super(codigoEmpresa, loCodigoDesp, checkComuna, checkMarca, checkProducto, indAndOrProd, indIncExc, checkStock, sinStock, conStock, checkCantProd, cantProdDesde, cantProdHasta, checkPrecio, precioDesde, precioHasta, fechaCreacion, creadoPor, fechaActualicacion, actualizadoPor);

    }

}
