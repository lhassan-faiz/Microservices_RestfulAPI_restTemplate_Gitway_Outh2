package com.Microservice_Chercheurs.demo.services;

import com.Microservice_Chercheurs.demo.Entity.Chercheur;
import com.Microservice_Chercheurs.demo.model.Enseignant;
import com.Microservice_Chercheurs.demo.model.Projet;
import com.Microservice_Chercheurs.demo.repository.ChercheurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ChercheurService {

    private ChercheurRepository chercheurRepository;
    private RestTemplate restTemplate;

    @Autowired
    public ChercheurService(ChercheurRepository chercheurRepository) {
        this.chercheurRepository = chercheurRepository;
        this.restTemplate = new RestTemplate();
    }

    public Chercheur createChercheur(Chercheur chercheur) {
        return chercheurRepository.save(chercheur);
    }

    public List<Chercheur> getAllChercheurs() {
        List<Chercheur> chercheurs = chercheurRepository.findAll();
        for (Chercheur chercheur : chercheurs) {
            Enseignant enseignant = restTemplate.getForObject("http://localhost:8077/enseignants/" + chercheur.getEnseignantId(), Enseignant.class);
            Projet projet = restTemplate.getForObject("http://localhost:8099/projets/" + chercheur.getProjetId(), Projet.class);
            chercheur.setEnseignant(enseignant);
            chercheur.setProjet(projet);
        }
        return chercheurs;
    }

    public Chercheur getChercheurById(Long id) {
        Chercheur chercheur = chercheurRepository.findById(id).orElse(null);
        if (chercheur != null) {
            Enseignant enseignant = restTemplate.getForObject("http://localhost:8077/enseignants/" + chercheur.getEnseignantId(), Enseignant.class);
            Projet projet = restTemplate.getForObject("http://localhost:8099/projets/" + chercheur.getProjetId(), Projet.class);
            chercheur.setEnseignant(enseignant);
            chercheur.setProjet(projet);
        }
        return chercheur;
    }
}
