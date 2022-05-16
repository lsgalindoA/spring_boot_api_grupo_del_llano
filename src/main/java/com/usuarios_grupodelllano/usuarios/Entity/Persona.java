package com.usuarios_grupodelllano.usuarios.Entity;

import java.math.BigInteger;

import javax.persistence.*;

//clase entity (es decir puede crear tablas y manejar BD)
@Entity

// creara una tabla llamada Persona
@Table(name = "Persona")

public class Persona {
    // campos de la tabla
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable = false, unique = true)
    private BigInteger id;

    @Column(name = "nombre", length = 50)
    private String nombre;

    // constructor vacio
    public Persona() {

    }

    // constructor con Id para actualizar
    public Persona(BigInteger Id) {
        this.id = Id;
    }

    // constructor con todos los campos
    public Persona(BigInteger id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // metodo sobre escrito convertir a String el Objecto Almacen

    @Override
    public String toString() {
        return "{" +
                " Id='" + getId() + "'" +
                ", Nombre='" + getNombre() + "'" +
                "}";
    }

    // metodo que retorna el ID
    public BigInteger getId() {
        return this.id;
    }

    // metodo que modifica el ID
    public void setId(BigInteger id) {
        this.id = id;
    }

    // metodo que Obtiene Nombre
    public String getNombre() {
        return this.nombre;
    }

    // metodo que modifica Nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
