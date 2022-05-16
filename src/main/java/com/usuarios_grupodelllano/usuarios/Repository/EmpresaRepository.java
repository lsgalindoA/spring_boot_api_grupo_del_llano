package com.usuarios_grupodelllano.usuarios.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.usuarios_grupodelllano.usuarios.Entity.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface EmpresaRepository extends JpaRepository<Empresa, BigInteger> {

    // Obtiene lista de Usuario con JDA
    @Query("select e from Empresa e")
    List<Empresa> findAll();

    @Query("select  distinct e from Empresa e where e.id=?1")
    Optional<Empresa> findById(BigInteger id);

}
