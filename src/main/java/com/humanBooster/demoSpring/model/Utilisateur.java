package com.humanBooster.demoSpring.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    @Basic(optional = false)
    @NotNull(message = "Veuillez saisir un username")
    @NotBlank(message = "Veuillez saisir un username")
    private String username;

    @Basic(optional = false)
    @NotNull(message = "Veuillez saisir un role")
    @NotBlank(message = "Veuillez saisir un role")
    private String roles;

    @Basic(optional = false)
    @NotNull(message = "Veuillez saisir un password")
    @NotBlank(message = "Veuillez saisir un password")
    private String password;

    public Utilisateur() {
    }

    public Utilisateur(@NotNull(message = "Veuillez saisir un username")
                       @NotBlank(message = "Veuillez saisir un username") String username,
                       @NotNull(message = "Veuillez saisir un role") @NotBlank(message = "Veuillez saisir un role") String roles,
                       @NotNull(message = "Veuillez saisir un password") @NotBlank(message = "Veuillez saisir un password") String password) {
        this.username = username;
        this.roles = roles;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
