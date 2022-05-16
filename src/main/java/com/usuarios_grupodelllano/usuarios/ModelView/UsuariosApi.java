package com.usuarios_grupodelllano.usuarios.ModelView;

import java.math.BigInteger;

public class UsuariosApi {

    private BigInteger id;
    private String usuario;
    private String contrasena;

    public UsuariosApi(BigInteger id, String usuario, String contrasena) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public BigInteger getId() {
        return this.id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", usuario='" + getUsuario() + "'" +
                ", password='" + getContrasena() + "'" +
                "}";
    }

}
