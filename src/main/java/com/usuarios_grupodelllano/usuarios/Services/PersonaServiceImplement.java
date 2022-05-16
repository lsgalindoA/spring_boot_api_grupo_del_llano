package com.usuarios_grupodelllano.usuarios.Services;

import java.math.BigInteger;
import java.util.List;

import com.usuarios_grupodelllano.usuarios.Entity.Persona;
import com.usuarios_grupodelllano.usuarios.Repository.PersonaRepository;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PersonaServiceImplement implements PersonaService {

    // clase repesotory declarada
    @Autowired
    private PersonaRepository personaRepository;

    // constructor par inyectar la dependecia de repositorio de la BD
    public PersonaServiceImplement(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public List<Persona> findAll() {
        return this.personaRepository.findAll();
    }

    @Transactional
    public void SavePersonas(List<Persona> personas) {
        try {
            personas.stream()
                    .forEach(persona -> personaRepository.save(persona));
        } catch (Exception e) {
            System.out.println("Excepcion transaccional en Save Almacenes");
        }
    }

    @Transactional
    public Persona Save(Persona persona) {
        try {
            personaRepository.save(persona);
            return persona;
        } catch (Exception ex) {
            System.out.println("Error al guardar");
            return null;
        }
    }

    @Override
    public void delete(BigInteger id) {
        personaRepository.delete(new Persona(id));
    }

    @Transactional
    public Persona update(Persona nueva_persona, BigInteger id) {

        return personaRepository.findById(id)
                .map(
                        persona -> {
                            persona.setNombre(nueva_persona.getNombre());
                            return personaRepository.save(persona);
                        })
                .orElseThrow(() -> null);
    }
}
