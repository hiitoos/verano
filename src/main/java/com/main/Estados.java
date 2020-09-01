package com.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="estados")
public class Estados {
    @Id
    @Column (name="id")
    private int id;
    @Column (name="nombre")
    private String nombre;
    @Column (name="descripcion")
    private String descripcion;

    public Estados(String nombre, String descripcion) {
        setNombre(nombre);
        setDescripcion(descripcion);
    }
    public Estados(){}

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Estados{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
