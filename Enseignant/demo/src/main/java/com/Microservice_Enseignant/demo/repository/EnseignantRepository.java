package com.Microservice_Enseignant.demo.repository;


import com.Microservice_Enseignant.demo.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
}
