package com.nigmacode.apirest.service;

import java.util.List;
import java.util.Optional;
import com.nigmacode.apirest.entity.Evento;

public interface EventoService {

    public List<Evento> findAll();

    public Optional<Evento> findById(int cod_evento);

    public void save(Evento evento);

    public void deleteById(int cod_evento);

    public List<Evento> findByNombre(String nombre);

    public List<Evento> findByExample(Evento evento);

}
