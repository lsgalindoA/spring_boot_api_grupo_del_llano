package com.usuarios_grupodelllano.usuarios.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.usuarios_grupodelllano.usuarios.Entity.Perfil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface PerfilRepository extends JpaRepository<Perfil, BigInteger> {

    // Obtiene lista de Usuario con JDA
    @Query("select pe from Perfil pe")
    List<Perfil> findAll();

    @Query("select  distinct pe from Perfil pe where pe.id=?1")
    Optional<Perfil> findById(BigInteger id);

}
