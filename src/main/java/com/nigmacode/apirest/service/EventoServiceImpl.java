package com.nigmacode.apirest.service;

import java.util.List;
import java.util.Optional;

import com.nigmacode.apirest.entity.Evento;
import com.nigmacode.apirest.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class EventoServiceImpl implements EventoService{

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> findAll() {
        List<Evento> eventos = eventoRepository.findAll();
        return eventos;
    }

    @Override
    public Optional<Evento> findById(int cod_evento) {
        Optional<Evento> evento = eventoRepository.findById(cod_evento);
        return evento;
    }

    @Override
    public void save(Evento evento) {
        eventoRepository.save(evento);
    }

    @Override
    public void deleteById(int cod_evento) {
        eventoRepository.deleteById(cod_evento);
    }

    @Override
    public List<Evento> findByNombre(String nombre) {
        List<Evento> eventos = eventoRepository.findByNombre(nombre);
        return eventos;
    }

    @Override
    public List<Evento> findByExample(Evento evento) {
        Example<Evento> eventoExample = Example.of(evento);
        List<Evento> eventos = eventoRepository.findAll(eventoExample);

        return eventos;
    }
}
