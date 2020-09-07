package com.main.application.domain.entities;

import javax.persistence.*;

@Entity
@Table (name="login")
public class Login {
    @Id
    private String usuario;
    private String password;
    //@OneToOne (mappedBy = "id")
    //private Usuario usuario_id;

    public Login(String usuario, String pass) {
        setUsuario(usuario);
        setPassword(pass);
    }

    public Login(){}

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
