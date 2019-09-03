package com.challenge.srpago.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: gpucheta<br/>
 * Date: 9/1/19<br/>
 * Time: 11:36 PM<br/>
 * Generated to
 */
@Entity(name = "gas_station")
public class GasStation {

    @Id
    private String id;
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    private String calle;
    private String rfc;
    private String colonia;
    @Column(name = "CODIGO_POSTAL")
    private String codigoPostal;
    @Column(name = "DATE_INSERT")
    private String dateInsert;
    @Column(name = "PERMISO_ID")
    private String permisoId;
    @Column(name = "NUMERO_PERMISO")
    private String numeroPermiso;
    @Column(name = "FECHA_APLICACION")
    private String fechaAplicacion;
    private BigDecimal longitud;
    private BigDecimal latitud;
    @Column(name = "REGULAR_PRICE")
    private BigDecimal regularPrice;
    @Column(name = "PREMIUM_PRICE")
    private BigDecimal premiumPrice;
    @Column(name = "DIESEL_PRICE")
    private BigDecimal dieselPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDateInsert() {
        return dateInsert;
    }

    public void setDateInsert(String dateInsert) {
        this.dateInsert = dateInsert;
    }

    public String getPermisoId() {
        return permisoId;
    }

    public void setPermisoId(String permisoId) {
        this.permisoId = permisoId;
    }

    public String getNumeroPermiso() {
        return numeroPermiso;
    }

    public void setNumeroPermiso(String numeroPermiso) {
        this.numeroPermiso = numeroPermiso;
    }

    public String getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(String fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(BigDecimal regularPrice) {
        this.regularPrice = regularPrice;
    }

    public BigDecimal getPremiumPrice() {
        return premiumPrice;
    }

    public void setPremiumPrice(BigDecimal premiumPrice) {
        this.premiumPrice = premiumPrice;
    }

    public BigDecimal getDieselPrice() {
        return dieselPrice;
    }

    public void setDieselPrice(BigDecimal dieselPrice) {
        this.dieselPrice = dieselPrice;
    }
}
