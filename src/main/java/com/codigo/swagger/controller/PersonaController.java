package com.codigo.swagger.controller;

import com.codigo.swagger.entity.PersonaEntity;
import com.codigo.swagger.service.PersonaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name = "API DE MANTENIMIENTO PERSONAS",
        description = "Esta api contiene todos los endPoint para el mantenimiento de la entidad persona."
)
public class PersonaController {
    @Qualifier("personaServiceImpl")
    @Autowired
    private PersonaService personaService;

    @Qualifier("personaServiceImpl2")
    @Autowired
    private PersonaService personaService2;

    @PostMapping()
    @Operation(summary = "Crea una Persona")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Persona creada exitosamente",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = PersonaEntity.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request, el request no cumple con lo esperado",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonaEntity.class))})
    })
    public ResponseEntity<PersonaEntity> crear(@RequestBody PersonaEntity personaEntity) {
        return ResponseEntity.ok(personaService.crear(personaEntity));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar una Persona")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Persona encontrada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonaEntity.class))}),
            @ApiResponse(responseCode = "404", description = "Not Found, Persona no encontrada",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PersonaEntity.class))})
    })
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
