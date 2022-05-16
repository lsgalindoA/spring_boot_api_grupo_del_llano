package com.usuarios_grupodelllano.usuarios.Services;

import java.math.BigInteger;
import java.util.List;

import com.usuarios_grupodelllano.usuarios.Entity.Empresa;

public interface EmpresaService {

    // Crear Personas en la lista
    void SaveEmpresas(List<Empresa> list);

    // Obtiene Lista de empresas
    List<Empresa> findAll();

    // Crear una empresa
    Empresa Save(Empresa empresa);

    // eliminar empresa
    void delete(BigInteger id);

    // Modificar empresa dado Id
    Empresa update(Empresa perfil, BigInteger id);

}
