package com.humanBooster.demoSpring.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "critere_evaluation")
public class CritereEvaluation {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description", nullable = false)
    @NotNull(message = "Veuillez saisir une description")
    @NotBlank(message = "Veuillez saisir une description")
    private String description;



    @Column(name = "points_a_repartir", nullable = false)
    @NotNull(message = "Veuillez saisir les points à répartir")
    @NotBlank(message = "Veuillez saisir les points à repartir")
    private Float pointsReparti;

    @ManyToOne(optional = false)
    @JoinColumn(name = "matiere_id", referencedColumnName = "id")
    @NotNull(message = "Veuillez saisir une matière")
    @NotBlank(message = "Veuillez saisir une matière")
    private Matiere matiere;

    public CritereEvaluation() {
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

    public Float getPointsReparti() {
        return pointsReparti;
    }

    public void setPointsReparti(Float pointsReparti) {
        this.pointsReparti = pointsReparti;
    }
}
