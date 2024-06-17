package com.codigo.swagger.dao;

import com.codigo.swagger.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
    //Optional<PersonaEntity> findByEstado(int estado);
    //List<PersonaEntity> findAllBy(int estado);
    List<PersonaEntity> findByEstado(int estado);
}
