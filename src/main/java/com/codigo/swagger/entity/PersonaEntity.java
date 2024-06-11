package com.codigo.swagger.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name="personas")
@Getter
@Setter
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String tipoDoc;
    private String numDoc;
    private String nombres;
    private String apellidos;
    private int estado;
    private Timestamp dateCrea;
    private String usuaCrea;
    private Timestamp dateUpdate;
    private String usuaUpdate;
    private Timestamp dateDelete;
    private String usuaDelete;
}
