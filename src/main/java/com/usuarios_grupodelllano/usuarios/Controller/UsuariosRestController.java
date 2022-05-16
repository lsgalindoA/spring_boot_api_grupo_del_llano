package com.usuarios_grupodelllano.usuarios.Controller;

import java.math.BigInteger;

import java.util.List;

import com.usuarios_grupodelllano.usuarios.Entity.Empresa;
import com.usuarios_grupodelllano.usuarios.Entity.PerfilUsuarioEmpresa;

import com.usuarios_grupodelllano.usuarios.ModelView.UsuariosApi;
import com.usuarios_grupodelllano.usuarios.Services.PerfilUsuarioEmpresaServiceImplement;
import com.usuarios_grupodelllano.usuarios.Services.UsuarioServiceImplement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
// ruta url donde se consumira los servicios API
@RequestMapping("/api")

public class UsuariosRestController {

    private UsuarioServiceImplement usuarios;
    private PerfilUsuarioEmpresaServiceImplement perfilusuarioEmpresa;

    public UsuariosRestController(UsuarioServiceImplement usuarios,
            PerfilUsuarioEmpresaServiceImplement perfilusuarioEmpresa) {
        this.usuarios = usuarios;
        this.perfilusuarioEmpresa = perfilusuarioEmpresa;
    }

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)

    ResponseEntity<List<UsuariosApi>> get() {
        List<UsuariosApi> lista = usuarios.findAllUsersForApi();
        try {
            return new ResponseEntity<List<UsuariosApi>>(lista, HttpStatus.OK);
        } catch (Exception ex) {
            return null;
        }
    }

    @RequestMapping(value = "/empresas_del_usuario", method = RequestMethod.GET)
    ResponseEntity<List<Empresa>> getEmpresasById(BigInteger id) {
        List<Empresa> lista = this.usuarios.findEmpresasbyIdUsuario(id);
        try {
            return new ResponseEntity<List<Empresa>>(lista, HttpStatus.OK);
        } catch (Exception ex) {
            return null;
        }
    }

    @RequestMapping(value = "/empresas_del_usuario1", method = RequestMethod.GET)
    ResponseEntity<List<Empresa>> getEmpresasById1(BigInteger id) {
        List<Empresa> lista = this.usuarios.findEmpresasbyIdUsuario1(id);
        try {
            return new ResponseEntity<List<Empresa>>(lista, HttpStatus.OK);
        } catch (Exception ex) {
            return null;
        }
    }

    @RequestMapping(value = "/perfiles_usuario_empresa", method = RequestMethod.GET)
    ResponseEntity<List<PerfilUsuarioEmpresa>> getPerfilUsuarioEmpresa(BigInteger id) {
        List<PerfilUsuarioEmpresa> lista = this.perfilusuarioEmpresa.findAll();
        try {
            return new ResponseEntity<List<PerfilUsuarioEmpresa>>(lista, HttpStatus.OK);
        } catch (Exception ex) {
            return null;
        }
    }

}
