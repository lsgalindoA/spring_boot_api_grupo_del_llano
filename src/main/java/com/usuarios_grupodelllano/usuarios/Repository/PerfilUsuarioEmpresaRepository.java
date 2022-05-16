package com.usuarios_grupodelllano.usuarios.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.usuarios_grupodelllano.usuarios.Entity.PerfilUsuarioEmpresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

@Repository

public interface PerfilUsuarioEmpresaRepository extends JpaRepository<PerfilUsuarioEmpresa, BigInteger> {

    // Obtiene lista de Usuario con JDA
    @Query("select pu from PerfilUsuarioEmpresa pu")
    List<PerfilUsuarioEmpresa> findAll();

    @Query("select  distinct pu from PerfilUsuarioEmpresa pu where pu.id=?1")
    Optional<PerfilUsuarioEmpresa> findById(BigInteger id);

    /*
     * @Query("SELECT new DeptEmpDto(d.name, e.name, e.email, e.address) "
     * + "FROM Department d LEFT JOIN d.employees e")
     * List<DeptEmpDto> fetchEmpDeptDataLeftJoin();
     */

}
