package com.nigmacode.apirest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nigmacode.apirest.entity.Usuario;
import com.nigmacode.apirest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class UsuarioRestController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuario")
    public List<Usuario> findAll() {
        try {

        } catch (IllegalArgumentException err){
            List<Usuario> p = new ArrayList<>();
            return p;
        }
        return usuarioService.findAll();
    }

    @GetMapping("/usuario/ID/{userId}")
    public Optional<Usuario> getUser(@PathVariable int userId){
        Optional<Usuario> usuario = usuarioService.findById(userId);

        if(usuario == null) {
            throw new RuntimeException("User id not found -"+userId);
        }
        else {
            return usuario;
        }
    }

    @GetMapping("/usuario/{username}")
    public List<Usuario> getUsername(@PathVariable String username){
        List<Usuario> usuarioList = usuarioService.findByUsername(username);

        for (Usuario usuario : usuarioService.findByUsername(username)) {
            usuario.setAyudas(null);
            usuario.setEventos(null);
        }

        if (usuarioList == null) {
            throw new RuntimeException("User not fount-" + username);
        }
            return usuarioList;
    }

    @GetMapping("/usuario/params")
    public List<Usuario> findByParameters(@RequestBody Usuario usuario){

        List<Usuario> list = usuarioService.findByExample(usuario);

        for (Usuario u :list) {
            u.toString();
        }
        if(list.isEmpty()){
            throw new RuntimeException("User not found");
        }
        return list;
    }

    @PostMapping("/usuario")
    public Usuario addUser(@RequestBody Usuario usuario) {

        usuario.setCod_usuario(0);
        usuarioService.save(usuario);

        return usuario;

    }

    @PutMapping("/usuario")
    public Usuario updateUser(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
        return usuario;
    }

    @DeleteMapping("/usuario/{userId}")
    public String deleteUser(@PathVariable int userId) {

        Optional<Usuario> usuario = usuarioService.findById(userId);

        if(usuario == null) {
            throw new RuntimeException("User id not found -"+userId);
        }
        usuarioService.deleteById(userId);

        return "Deleted user id - "+userId;
    }
}
