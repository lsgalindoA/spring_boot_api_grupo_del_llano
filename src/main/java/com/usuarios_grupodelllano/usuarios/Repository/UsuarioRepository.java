package com.usuarios_grupodelllano.usuarios.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.usuarios_grupodelllano.usuarios.Entity.Empresa;
import com.usuarios_grupodelllano.usuarios.Entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, BigInteger> {

    // Obtiene lista de Usuario con JDA
    @Query("select u from Usuario u")
    List<Usuario> findAll();

    @Query("select  distinct u from Usuario u where u.id=?1")
    Optional<Usuario> findById(BigInteger id);

    @Query(value = "select distinct e.id, e.nombre from Empresa e inner join PerfilesUE pu on pu.id_empresa=e.id where pu.id_usuario=:id", nativeQuery = true)
    List<Empresa> findEmpresasbyIdUsuario1(@Param("id") BigInteger id);

    @Query("select distinct e from Empresa e , PerfilUsuarioEmpresa p where e=p.empresa and p.usuario.id=:id")
    List<Empresa> findEmpresasbyIdUsuario(@Param("id") BigInteger id);

}
