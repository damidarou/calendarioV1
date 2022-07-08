package com.nigmacode.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nigmacode.apirest.entity.Usuario;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    List<Usuario> findByUsername(String username);
}