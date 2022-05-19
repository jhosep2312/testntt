package com.ntt.testntt.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "clientes")
public class Customer {

    @Id
    @JsonIgnore
    private Long customerId;

    private String primer_nombre;

    private String segundo_nombre;

    private String primer_apellido;

    private String segundo_apellido;

    private Long telefono;

    private String direccion;

    private String ciudad_residencia;

    @JsonIgnore
    private char tipoDocumento;

}
