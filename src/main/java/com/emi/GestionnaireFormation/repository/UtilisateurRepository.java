// package com.emi.GestionnaireFormation.repository;

// // Import de JpaRepository pour la persistance
// import org.springframework.data.jpa.repository.JpaRepository;

// import com.emi.GestionnaireFormation.model.Utilisateur;

// // Interface pour accéder aux utilisateurs en base de données
// public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

//     // Méthode personnalisée pour trouver un utilisateur par son matricule
//     Utilisateur findByMatricule(String matricule);
// }
package com.emi.GestionnaireFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emi.GestionnaireFormation.model.Utilisateur;

/**
 * Repository Spring Data pour accéder aux utilisateurs
 */
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    // Ajoute cette ligne :
    Utilisateur findByMatricule(String matricule);
}
