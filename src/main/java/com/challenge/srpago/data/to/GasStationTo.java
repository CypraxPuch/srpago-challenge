package com.challenge.srpago.data.to;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: gpucheta<br/>
 * Date: 8/30/19<br/>
 * Time: 9:05 PM<br/>
 * Generated to
 */
public class GasStationTo {

    @JsonProperty("_id")
    private String id;
    private String calle;
    private String rfc;
    @JsonProperty("date_insert")
    private String dateInsert;
    @JsonProperty("regular")
    private String regularPrice;
    private String colonia;
    @JsonProperty("numeropermiso")
    private String numeroPermiso;
    private String permisoid;
    @JsonProperty("fechaaplicacion")
    private String fechaAplicacion;
    private String longitude;
    private String latitude;
    @JsonProperty("premium")
    private String premiumPrice;
    @JsonProperty("razonsocial")
    private String razonSocial;
    @JsonProperty("codigopostal")
    private String codigoPostal;
    @JsonProperty("dieasel")
    private String diesel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDateInsert() {
        return dateInsert;
    }

    public void setDateInsert(String dateInsert) {
        this.dateInsert = dateInsert;
    }

    public String getRegularPrice() {
        return regularPrice;
    }

    public void setRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
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

    public String getPermisoid() {
        return permisoid;
    }

    public void setPermisoid(String permisoid) {
        this.permisoid = permisoid;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getPremiumPrice() {
        return premiumPrice;
    }

    public void setPremiumPrice(String premiumPrice) {
        this.premiumPrice = premiumPrice;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDiesel() {
        return diesel;
    }

    public void setDiesel(String diesel) {
        this.diesel = diesel;
    }

    @Override
    public String toString() {
        return "GasStationTo{" +
                "id='" + id + '\'' +
                ", calle='" + calle + '\'' +
                ", rfc='" + rfc + '\'' +
                ", dateInsert='" + dateInsert + '\'' +
                ", regularPrice='" + regularPrice + '\'' +
                ", colonia='" + colonia + '\'' +
                ", numeroPermiso='" + numeroPermiso + '\'' +
                ", permisoId='" + permisoid + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", premiumPrice='" + premiumPrice + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", diesel='" + diesel + '\'' +
                '}';
    }
}
