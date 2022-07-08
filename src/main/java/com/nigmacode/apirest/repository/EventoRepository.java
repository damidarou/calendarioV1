package com.nigmacode.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nigmacode.apirest.entity.Evento;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer>{
    List<Evento> findByNombre(String nombre);
}
