package com.humanBooster.demoSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.humanBooster.demoSpring.model.Promotion;

@Repository
public interface PromotionRepository {
	List<Promotion> findByNom(String nom);
	List<Promotion> findByLieu(String lieu);
	List<Promotion> findByAnnee(String annee);
	
	@Query("SELECT p from Promotion p WHERE p.nom = :nom")
	List<Promotion> findWithHqlname(String nom);
}
