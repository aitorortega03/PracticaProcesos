package com.example.infocovid.Model;

public class PoblacionData {
    private String municipio_codigo;
    private float densidad_por_km2;
    private String municipio_codigo_ine;
    private String nuts4_nombre;
    private String municipio_nombre;
    private String nuts4_codigo;
    private float superficie_km2;

    public String getMunicipio_codigo() {
        return municipio_codigo;
    }

    public void setMunicipio_codigo(String municipio_codigo) {
        this.municipio_codigo = municipio_codigo;
    }

    public float getDensidad_por_km2() {
        return densidad_por_km2;
    }

    public void setDensidad_por_km2(float densidad_por_km2) {
        this.densidad_por_km2 = densidad_por_km2;
    }

    public String getMunicipio_codigo_ine() {
        return municipio_codigo_ine;
    }

    public void setMunicipio_codigo_ine(String municipio_codigo_ine) {
        this.municipio_codigo_ine = municipio_codigo_ine;
    }

    public String getNuts4_nombre() {
        return nuts4_nombre;
    }

    public void setNuts4_nombre(String nuts4_nombre) {
        this.nuts4_nombre = nuts4_nombre;
    }

    public String getMunicipio_nombre() {
        return municipio_nombre;
    }

    public void setMunicipio_nombre(String municipio_nombre) {
        this.municipio_nombre = municipio_nombre;
    }

    public String getNuts4_codigo() {
        return nuts4_codigo;
    }

    public void setNuts4_codigo(String nuts4_codigo) {
        this.nuts4_codigo = nuts4_codigo;
    }

    public float getSuperficie_km2() {
        return superficie_km2;
    }

    public void setSuperficie_km2(float superficie_km2) {
        this.superficie_km2 = superficie_km2;
    }
}
