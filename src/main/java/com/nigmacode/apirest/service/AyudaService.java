package com.nigmacode.apirest.service;

import java.util.List;
import java.util.Optional;
import com.nigmacode.apirest.entity.Ayuda;

public interface AyudaService {

    public List<Ayuda> findAll();

    public Optional<Ayuda> findById(int cod_ayuda);

    public void save(Ayuda ayuda);

    public void deleteById(int cod_usuario);

    public List<Ayuda> findByTema(String tema);

    public List<Ayuda> findByExample(Ayuda ayuda);

}
