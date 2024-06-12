package com.codigo.swagger.controller;

import com.codigo.swagger.entity.PersonaEntity;
import com.codigo.swagger.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/persona")
public class PersonaController {
    @Qualifier("personaServiceImpl")
    @Autowired
    private PersonaService personaService;

    @Qualifier("personaServiceImpl2")
    @Autowired
    private PersonaService personaService2;

    @PostMapping()
    public ResponseEntity<PersonaEntity> crear(@RequestBody PersonaEntity personaEntity) {
        return ResponseEntity.ok(personaService.crear(personaEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PersonaEntity>> buscarPorId(@PathVariable long id) {
        return ResponseEntity.ok(personaService2.buscarPorId(id));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<PersonaEntity>> buscarTodos() {
        return ResponseEntity.ok(personaService2.buscarTodos());
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PersonaEntity> actualizar(@PathVariable long id, @RequestBody PersonaEntity personaEntity) {
        return ResponseEntity.ok(personaService.actualizar(id, personaEntity));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<PersonaEntity> eliminar(@PathVariable long id) {
        return ResponseEntity.ok(personaService2.borrar(id));
    }
    @GetMapping("/historico")
    public ResponseEntity<List<PersonaEntity>> buscarHistorico() {
        return ResponseEntity.ok(personaService2.buscarHistorico());
    }
}
