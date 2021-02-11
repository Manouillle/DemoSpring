package com.humanBooster.demoSpring;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.humanBooster.demoSpring.model.Etudiant;
import com.humanBooster.demoSpring.repository.CandidatRepository;

@SpringBootApplication
public class DemoSpringApplication {

	private Logger logger = LoggerFactory.getLogger(DemoSpringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner testData(CandidatRepository candidatRepository) {
		return (args) -> {

		
			logger.info("Ici je sauvegarde un étudiant !!");
			candidatRepository.save(new Etudiant("CAYROLLES", "Manon"));

			logger.info("Ici je créé 3 étudiants!!");
			List<Etudiant> etudiantList = new ArrayList<Etudiant>();
			etudiantList.add(new Etudiant("HARDY", "Tom"));
			etudiantList.add(new Etudiant("GOSLING", "Ryan"));
			etudiantList.add(new Etudiant("TEST", "Test"));
			
			logger.info("Ici je sauvegarde 3 étudiants !!");
			candidatRepository.saveAll(etudiantList);
		};
	}

}
