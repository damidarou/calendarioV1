package com.nigmacode.apirest.service;

import java.util.List;
import java.util.Optional;
import com.nigmacode.apirest.entity.Usuario;

public interface UsuarioService {

    public List<Usuario> findAll();

    public Optional<Usuario> findById(int cod_usuario);

    public void save(Usuario usuario);

    public void deleteById(int cod_usuario);

    public List<Usuario> findByUsername(String username);

    public List<Usuario> findByExample(Usuario usuario);
}
