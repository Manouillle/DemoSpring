package com.humanBooster.demoSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.humanBooster.demoSpring.model.Etudiant;
import com.humanBooster.demoSpring.repository.CandidatRepository;

@Service
public class CandidatService {
	
	private CandidatRepository candidatRepository;
	
	public CandidatService(CandidatRepository candidatRepository) {
		this.candidatRepository = candidatRepository;
	}
	
	public List<Etudiant> getCandidats(){
		return (List<Etudiant>) this.candidatRepository.findAll();
	}
	
	public Optional<Etudiant> getCandidat(Long id) {
		return this.candidatRepository.findById( id );
	}
	
	public void saveOrUpdateCandidat(Etudiant etudiant) {
		this.candidatRepository.save(etudiant);
	}
	
	public void deleteCandidat(Etudiant etudiant) {
		this.candidatRepository.delete(etudiant);
	}
	
	public Optional<Etudiant> findById(Long id) {
		return this.candidatRepository.findById(id);
	}
}
