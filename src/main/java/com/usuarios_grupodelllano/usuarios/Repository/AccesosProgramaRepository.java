package com.usuarios_grupodelllano.usuarios.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.usuarios_grupodelllano.usuarios.Entity.AccesoPrograma;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface AccesosProgramaRepository extends JpaRepository<AccesoPrograma, BigInteger> {

    // Obtiene lista de Usuario con JDA
    @Query("select ap from AccesoPrograma ap")
    List<AccesoPrograma> findAll();

    @Query("select  distinct ap from AccesoPrograma ap where ap.id=?1")
    Optional<AccesoPrograma> findById(BigInteger id);

}
