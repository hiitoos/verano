package com.main.application.domain.entities;

import com.main.application.repositories.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="tareas")
public class Tarea implements Serializable {
    @Id
    private int id;
    private String titulo;
    private String descripcion;
    @Column(name = "estados_id")
    private int estado;

    @ManyToOne
    @JoinColumn(name = "responsable", nullable = true)
    private Usuario responsable;

    private java.sql.Date fechaCreacion;

    public Tarea(String titulo, String descripcion, int estado, int responsable, java.sql.Date fechaCreacion) {
        setTitulo(titulo);
        setDescripcion(descripcion);
        setEstado(estado);
        setResponsable(responsable);
        setFechaCreacion(fechaCreacion);
    }

    public Tarea(){}

    public void setId(int id) {
        this.id = id;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getResponsable() {
        return this.responsable.getId();
    }

    public void setResponsable(int responsable) {
        //this.responsable.setId(responsable);
        List<Usuario> lista_usu = Hibernate.idUsuario();
        for (Usuario usu : lista_usu){
            if (usu.getId() == responsable){
                this.responsable = usu;
            }
        }

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
                ", responsable='" + responsable.getId() + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
