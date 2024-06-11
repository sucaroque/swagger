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
public class PersonaServiceImpl implements PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    //Crea persona
    @Override
    public PersonaEntity crear(PersonaEntity personaEntity) {
        personaEntity.setEstado(Constantes.ESTADO_ACTIVO);
        personaEntity.setUsuaCrea(Constantes.USUARIO_SISTEMA);
        personaEntity.setDateCrea(new Timestamp(System.currentTimeMillis()));
        return personaRepository.save(personaEntity);
    }

    @Override
    public Optional<PersonaEntity> buscarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<PersonaEntity> buscarTodos() {
        return List.of();
    }

    @Override
    public PersonaEntity actualizar(Long id, PersonaEntity datosParaActualizar) {
        //if(personaRepository.existsById(id)){
            Optional<PersonaEntity> personaRecuperada = personaRepository.findById(id);
            if (personaRecuperada.isPresent()) {
                PersonaEntity persona = personaRecuperada.get();
                persona.setTipoDoc(datosParaActualizar.getTipoDoc());
                persona.setNumDoc(datosParaActualizar.getNumDoc());
                persona.setNombres(datosParaActualizar.getNombres());
                persona.setApellidos(datosParaActualizar.getApellidos());
                persona.setDateUpdate(new Timestamp(System.currentTimeMillis()));
                persona.setUsuaUpdate(Constantes.USUARIO_SISTEMA);
                return personaRepository.save(persona);
            }else{
                return null;
            }
    }

    @Override
    public PersonaEntity borrar(Long id) {
        return null;
    }
}
