package com.usuarios_grupodelllano.usuarios.Entity;

import java.math.BigInteger;

import javax.persistence.*;

//clase entity (es decir puede crear tablas y manejar BD)
@Entity
// creara una tabla llamada Usuario
@Table(name = "Usuario")

public class Usuario {
    // campos de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable = false, unique = true)
    private BigInteger id;

    @JoinColumn(name = "id_persona", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Persona persona;

    @Column(name = "usuario", length = 20)
    String usuario;

    @Column(name = "pass", length = 200)
    String pass;

    @Column(name = "estado", length = 1)
    String estado;

    @Column(name = "tiempo", nullable = false)
    int tiempo;

    // constructor vacio
    public Usuario() {

    }

    // constructor con Id para actualizar
    public Usuario(BigInteger id) {
        this.id = id;
    }

    public Usuario(BigInteger id, Persona persona, String usuario, String pass, String estado, int tiempo) {
        this.id = id;
        this.persona = persona;
        this.usuario = usuario;
        this.pass = pass;
        this.estado = estado;
        this.tiempo = tiempo;
    }

    public BigInteger getId() {
        return this.id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", persona='" + getPersona() + "'" +
                ", usuario='" + getUsuario() + "'" +
                ", pass='" + getPass() + "'" +
                ", estado='" + getEstado() + "'" +
                ", tiempo='" + getTiempo() + "'" +
                "}";
    }

}
