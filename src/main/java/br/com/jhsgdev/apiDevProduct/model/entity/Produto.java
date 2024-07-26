package br.com.jhsgdev.apiDevProduct.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "produtos", schema = "devproduct_schema")
@Data
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String reponsavel;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime data_criacao;

    @Column(name = "data_modificacao")
    private LocalDateTime data_modificacao;

    private String categoria;


    @PrePersist
    protected void onCreate() {
        this.data_criacao = LocalDateTime.now();
        this.data_modificacao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.data_modificacao = LocalDateTime.now();
    }
}
