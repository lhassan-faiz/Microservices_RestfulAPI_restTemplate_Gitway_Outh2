package com.Microservice_Enseignant.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String cne; // Unique identifier akin to a national ID for the teacher
    private String email;
    private String motDePasse; // This should be encrypted in a real application
    private String thematiqueDeRecherche;

    // Consider using JPA relationships if teachers are directly managing projects or researchers
}
