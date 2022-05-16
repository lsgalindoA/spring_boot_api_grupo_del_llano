package com.usuarios_grupodelllano.usuarios.Services;

import java.math.BigInteger;
import java.util.List;

import com.usuarios_grupodelllano.usuarios.Entity.Perfil;

public interface PerfilService {

    // Crear Personas en la lista
    void SavePerfiles(List<Perfil> list);

    // Obtiene Lista de Personas
    List<Perfil> findAll();

    // Crear un perfil
    Perfil Save(Perfil perfil);

    // eliminar perfil
    void delete(BigInteger id);

    // Modificar perfi dado Id
    Perfil update(Perfil perfil, BigInteger id);

}
