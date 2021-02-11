package com.humanBooster.demoSpring.model;

import javax.persistence.*;

@Entity
@Table(name = "note_critere")
public class NoteCritere {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private Float valeur;

    @ManyToOne()
    @JoinColumn(name = "etudiant_id", referencedColumnName = "id")
    private Etudiant etudiant;

    @ManyToOne()
    @JoinColumn(name = "critere_evaluation_id", referencedColumnName = "id")
    private CritereEvaluation critereEvaluation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getValeur() {
        return valeur;
    }

    public void setValeur(Float valeur) {
        this.valeur = valeur;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public CritereEvaluation getCritereEvaluation() {
        return critereEvaluation;
    }

    public void setCritereEvaluation(CritereEvaluation critereEvaluation) {
        this.critereEvaluation = critereEvaluation;
    }

}
