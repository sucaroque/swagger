package com.codigo.swagger.service.impl;

import com.codigo.swagger.constants.Constantes;
import com.codigo.swagger.dao.PersonaRepository;
import com.codigo.swagger.entity.PersonaEntity;
import com.codigo.swagger.service.PersonaService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
@Service
public class PersonaServiceImpl2 implements PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaServiceImpl2(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public PersonaEntity crear(PersonaEntity personaEntity) {
        return null;
    }

    @Override
    public Optional<PersonaEntity> buscarPorId(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public List<PersonaEntity> buscarTodos() {
        return personaRepository.findByEstado(Constantes.ESTADO_ACTIVO).stream().toList();
    }

    @Override
    public PersonaEntity actualizar(Long id, PersonaEntity personaEntity) {
        return null;
    }

    @Override
    public PersonaEntity borrar(Long id) {
        Optional<PersonaEntity> personaRecuperada = personaRepository.findById(id);
        if (personaRecuperada.isPresent()) {
            PersonaEntity persona = personaRecuperada.get();
            persona.setEstado(0);
            persona.setDateDelete(new Timestamp(System.currentTimeMillis()));
            persona.setUsuaDelete(Constantes.USUARIO_SISTEMA);
            return personaRepository.save(persona);
        }
        return null;
    }
}
