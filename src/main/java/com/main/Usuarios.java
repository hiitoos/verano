package com.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuarios {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellidos")
    private String appellidos;
    @Column(name="email")
    private String email;

    public Usuarios(String nombre, String appellidos, String email) {
        setNombre(nombre);
        setAppellidos(appellidos);
        setEmail(email);
    }

    public Usuarios(){}

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppellidos() {
        return appellidos;
    }

    public void setAppellidos(String appellidos) {
        this.appellidos = appellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", appellidos='" + appellidos + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
