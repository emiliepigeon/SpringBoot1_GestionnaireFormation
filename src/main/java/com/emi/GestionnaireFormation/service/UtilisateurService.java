package com.emi.GestionnaireFormation.service;

import java.util.List;

import com.emi.GestionnaireFormation.model.Utilisateur;
import com.emi.GestionnaireFormation.repository.UtilisateurRepository;

public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    // Constructeur pour recevoir le repository
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    // Retourne tous les utilisateurs
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    // Trouve un utilisateur avec son matricule
    public Utilisateur findByMatricule(String matricule) {
        return utilisateurRepository.findByMatricule(matricule);
    }

    // Sauvegarde un utilisateur (ajout ou modification)
    public Utilisateur save(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    // Supprime un utilisateur par son id
    // public void deleteById(Long id) {
    //     utilisateurRepository.deleteById(id);
    // }
}



// package com.emi.GestionnaireFormation.service;

// import com.emi.GestionnaireFormation.model.Utilisateur;
// import com.emi.GestionnaireFormation.repository.UtilisateurRepository;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.util.List;
// import java.util.Optional;

// @Service // Indique à Spring que c'est un composant service
// @Transactional // Gère automatiquement les transactions
// public class UtilisateurService {

//     private final UtilisateurRepository utilisateurRepository;

//     // Injection via constructeur (recommandé)
//     public UtilisateurService(UtilisateurRepository utilisateurRepository) {
//         this.utilisateurRepository = utilisateurRepository;
//     }

//     // Récupère tous les utilisateurs
//     public List<Utilisateur> findAll() {
//         return utilisateurRepository.findAll();
//     }

//     // Trouve un utilisateur par matricule
//     public Optional<Utilisateur> findByMatricule(String matricule) {
//         return utilisateurRepository.findByMatricule(matricule);
//     }

//     // Crée ou met à jour un utilisateur
//     public Utilisateur save(Utilisateur utilisateur) {
//         return utilisateurRepository.save(utilisateur);
//     }

//     // Supprime un utilisateur par son ID
//     public void deleteById(Long id) {
//         utilisateurRepository.deleteById(id);
//     }

//     // Met à jour partiellement un utilisateur
//     public Utilisateur update(Long id, Utilisateur updatedUser) {
//         return utilisateurRepository.findById(id)
//                 .map(existingUser -> {
//                     if(updatedUser.getNom() != null) existingUser.setNom(updatedUser.getNom());
//                     if(updatedUser.getPrenom() != null) existingUser.setPrenom(updatedUser.getPrenom());
//                     // Ajouter d'autres champs à mettre à jour...
//                     return utilisateurRepository.save(existingUser);
//                 })
//                 .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
//     }
// }
