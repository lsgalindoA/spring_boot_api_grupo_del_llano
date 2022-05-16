package com.usuarios_grupodelllano.usuarios.Entity;

import java.math.BigInteger;

import javax.persistence.*;

//clase entity (es decir puede crear tablas y manejar BD)
@Entity
// creara una tabla llamada Persona

@Table(name = "PerfilesUE")

public class PerfilUsuarioEmpresa {
    // campos de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable = false, unique = true)
    private BigInteger id;

    @JoinColumn(name = "id_usuario", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuario;

    @JoinColumn(name = "id_empresa", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Empresa empresa;

    @JoinColumn(name = "id_perfil", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Perfil perfil;

    // constructor vacio
    public PerfilUsuarioEmpresa() {

    }

    // constructor con Id para actualizar
    public PerfilUsuarioEmpresa(BigInteger id) {
        this.id = id;
    }

    public PerfilUsuarioEmpresa(BigInteger id, Usuario usuario, Empresa empresa, Perfil perfil) {
        this.id = id;
        this.usuario = usuario;
        this.empresa = empresa;
        this.perfil = perfil;
    }

    public BigInteger getId() {
        return this.id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Perfil getPerfil() {
        return this.perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", usuario='" + getUsuario() + "'" +
                ", empresa='" + getEmpresa() + "'" +
                ", perfil='" + getPerfil() + "'" +
                "}";
    }

}
