package com.humanBooster.demoSpring.model;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Basic(optional = false)
    @NotNull(message = "Veuillez ssaisir un nom")
    private String nom;

    @Basic(optional = false)
    @NotNull(message = "Veuillez ssaisir un lieu")
    private String lieu;

    @Basic(optional = false)
    @NotNull(message = "Veuillez ssaisir une année")
    private Integer annee;

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }


    public Promotion() {
    }


}
