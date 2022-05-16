package com.usuarios_grupodelllano.usuarios.Services;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import com.usuarios_grupodelllano.usuarios.Entity.Perfil;
import com.usuarios_grupodelllano.usuarios.Repository.PerfilRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PerfilServiceImplement implements PerfilService {

    // repositorio de usuaio jpa
    @Autowired
    PerfilRepository perfilRepository;

    // inyecta dependencia
    public PerfilServiceImplement(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @Override
    public List<Perfil> findAll() {
        try {
            return this.perfilRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Error listar" + ex.getMessage());
            return null;
        }
    }

    @Transactional
    public void SavePerfiles(List<Perfil> list) {
        try {

            list.stream().forEach(usuario -> perfilRepository.save(usuario));

        } catch (Exception ex) {
            System.out.println("Error guardar" + ex.getMessage());
        }

    }

    @Transactional
    public Perfil Save(Perfil perfil) {
        try {
            perfilRepository.save(perfil);
            return perfil;
        } catch (Exception ex) {
            System.out.println("Error al guardar");
            return null;
        }
    }

    @Override
    public void delete(BigInteger id) {
        perfilRepository.delete(new Perfil(id));

    }

    @Override
    public Perfil update(Perfil nuevo_perfil, BigInteger id) {
        return perfilRepository.findById(id)
                .map(
                        perfil -> {
                            perfil.setNombre(nuevo_perfil.getNombre());
                            return perfilRepository.save(perfil);
                        })
                .orElseThrow(() -> null);
    }

}
