package com.Microservice_Chercheurs.demo.repository;

import com.Microservice_Chercheurs.demo.Entity.Chercheur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChercheurRepository extends JpaRepository<Chercheur, Long> {
}