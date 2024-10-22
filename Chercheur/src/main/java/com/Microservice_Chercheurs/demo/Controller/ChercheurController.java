package com.Microservice_Chercheurs.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import com.Microservice_Chercheurs.demo.Entity.Chercheur;
import com.Microservice_Chercheurs.demo.services.ChercheurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RestController
@RequestMapping("/chercheurs")
public class ChercheurController {

    private static final Logger logger = LoggerFactory.getLogger(ChercheurController.class);

    @Autowired
    private ChercheurService chercheurService;

    @PostMapping
    public ResponseEntity<Chercheur> addChercheur(@Validated @RequestBody Chercheur chercheur) {
        try {
            Chercheur createdChercheur = chercheurService.createChercheur(chercheur);
            return ResponseEntity.ok(createdChercheur);
        } catch (Exception e) {
            logger.error("Error creating chercheur", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chercheur> getChercheurById(@PathVariable Long id) {
        try {
            Chercheur chercheur = chercheurService.getChercheurById(id);
            return ResponseEntity.ok(chercheur);
        } catch (RuntimeException e) {
            logger.error("Chercheur not found: {}", id, e);
            return ResponseEntity.notFound().build();
        }
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Chercheur> updateChercheur(@PathVariable Long id, @Validated @RequestBody Chercheur updatedChercheur) {
//        try {
//            Chercheur chercheur = chercheurService.updateChercheur(id, updatedChercheur);
//            return ResponseEntity.ok(chercheur);
//        } catch (RuntimeException e) {
//            logger.error("Failed to update chercheur: {}", id, e);
//            return ResponseEntity.notFound().build();
//        }
//    }



    @GetMapping
    public ResponseEntity<List<Chercheur>> getAllChercheurs() {
        try {
            List<Chercheur> chercheurs = chercheurService.getAllChercheurs();
            return ResponseEntity.ok(chercheurs);
        } catch (Exception e) {
            logger.error("Error retrieving all chercheurs", e);
            return ResponseEntity.badRequest().build();
        }
    }
}
