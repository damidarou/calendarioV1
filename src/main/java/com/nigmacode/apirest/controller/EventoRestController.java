package com.nigmacode.apirest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nigmacode.apirest.entity.Ayuda;
import com.nigmacode.apirest.entity.Evento;
import com.nigmacode.apirest.entity.Usuario;
import com.nigmacode.apirest.service.EventoService;
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

public class EventoRestController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/evento")
    public List<Evento> findAll() {
        try {

        } catch (IllegalArgumentException err){
            List<Evento> p = new ArrayList<>();
            return p;
        }
        return eventoService.findAll();
    }

    @GetMapping("/evento/ID/{eventoId}")
    public Optional<Evento> getAyuda(@PathVariable int eventoId){
        Optional<Evento> evento = eventoService.findById(eventoId);

        if(evento == null) {
            throw new RuntimeException("Evento id not found -"+eventoId);
        }
        else {
            return evento;
        }
    }

    @GetMapping("/evento/{nombre}")
    public List<Evento> getNombre(@PathVariable String nombre){
        List<Evento> eventoList = eventoService.findByNombre(nombre);

        if(eventoList == null) {
            throw new RuntimeException("Evento theme not found -"+nombre);
        }

        return eventoList;
    }

    @GetMapping("/evento/params")
    public List<Evento> findByParameters(@RequestBody Evento evento){

        List<Evento> list = eventoService.findByExample(evento);
        for (Evento u :list) {
            u.toString();
        }
        if(list.isEmpty()){
            throw new RuntimeException("Evento not found");
    }
        return list;
    }

    @PostMapping("/evento")
    public Evento addEvento(@RequestBody Evento evento) {

        evento.setCod_evento(0);

        Optional<Usuario> us = usuarioService.findById(evento.getUsuario());
        if(us == null){
            throw new RuntimeException("El usuario "+evento.getUsuario()+" no existe");
        } else {
            eventoService.save(evento);
        }
        return evento;

    }

    @PutMapping("/evento")
    public Evento updateEvento(@RequestBody Evento evento) {
        eventoService.save(evento);
        return evento;
    }

    @DeleteMapping("/evento/{eventoId}")
    public String deleteEvento(@PathVariable int eventoId) {

        Optional<Evento> evento = eventoService.findById(eventoId);

        if(evento == null) {
            throw new RuntimeException("Evento id not found -"+eventoId);
        }
        eventoService.deleteById(eventoId);

        return "Deleted evento id - "+eventoId;
    }
}
