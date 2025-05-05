package com.emi.GestionnaireFormation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entité Utilisateur
 * Représente un utilisateur dans la base de données
 */
@Entity
@Table(name = "utilisateur")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String matricule;
    private String nom;
    private String prenom;
    private String adresseMail;
    private String adressePostal;
    private String codePostal;
    private String ville;
    private String motDePasse;
    private Boolean statut; // true = actif, false = désactivé

    // Relation ManyToOne vers la table Role (clé étrangère role_id)
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMatricule() { return matricule; }
    public void setMatricule(String matricule) { this.matricule = matricule; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getAdresseMail() { return adresseMail; }
    public void setAdresseMail(String adresseMail) { this.adresseMail = adresseMail; }

    public String getAdressePostal() { return adressePostal; }
    public void setAdressePostal(String adressePostal) { this.adressePostal = adressePostal; }

    public String getCodePostal() { return codePostal; }
    public void setCodePostal(String codePostal) { this.codePostal = codePostal; }

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    public Boolean getStatut() { return statut; }
    public void setStatut(Boolean statut) { this.statut = statut; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

    // ---------------------------------------------
    // Exemple de méthode utilitaire désactivée
    // ---------------------------------------------
    /*
    public boolean estAdmin() {
        return role != null && "ADMIN".equalsIgnoreCase(role.getNom());
    }
    */
}
