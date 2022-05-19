package com.ntt.testntt.core.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tipos_documentos")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentTypeId;

    @Column(name = "tipo_documento")
    private char documentType;


}
