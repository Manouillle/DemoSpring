package com.humanBooster.demoSpring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.humanBooster.demoSpring.model.Etudiant;

@Repository
public interface CandidatRepository extends CrudRepository<Etudiant, Long> {
	List<Etudiant> findByPrenom(String prenom);
	List<Etudiant> findByNom(String nom);
	
	
	@Query("SELECT e from Etudiant e WHERE e.nom = :nom")
	List<Etudiant> findWithHqlname(String nom);
	
	
	Optional<Etudiant> findById(Long id);
	
	
	@Override
	Iterable<Etudiant> findAll();

}
