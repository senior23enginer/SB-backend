package com.mayoristas.interfaz_contable.picking.dd_bultos.domain;

import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.valueObject.DdBultosCodigoEtiqueta;
import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.valueObject.DdBultosFechaImpresion;
import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.valueObject.DdBultosIdRecvta;
import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.valueObject.DdBultosImpresora;
import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.valueObject.DdBultosIndUtilizado;
import com.mayoristas.interfaz_contable.picking.dd_bultos.domain.valueObject.DdBultosUsuarioImpresion;

import java.time.LocalDateTime;
import java.util.Objects;

public class DdBultos  {

    private final DdBultosCodigoEtiqueta codigoEtiqueta;

    private final DdBultosIdRecvta idRecvta;

    private final DdBultosImpresora impresora;

    private final DdBultosFechaImpresion fechaImpresion;

    private final DdBultosUsuarioImpresion usuarioImpresion;

    private final DdBultosIndUtilizado indUtilizado;

    public DdBultos(
    Long codigoEtiqueta,
    Long idRecvta,
    String impresora,
    LocalDateTime fechaImpresion,
    String usuarioImpresion,
    String indUtilizado
    )  {
        this(
                new DdBultosCodigoEtiqueta(codigoEtiqueta),
                new DdBultosIdRecvta(idRecvta),
                new DdBultosImpresora(impresora),
                new DdBultosFechaImpresion(fechaImpresion),
                new DdBultosUsuarioImpresion(usuarioImpresion),
                new DdBultosIndUtilizado(indUtilizado)
        );
    }

    public DdBultos(
            DdBultosCodigoEtiqueta codigoEtiqueta,
            DdBultosIdRecvta idRecvta,
            DdBultosImpresora impresora,
            DdBultosFechaImpresion fechaImpresion,
            DdBultosUsuarioImpresion usuarioImpresion,
            DdBultosIndUtilizado indUtilizado
    ) {
        this.codigoEtiqueta = Objects.requireNonNull(codigoEtiqueta, "DdBultosCodigoEtiqueta no puede ser null");
        this.idRecvta = Objects.requireNonNull(idRecvta, "DdBultosIdRecvta no puede ser null");
        this.impresora = Objects.requireNonNull(impresora, "DdBultosImpresora no puede ser null");
        this.fechaImpresion = Objects.requireNonNull(fechaImpresion, "DdBultosFechaImpresion no puede ser null");
        this.usuarioImpresion = Objects.requireNonNull(usuarioImpresion, "DdBultosUsuarioImpresion no puede ser null");
        this.indUtilizado = Objects.requireNonNull(indUtilizado, "DdBultosIndUtilizado no puede ser null");
    }

    public Long getCodigoEtiqueta()  {
        return codigoEtiqueta.getValue();
    }

    public Long getIdRecvta()  {
        return idRecvta.getValue();
    }

    public String getImpresora()  {
        return impresora.getValue();
    }

    public LocalDateTime getFechaImpresion()  {
        return fechaImpresion.getValue();
    }

    public String getUsuarioImpresion()  {
        return usuarioImpresion.getValue();
    }

    public String getIndUtilizado()  {
        return indUtilizado.getValue();
    }

    public DdBultosCodigoEtiqueta getCodigoEtiquetaValueObject() {
        return codigoEtiqueta;
    }

    public DdBultosIdRecvta getIdRecvtaValueObject() {
        return idRecvta;
    }

    public DdBultosImpresora getImpresoraValueObject() {
        return impresora;
    }

    public DdBultosFechaImpresion getFechaImpresionValueObject() {
        return fechaImpresion;
    }

    public DdBultosUsuarioImpresion getUsuarioImpresionValueObject() {
        return usuarioImpresion;
    }

    public DdBultosIndUtilizado getIndUtilizadoValueObject() {
        return indUtilizado;
    }

}
