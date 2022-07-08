package com.nigmacode.apirest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.nigmacode.apirest.entity.Ayuda;
import com.nigmacode.apirest.entity.Usuario;
import com.nigmacode.apirest.service.AyudaService;
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

public class AyudaRestController {

    @Autowired
    private AyudaService ayudaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/ayuda")
    public List<Ayuda> findAll() {
        try {

        } catch (IllegalArgumentException err){
            List<Ayuda> p = new ArrayList<>();
            return p;
        }
        return ayudaService.findAll();
    }

    @GetMapping("/ayuda/ID/{ayudaId}")
    public Optional<Ayuda> getAyuda(@PathVariable int ayudaId){
        Optional<Ayuda> ayuda = ayudaService.findById(ayudaId);

        if(ayuda == null) {
            throw new RuntimeException("Ayuda id not found -"+ayudaId);
        }
        else {
            return ayuda;
        }
    }

    @GetMapping("/ayuda/{tema}")
    public List<Ayuda> getTema(@PathVariable String tema){
        List<Ayuda> ayudaList = ayudaService.findByTema(tema);

        if(ayudaList == null) {
            throw new RuntimeException("Ayuda theme not found -"+tema);
        }

        return ayudaList;
    }

    @GetMapping("/ayuda/params")
    public List<Ayuda> findByParameters(@RequestBody Ayuda ayuda){

        ayuda.setUsuario(1);
        List<Ayuda> list = ayudaService.findByExample(ayuda);
        for (Ayuda u :list) {
            u.toString();
        }
        if(list.isEmpty()){
            throw new RuntimeException("Ayuda not found");
        }
        return list;
    }

    @PostMapping("/ayuda")
    public Ayuda addAyuda(@RequestBody Ayuda ayuda) {

        ayuda.setCod_ayuda(0);

        Optional<Usuario> us = usuarioService.findById(ayuda.getUsuario());
        if(us == null){
            throw new RuntimeException("El usuario "+ayuda.getUsuario()+" no existe");
        } else {
            ayudaService.save(ayuda);
        }
        return ayuda;

    }

    @PutMapping("/ayuda")
    public Ayuda updateAyuda(@RequestBody Ayuda ayuda) {
        ayudaService.save(ayuda);
        return ayuda;
    }

    @DeleteMapping("/ayuda/{ayudaId}")
    public String deleteAyuda(@PathVariable int ayudaId) {

        Optional<Ayuda> ayuda = ayudaService.findById(ayudaId);

        if(ayuda == null) {
            throw new RuntimeException("Ayuda id not found -"+ayudaId);
        }
        ayudaService.deleteById(ayudaId);

        return "Deleted ayuda id - "+ayudaId;
    }
}
