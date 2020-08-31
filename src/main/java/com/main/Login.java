package com.main;

public class Login {
    String usuario;
    String pass;

    public Login(String usuario, String pass) {
        setUsuario(usuario);
        setPass(pass);
    }

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
