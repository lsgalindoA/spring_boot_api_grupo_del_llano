package com.usuarios_grupodelllano.usuarios.Services;

import java.math.BigInteger;
import java.util.List;

import com.usuarios_grupodelllano.usuarios.Entity.Empresa;
import com.usuarios_grupodelllano.usuarios.Entity.Perfil;
import com.usuarios_grupodelllano.usuarios.Entity.PerfilUsuarioEmpresa;
import com.usuarios_grupodelllano.usuarios.Entity.Usuario;

public interface PerfilUsuarioEmpresaService {

    // Crear PerfilUsuarioEmpresa en la lista
    void SavePerfilesUsuarioEmpresa(List<PerfilUsuarioEmpresa> list);

    // Obtiene Lista de PerfilUsuarioEmpresa
    List<PerfilUsuarioEmpresa> findAll();

    // Crear una PerfilUsuarioEmpresa
    PerfilUsuarioEmpresa Save(PerfilUsuarioEmpresa perfilUsuarioEmpresa);

    // eliminar PerfilUsuarioEmpresa
    void delete(BigInteger id);

    // Modificar PerfilUsuarioEmpresa dado Id
    PerfilUsuarioEmpresa update(PerfilUsuarioEmpresa perfilUsuarioEmpresa, Empresa empresa, Usuario usuario,
            Perfil perfil, BigInteger id);

}
