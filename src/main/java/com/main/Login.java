package com.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="login")
public class Login {
    @Id
    @Column (name="usuarios")
    private String usuario;
    @Column (name="password")
    private String pass;

    public Login(String usuario, String pass) {
        setUsuario(usuario);
        setPass(pass);
    }

    public Login(){}

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
