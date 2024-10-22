package com.Microservice_Chercheurs.demo.Entity;

import com.Microservice_Chercheurs.demo.model.Enseignant;
import com.Microservice_Chercheurs.demo.model.Projet;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Chercheur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private Long ProjetId;
    private Long EnseignantId;
    @Transient
    private Enseignant enseignant;
    @Transient
    private Projet projet;

    // Getters et Setters
}
