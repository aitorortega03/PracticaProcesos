package com.example.infocovid.Model;

public class Atributes {
    private String OBJECTID;
    private String DSMUNI;
    /*private String codigo_geo;*/
    /*private int casos_confirmados_totales;*/
    private float tasa_incidencia_acumulada_ultim;
    /*private float tasa_incidencia_acumulada_total;*/
    private int casos_confirmados_ultimos_14dia;
    private String fecha_informe;
    /*private int FECHA;
    private int ID;
    private int Shape__Area;
    private int Shape__Length;*/

    public String getOBJECTID() {
        return OBJECTID;
    }

    public void setOBJECTID(String OBJECTID) {
        this.OBJECTID = OBJECTID;
    }

    public String getDSMUNI() {
        return DSMUNI;
    }

    public void setDSMUNI(String DSMUNI) {
        this.DSMUNI = DSMUNI;
    }

    public float getTasa_incidencia_acumulada_ultim() {
        return tasa_incidencia_acumulada_ultim;
    }

    public void setTasa_incidencia_acumulada_ultim(float tasa_incidencia_acumulada_ultim) {
        this.tasa_incidencia_acumulada_ultim = tasa_incidencia_acumulada_ultim;
    }

    public int getCasos_confirmados_ultimos_14dia() {
        return casos_confirmados_ultimos_14dia;
    }

    public void setCasos_confirmados_ultimos_14dia(int casos_confirmados_ultimos_14dia) {
        this.casos_confirmados_ultimos_14dia = casos_confirmados_ultimos_14dia;
    }

    public String getFecha_informe() {
        return fecha_informe;
    }

    public void setFecha_informe(String fecha_informe) {
        this.fecha_informe = fecha_informe;
    }
}
