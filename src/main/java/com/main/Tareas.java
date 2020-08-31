package com.main;

import java.util.Date;

public class Tareas {
    int id;
    String titulo;
    String descripcion;
    String estado; //0 NO prestado - 1 Prestado
    String responsable;
    Date fechaCreacion;

    public Tareas(String titulo, String descripcion, String estado, String responsable, Date fechaCreacion) {
        setTitulo(titulo);
        setDescripcion(descripcion);
        setEstado(estado);
        setResponsable(responsable);
        setFechaCreacion(fechaCreacion);
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String isEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
