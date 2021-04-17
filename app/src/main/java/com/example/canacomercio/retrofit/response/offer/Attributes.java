
package com.example.canacomercio.retrofit.response.offer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes {

    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("fecha_inicio")
    @Expose
    private String fechaInicio;
    @SerializedName("fecha_fin")
    @Expose
    private String fechaFin;
    @SerializedName("bonificacion")
    @Expose
    private Integer bonificacion;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("imagen_path")
    @Expose
    private String imagenPath;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Attributes() {
    }

    /**
     * 
     * @param descripcion
     * @param fechaInicio
     * @param bonificacion
     * @param imagenPath
     * @param nombre
     * @param fechaFin
     */
    public Attributes(String nombre, String fechaInicio, String fechaFin, Integer bonificacion, String descripcion, String imagenPath) {
        super();
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.bonificacion = bonificacion;
        this.descripcion = descripcion;
        this.imagenPath = imagenPath;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(Integer bonificacion) {
        this.bonificacion = bonificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenPath() {
        return imagenPath;
    }

    public void setImagenPath(String imagenPath) {
        this.imagenPath = imagenPath;
    }

}
