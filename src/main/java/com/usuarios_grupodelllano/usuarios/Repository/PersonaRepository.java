package com.usuarios_grupodelllano.usuarios.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.usuarios_grupodelllano.usuarios.Entity.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface PersonaRepository extends JpaRepository<Persona, BigInteger> {

    // Obtiene lista de Personas con JDA
    @Query("select p from Persona p")
    List<Persona> findAll();

    @Query("select  distinct p from Persona p where p.id=?1")
    Optional<Persona> findById(BigInteger id);

}
