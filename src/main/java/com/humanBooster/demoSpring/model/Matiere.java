package com.humanBooster.demoSpring.model;




import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "matiere")
public class Matiere {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nom", nullable = false)
    @NotNull(message = "Veuillez saisir un nom")
    @NotBlank(message = "Veuillez saisir le nom")
    private String nom;

    @Column(name = "date_examen", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Veuillez saisir une date examen")
    @NotBlank(message = "Veuillez saisir une date examen")
    private Date dateExamen;

    @Column(name = "duree", nullable = false)
    @NotNull(message = "Veuillez saisir une durée")
    @NotBlank(message = "Veuillez saisir une durée")
    private Float duree;

    @Column(name = "modalite", nullable = false)
    @NotNull(message = "Veuillez saisir une durée")
    @NotBlank(message = "Veuillez saisir une durée")
    private String modalite;

    @ManyToOne(optional = false)
    @JoinColumn(name = "promotion_id", referencedColumnName = "id")
    private Promotion promotion;

    @OneToMany(mappedBy = "matiere")
    private List<CritereEvaluation> criteresEvaluation;


    public Matiere() {
        this.criteresEvaluation = new ArrayList<CritereEvaluation>();
    }

    public List<CritereEvaluation> getCriteresEvaluation(){
        return  this.criteresEvaluation;
    }

    public void addCritereEvaluation(CritereEvaluation ce) {
        this.criteresEvaluation.add(ce);
    }

    public void removeCritereEvaluation(CritereEvaluation ce) {
        this.criteresEvaluation.remove(ce);
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Integer getId() {
        return id;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateExamen() {
        return dateExamen;
    }

    public void setDateExamen(Date dateExamen) {
        this.dateExamen = dateExamen;
    }

    public Float getDuree() {
        return duree;
    }

    public void setDuree(Float duree) {
        this.duree = duree;
    }

    public String getModalite() {
        return modalite;
    }

    public void setModalite(String modalite) {
        this.modalite = modalite;
    }




}
