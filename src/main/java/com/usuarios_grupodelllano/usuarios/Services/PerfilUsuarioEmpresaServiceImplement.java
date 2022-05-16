package com.usuarios_grupodelllano.usuarios.Services;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import com.usuarios_grupodelllano.usuarios.Entity.Empresa;
import com.usuarios_grupodelllano.usuarios.Entity.Perfil;
import com.usuarios_grupodelllano.usuarios.Entity.PerfilUsuarioEmpresa;
import com.usuarios_grupodelllano.usuarios.Entity.Usuario;
import com.usuarios_grupodelllano.usuarios.Repository.PerfilUsuarioEmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PerfilUsuarioEmpresaServiceImplement implements PerfilUsuarioEmpresaService {

    // repositorio de usuaio jpa
    @Autowired
    PerfilUsuarioEmpresaRepository perfilUsuarioEmpresaRepository;

    // inyecta dependencia
    public PerfilUsuarioEmpresaServiceImplement(PerfilUsuarioEmpresaRepository perfilUsuarioEmpresaRepository) {
        this.perfilUsuarioEmpresaRepository = perfilUsuarioEmpresaRepository;
    }

    @Override
    public List<PerfilUsuarioEmpresa> findAll() {
        try {
            return this.perfilUsuarioEmpresaRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Error listar" + ex.getMessage());
            return null;
        }
    }

    @Transactional
    public void SavePerfilesUsuarioEmpresa(List<PerfilUsuarioEmpresa> list) {
        try {

            list.stream()
                    .forEach(perfilesusuariosempresa -> perfilUsuarioEmpresaRepository.save(perfilesusuariosempresa));

        } catch (Exception ex) {
            System.out.println("Error guardar" + ex.getMessage());
        }

    }

    @Transactional
    public PerfilUsuarioEmpresa Save(PerfilUsuarioEmpresa perfilusuarioempresa) {
        try {
            perfilUsuarioEmpresaRepository.save(perfilusuarioempresa);
            return perfilusuarioempresa;
        } catch (Exception ex) {
            System.out.println("Error al guardar");
            return null;
        }
    }

    @Override
    public void delete(BigInteger id) {
        perfilUsuarioEmpresaRepository.delete(new PerfilUsuarioEmpresa(id));

    }

    @Override
    public PerfilUsuarioEmpresa update(PerfilUsuarioEmpresa nuevosdatos, Empresa empresa, Usuario usuario,
            Perfil perfil, BigInteger id) {
        return perfilUsuarioEmpresaRepository.findById(id)
                .map(
                        perfilusuarioempresa -> {
                            perfilusuarioempresa.setUsuario(nuevosdatos.getUsuario());
                            perfilusuarioempresa.setEmpresa(empresa);
                            perfilusuarioempresa.setUsuario(usuario);
                            perfilusuarioempresa.setPerfil(perfil);
                            return perfilUsuarioEmpresaRepository.save(perfilusuarioempresa);
                        })
                .orElseThrow(() -> null);
    }

}
