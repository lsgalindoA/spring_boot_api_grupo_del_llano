package com.usuarios_grupodelllano.usuarios.Services;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import com.usuarios_grupodelllano.usuarios.Entity.Empresa;
import com.usuarios_grupodelllano.usuarios.Repository.EmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class EmpresaServiceImplement implements EmpresaService {

    // repositorio de usuaio jpa
    @Autowired
    EmpresaRepository empresaRepository;

    // inyecta dependencia
    public EmpresaServiceImplement(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public List<Empresa> findAll() {
        try {
            return this.empresaRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Error listar" + ex.getMessage());
            return null;
        }
    }

    @Transactional
    public void SaveEmpresas(List<Empresa> list) {
        try {

            list.stream().forEach(empresa -> empresaRepository.save(empresa));

        } catch (Exception ex) {
            System.out.println("Error guardar" + ex.getMessage());
        }

    }

    @Transactional
    public Empresa Save(Empresa empresa) {
        try {
            empresaRepository.save(empresa);
            return empresa;
        } catch (Exception ex) {
            System.out.println("Error al guardar");
            return null;
        }
    }

    @Override
    public void delete(BigInteger id) {
        empresaRepository.delete(new Empresa(id));

    }

    @Override
    public Empresa update(Empresa nueva, BigInteger id) {
        return empresaRepository.findById(id)
                .map(
                        empresa -> {
                            empresa.setNombre(nueva.getNombre());
                            return empresaRepository.save(empresa);
                        })
                .orElseThrow(() -> null);
    }

}
