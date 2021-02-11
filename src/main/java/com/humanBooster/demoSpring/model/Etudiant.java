package com.humanBooster.demoSpring.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false)
    @NotNull(message = "Veuillez saisir un nom")
    @NotBlank(message = "Veuillez saisir les points à repartir")
    private String nom;

    @Column(name = "prenom", nullable = false)
    @NotNull(message = "Veuillez saisir un prénom")
    @NotBlank(message = "Veuillez saisir un prénom")
    private String prenom;

    @ManyToOne(optional = true)
    @JoinColumn(name = "promotion_id", referencedColumnName = "id", nullable = true)
    private Promotion promotion;
    
    

    public Etudiant(Long id,
			 String nom,
			 String prenom,
			 Promotion promotion) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.promotion = promotion;
	}
    
    

	public Etudiant(
			@NotNull(message = "Veuillez saisir un nom") @NotBlank(message = "Veuillez saisir les points à repartir") String nom,
			@NotNull(message = "Veuillez saisir un prénom") @NotBlank(message = "Veuillez saisir un prénom") String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}



	public Etudiant(
			 String nom,
			 String prenom,
			 Promotion promotion) {
		this.nom = nom;
		this.prenom = prenom;
		this.promotion = promotion;
	}



	public Etudiant() {
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Long getId() {
        return id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }



	@Override
	public String toString() {
		return "Etudiant []";
	}

	

}
