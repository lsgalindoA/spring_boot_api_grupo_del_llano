package com.usuarios_grupodelllano.usuarios.Services;

import java.math.BigInteger;
import java.util.List;

import com.usuarios_grupodelllano.usuarios.Entity.Persona;

public interface PersonaService {

    // Crear Personas en la lista
    void SavePersonas(List<Persona> list);

    // Obtiene Lista de Personas
    List<Persona> findAll();

    // Crear una Persona
    Persona Save(Persona persona);

    // eliminar persona
    void delete(BigInteger id);

    // Modificar Usuario dado Id
    Persona update(Persona usuario, BigInteger id);

}
