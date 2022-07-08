package com.nigmacode.apirest.service;

import java.util.List;
import java.util.Optional;

import com.nigmacode.apirest.entity.Ayuda;
import com.nigmacode.apirest.repository.AyudaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class AyudaServiceImpl implements AyudaService{

    @Autowired
    private AyudaRepository ayudaRepository;

    @Override
    public List<Ayuda> findAll() {
        List<Ayuda> ayuda = ayudaRepository.findAll();
        return ayuda;
    }

    @Override
    public Optional<Ayuda> findById(int cod_ayuda) {
        Optional<Ayuda> ayuda = ayudaRepository.findById(cod_ayuda);
        return ayuda;
    }

    @Override
    public void save(Ayuda ayuda) {
        ayudaRepository.save(ayuda);
    }

    @Override
    public void deleteById(int cod_ayuda) {
        ayudaRepository.deleteById(cod_ayuda);
    }

    @Override
    public List<Ayuda> findByTema(String tema) {
        List<Ayuda> ayuda = ayudaRepository.findByTema(tema);
        return ayuda;
    }

    @Override
    public List<Ayuda> findByExample(Ayuda ayuda) {
        //ayuda.setUsuario(1);
        Example<Ayuda> ayudaExample = Example.of(ayuda);
        List<Ayuda> ayudas = ayudaRepository.findAll(ayudaExample);

        return ayudas;
    }
}
