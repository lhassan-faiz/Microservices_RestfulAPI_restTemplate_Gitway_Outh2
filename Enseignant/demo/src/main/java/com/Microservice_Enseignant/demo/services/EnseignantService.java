package com.Microservice_Enseignant.demo.services;

import com.Microservice_Enseignant.demo.entity.Enseignant;
import com.Microservice_Enseignant.demo.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnseignantService {

    @Autowired
    private EnseignantRepository enseignantRepository;

    public Enseignant saveEnseignant(Enseignant enseignant) {
        return enseignantRepository.save(enseignant);
    }

    public Enseignant getEnseignantById(Long id) {
        return enseignantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enseignant not found"));
    }

    public Enseignant updateEnseignant(Long id, Enseignant updatedEnseignant) {
        return enseignantRepository.findById(id)
                .map(enseignant -> {
                    enseignant.setNom(updatedEnseignant.getNom());
                    enseignant.setPrenom(updatedEnseignant.getPrenom());
                    enseignant.setCne(updatedEnseignant.getCne());
                    enseignant.setEmail(updatedEnseignant.getEmail());
                    enseignant.setMotDePasse(updatedEnseignant.getMotDePasse());
                    enseignant.setThematiqueDeRecherche(updatedEnseignant.getThematiqueDeRecherche());
                    return enseignantRepository.save(enseignant);
                })
                .orElseThrow(() -> new RuntimeException("Enseignant not found"));
    }

    public void deleteEnseignant(Long id) {
        enseignantRepository.deleteById(id);
    }

    public List<Enseignant> findAll() {
        return enseignantRepository.findAll();
    }
}
