package com.Projets.demo.services;

import com.Projets.demo.Entity.Projet;
import com.Projets.demo.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjetService {

    @Autowired
    private ProjetRepository projetRepository;

    public Projet saveProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    public Projet getProjetById(Long id) {
        return projetRepository.findById(id).orElseThrow(() -> new RuntimeException("Projet not found"));
    }

    public Projet updateProjet(Long id, Projet updatedProjet) {
        return projetRepository.findById(id)
                .map(projet -> {
                    projet.setTitre(updatedProjet.getTitre());
                    projet.setDescription(updatedProjet.getDescription());
                    return projetRepository.save(projet);
                })
                .orElseThrow(() -> new RuntimeException("Projet not found"));
    }

    public void deleteProjet(Long id) {
        projetRepository.deleteById(id);
    }

    public List<Projet> findAllProjets() {
        return projetRepository.findAll();
    }
}
