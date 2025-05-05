package com.emi.GestionnaireFormation.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entité représentant un rôle utilisateur
 */
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String libelle;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<Utilisateur> utilisateurs;

    // ------------------------
    // Constructeurs
    // ------------------------
    
    public Role() {
        // Requis par JPA
    }

    public Role(String libelle) {
        this.libelle = libelle;
    }

    // ------------------------
    // Getters/Setters
    // ------------------------
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    // ------------------------
    // Méthodes utilitaires
    // ------------------------
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role role)) return false;
        return Objects.equals(getId(), role.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
