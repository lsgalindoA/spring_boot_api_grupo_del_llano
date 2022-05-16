package com.usuarios_grupodelllano.usuarios.Entity;

import java.math.BigInteger;

import javax.persistence.*;

//clase entity (es decir puede crear tablas y manejar BD)
@Entity
// creara una tabla llamada Persona

@Table(name = "AccesoPrograma")

public class AccesoPrograma {
    // campos de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable = false, unique = true)
    private BigInteger id;

    @JoinColumn(name = "id_pusuario_empresa", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PerfilUsuarioEmpresa perfilUsuarioEmpresa;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "opcion", nullable = false)
    private String opcion;

    // constructor vacio
    public AccesoPrograma() {

    }

    // constructor con Id para actualizar
    public AccesoPrograma(BigInteger id) {
        this.id = id;
    }

    public AccesoPrograma(BigInteger id, PerfilUsuarioEmpresa perfilUsuarioEmpresa, String nombre, String opcion) {
        this.id = id;
        this.perfilUsuarioEmpresa = perfilUsuarioEmpresa;
        this.nombre = nombre;
        this.opcion = opcion;
    }

    public BigInteger getId() {
        return this.id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public PerfilUsuarioEmpresa getPerfilUsuarioEmpresa() {
        return this.perfilUsuarioEmpresa;
    }

    public void setPerfilUsuarioEmpresa(PerfilUsuarioEmpresa perfilUsuarioEmpresa) {
        this.perfilUsuarioEmpresa = perfilUsuarioEmpresa;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOpcion() {
        return this.opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", perfilUsuarioEmpresa='" + getPerfilUsuarioEmpresa() + "'" +
                ", nombre='" + getNombre() + "'" +
                ", opcion='" + getOpcion() + "'" +
                "}";
    }

}
