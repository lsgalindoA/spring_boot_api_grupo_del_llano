package com.usuarios_grupodelllano.usuarios.Services;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import com.usuarios_grupodelllano.usuarios.Entity.AccesoPrograma;
import com.usuarios_grupodelllano.usuarios.Repository.AccesosProgramaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AccesoProgramaServiceImplement implements AccesoProgramaService {

    // repositorio de usuaio jpa
    @Autowired
    AccesosProgramaRepository accesosProgramaRepository;

    // inyecta dependencia
    public AccesoProgramaServiceImplement(AccesosProgramaRepository accesosProgramaRepository) {
        this.accesosProgramaRepository = accesosProgramaRepository;
    }

    @Override
    public List<AccesoPrograma> findAll() {
        try {
            return this.accesosProgramaRepository.findAll();
        } catch (Exception ex) {
            System.out.println("Error listar" + ex.getMessage());
            return null;
        }
    }

    @Transactional
    public void SaveAcceso_Programas(List<AccesoPrograma> list) {
        try {

            list.stream().forEach(acceso -> accesosProgramaRepository.save(acceso));

        } catch (Exception ex) {
            System.out.println("Error guardar" + ex.getMessage());
        }

    }

    @Transactional
    public AccesoPrograma Save(AccesoPrograma acceso) {
        try {
            this.accesosProgramaRepository.save(acceso);
            return acceso;
        } catch (Exception ex) {
            System.out.println("Error al guardar");
            return null;
        }
    }

    @Override
    public void delete(BigInteger id) {
        this.accesosProgramaRepository.delete(new AccesoPrograma(id));
    }

    @Override
    public AccesoPrograma update(AccesoPrograma nueva, BigInteger id) {
        return accesosProgramaRepository.findById(id)
                .map(
                        acceso -> {
                            acceso.setNombre(nueva.getNombre());
                            acceso.setOpcion(nueva.getOpcion());
                            return accesosProgramaRepository.save(acceso);
                        })
                .orElseThrow(() -> null);
    }
}
