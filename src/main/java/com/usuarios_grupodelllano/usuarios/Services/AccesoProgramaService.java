package com.usuarios_grupodelllano.usuarios.Services;

import java.math.BigInteger;
import java.util.List;

import com.usuarios_grupodelllano.usuarios.Entity.AccesoPrograma;

public interface AccesoProgramaService {

    // Crear Accesos_Programa en la lista
    void SaveAcceso_Programas(List<AccesoPrograma> list);

    // Obtiene Lista de Personas
    List<AccesoPrograma> findAll();

    // Crear un Acceder_Programa
    AccesoPrograma Save(AccesoPrograma acceso);

    // eliminar Acceso_Programa
    void delete(BigInteger id);

    // Modificar Acceder_Programa dado Id
    AccesoPrograma update(AccesoPrograma acceso, BigInteger id);

}
