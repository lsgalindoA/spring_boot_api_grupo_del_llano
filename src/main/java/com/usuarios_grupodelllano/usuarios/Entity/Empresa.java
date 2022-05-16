package com.usuarios_grupodelllano.usuarios.Entity;

import java.math.BigInteger;

import javax.persistence.*;

//clase entity (es decir puede crear tablas y manejar BD)
@Entity
// creara una tabla llamada Persona
@Table(name = "Empresa")
public class Empresa {
    // campos de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable = false, unique = true)
    private BigInteger id;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    // constructor vacio
    public Empresa() {

    }

    // constructor con Id para actualizar
    public Empresa(BigInteger id) {
        this.id = id;
    }

    public Empresa(BigInteger id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public BigInteger getId() {
        return this.id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", nombre='" + getNombre() + "'" +
                "}";
    }

}
