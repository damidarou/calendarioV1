package com.nigmacode.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nigmacode.apirest.entity.Ayuda;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AyudaRepository extends JpaRepository<Ayuda, Integer>{
    List<Ayuda> findByTema(String tema);
}
