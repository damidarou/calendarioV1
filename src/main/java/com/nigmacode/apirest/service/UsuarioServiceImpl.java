package com.nigmacode.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nigmacode.apirest.repository.UsuarioRepository;
import com.nigmacode.apirest.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarioList = usuarioRepository.findAll();
        return usuarioList;
    }

    @Override
    public Optional<Usuario> findById(int cod_usuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(cod_usuario);
        return usuario;
    }

    @Override
    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void deleteById(int cod_usuario) {
        usuarioRepository.deleteById(cod_usuario);
    }

    @Override
    public List<Usuario> findByUsername(String username) {
        List<Usuario> usuarioList = usuarioRepository.findByUsername(username);
        return usuarioList;
    }

    @Override
    public List<Usuario> findByExample(Usuario usuario) {
        Example<Usuario> usuarioExample = Example.of(usuario);
        List<Usuario> usuarios = usuarioRepository.findAll(usuarioExample);
        return usuarios;
    }
}
