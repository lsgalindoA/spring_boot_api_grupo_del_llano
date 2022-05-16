package com.usuarios_grupodelllano.usuarios.Services;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import javax.transaction.Transactional;

import com.usuarios_grupodelllano.usuarios.Entity.Empresa;
import com.usuarios_grupodelllano.usuarios.Entity.Persona;
import com.usuarios_grupodelllano.usuarios.Entity.Usuario;
import com.usuarios_grupodelllano.usuarios.ModelView.UsuariosApi;
import com.usuarios_grupodelllano.usuarios.Repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UsuarioServiceImplement implements UsuarioService {

    // repositorio de usuaio jpa
    @Autowired
    UsuarioRepository usuarioRepository;

    // inyecta dependencia
    public UsuarioServiceImplement(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> findAll() {
        try {
            List<Usuario> lista;
            lista = this.usuarioRepository.findAll();
            return lista;
        } catch (Exception ex) {
            System.out.println("Error listar" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<UsuariosApi> findAllUsersForApi() {
        try {
            List<Usuario> lista;
            lista = this.usuarioRepository.findAll();
            LinkedList<UsuariosApi> listaUsuarioApi = new LinkedList<UsuariosApi>();

            for (int i = 0; i < lista.size(); i++) {
                UsuariosApi u = new UsuariosApi(lista.get(i).getId(), lista.get(i).getUsuario(),
                        lista.get(i).getPass());
                listaUsuarioApi.add(u);
            }

            return listaUsuarioApi;
        } catch (Exception ex) {
            System.out.println("Error listar" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Empresa> findEmpresasbyIdUsuario(BigInteger id) {
        try {
            List<Empresa> lista;
            lista = this.usuarioRepository.findEmpresasbyIdUsuario(id);
            return lista;
        } catch (Exception ex) {
            System.out.println("Error listar" + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Empresa> findEmpresasbyIdUsuario1(BigInteger id) {
        try {
            List<Empresa> lista;
            lista = this.usuarioRepository.findEmpresasbyIdUsuario1(id);
            return lista;
        } catch (Exception ex) {
            System.out.println("Error listar" + ex.getMessage());
            return null;
        }
    }

    @Transactional
    public void SaveUsuarios(List<Usuario> list) {
        try {

            list.stream().forEach(usuario -> usuarioRepository.save(usuario));

        } catch (Exception ex) {
            System.out.println("Error guardar" + ex.getMessage());
        }

    }

    @Transactional
    public Usuario Save(Usuario usuario) {
        try {
            usuarioRepository.save(usuario);
            return usuario;
        } catch (Exception ex) {
            System.out.println("Error al guardar");
            return null;
        }
    }

    @Override
    public void delete(BigInteger id) {
        usuarioRepository.delete(new Usuario(id));
    }

    @Override
    public Usuario update(Usuario nuevo_usuario, Persona nueva_persona, BigInteger id) {
        return usuarioRepository.findById(id)
                .map(
                        usuario -> {
                            usuario.setUsuario(nuevo_usuario.getUsuario());
                            usuario.setEstado(nuevo_usuario.getEstado());
                            usuario.setTiempo(nuevo_usuario.getTiempo());
                            usuario.setPersona(nueva_persona);
                            return usuarioRepository.save(usuario);
                        })
                .orElseThrow(() -> null);
    }

}
