package com.humanBooster.demoSpring.model;

import org.hibernate.annotations.Type;


import javax.persistence.*;

@Entity
@Table(name = "appreciation")
public class Appreciation {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Type(type = "text")
    private String description;

    @ManyToOne()
    @JoinColumn(name = "matiere_id", referencedColumnName = "id")
    private Matiere matiere;

    @ManyToOne()
    @JoinColumn(name = "etudiant_id", referencedColumnName = "id")
    private Etudiant etudiant;

    public Appreciation() {
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Integer getId() {
        return id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
