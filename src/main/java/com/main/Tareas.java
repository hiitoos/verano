package com.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="tareas")
public class Tareas {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="titulo")
    private String titulo;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="estado_id")
    private int estado;
    @Column(name="responsable")
    private int responsable;
    @Column(name="fechaCreacion")
    private java.sql.Date fechaCreacion;

    public Tareas(String titulo, String descripcion, int estado, int responsable, java.sql.Date fechaCreacion) {
        setTitulo(titulo);
        setDescripcion(descripcion);
        setEstado(estado);
        setResponsable(responsable);
        setFechaCreacion(fechaCreacion);
    }

    public Tareas(){}

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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getResponsable() {
        return responsable;
    }

    public void setResponsable(int responsable) {
        this.responsable = responsable;
    }

    public java.sql.Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(java.sql.Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Tareas{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", responsable='" + responsable + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
