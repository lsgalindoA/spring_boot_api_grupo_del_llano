package com.usuarios_grupodelllano.usuarios.Services;

import java.math.BigInteger;
import java.util.List;

import com.usuarios_grupodelllano.usuarios.Entity.Empresa;
import com.usuarios_grupodelllano.usuarios.Entity.Persona;
import com.usuarios_grupodelllano.usuarios.Entity.Usuario;
import com.usuarios_grupodelllano.usuarios.ModelView.UsuariosApi;

public interface UsuarioService {

    // Crear usuarios en la lista
    void SaveUsuarios(List<Usuario> list);

    // Obtiene Lista de Usuarios
    List<Usuario> findAll();

    List<UsuariosApi> findAllUsersForApi();

    List<Empresa> findEmpresasbyIdUsuario(BigInteger id);

    List<Empresa> findEmpresasbyIdUsuario1(BigInteger id);

    // Crear un solo Usuario
    Usuario Save(Usuario usuario);

    // eliminar usuario
    void delete(BigInteger id);

    // Modificar Usuario dado Id
    Usuario update(Usuario usuario, Persona persona, BigInteger id);

}
