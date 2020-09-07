package com.main.application.domain.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    private int id;
    private String nombre;
    private String apellidos;
    private String email;
    @OneToMany(mappedBy = "responsable")
    private Set<Tarea> tareas;
   // @OneToOne(mappedBy = "usuario_id")
   // private Set<Login> usuario;

    public Usuario(String nombre, String apellidos, String email) {
        setNombre(nombre);
        setApellidos(apellidos);
        setEmail(email);
    }

    public Usuario(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String appellidos) {
        this.apellidos = appellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public Iterable<Tarea> getTareas(){
        return tareas;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", appellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
