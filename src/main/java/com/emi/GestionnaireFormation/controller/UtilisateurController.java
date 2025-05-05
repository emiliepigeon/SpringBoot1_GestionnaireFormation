package com.emi.GestionnaireFormation.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.emi.GestionnaireFormation.model.Role;
import com.emi.GestionnaireFormation.model.Utilisateur;
import com.emi.GestionnaireFormation.repository.RoleRepository;
import com.emi.GestionnaireFormation.repository.UtilisateurRepository;
import com.emi.GestionnaireFormation.service.RoleService;

/**
 * Contrôleur principal pour la gestion des utilisateurs.
 * Gère l'affichage, l'ajout, la modification, la suppression,
 * l'activation/désactivation et le changement de rôle.
 */
@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

    private final UtilisateurRepository utilisateurRepository;
    private final RoleRepository roleRepository;
    private final RoleService roleService;

    /**
     * Constructeur avec injection des dépendances nécessaires.
     */
    public UtilisateurController(
            UtilisateurRepository utilisateurRepository,
            RoleRepository roleRepository,
            RoleService roleService) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
        this.roleService = roleService;
    }

    /**
     * Affiche la liste de tous les utilisateurs.
     */
    @GetMapping("/liste")
    public String listeUtilisateurs(Model model) {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        List<Role> roles = roleService.findAll();
        model.addAttribute("utilisateurs", utilisateurs);
        model.addAttribute("roles", roles);
        return "utilisateur/liste";
    }

    /**
     * Affiche le formulaire d'ajout d'un nouvel utilisateur.
     */
    @GetMapping("/ajouter")
    public String afficherFormulaireAjout(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        model.addAttribute("roles", roleService.findAll());
        return "utilisateur/ajouter";
    }

    /**
     * Traite la soumission du formulaire d'ajout d'utilisateur.
     */
    @PostMapping("/ajouter")
    public String ajouterUtilisateur(
            @ModelAttribute Utilisateur utilisateur,
            @RequestParam Long roleId) {

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new IllegalArgumentException("Rôle invalide"));
        utilisateur.setRole(role);
        utilisateurRepository.save(utilisateur);
        return "redirect:/utilisateur/liste";
    }

    /**
     * Affiche le formulaire de modification d'un utilisateur existant.
     */
    @GetMapping("/modifier/{id}")
    public String afficherFormulaireModification(@PathVariable Long id, Model model) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur invalide"));
        model.addAttribute("utilisateur", utilisateur);
        model.addAttribute("roles", roleService.findAll());
        return "utilisateur/modifier";
    }

    /**
     * Traite la soumission du formulaire de modification d'utilisateur.
     */
    @PostMapping("/modifier/{id}")
    public String modifierUtilisateur(
            @PathVariable Long id,
            @ModelAttribute Utilisateur utilisateur,
            @RequestParam Long roleId) {

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new IllegalArgumentException("Rôle invalide"));
        utilisateur.setId(id);
        utilisateur.setRole(role);
        utilisateurRepository.save(utilisateur);
        return "redirect:/utilisateur/liste";
    }

    /**
     * Modifie uniquement le rôle d'un utilisateur (depuis la liste).
     */
    @PostMapping("/modifier-role/{id}")
    public String modifierRoleUtilisateur(
            @PathVariable Long id,
            @RequestParam Long roleId,
            RedirectAttributes redirectAttributes) {

        try {
            Utilisateur utilisateur = utilisateurRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Utilisateur introuvable"));
            Role role = roleRepository.findById(roleId)
                    .orElseThrow(() -> new IllegalArgumentException("Rôle introuvable"));
            utilisateur.setRole(role);
            utilisateurRepository.save(utilisateur);
            redirectAttributes.addFlashAttribute("success", "Rôle mis à jour avec succès");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erreur lors de la mise à jour du rôle");
        }
        return "redirect:/utilisateur/liste";
    }

    /**
     * Active un utilisateur (statut actif).
     */
    @PostMapping("/activer/{id}")
    public String activerUtilisateur(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur introuvable"));
        utilisateur.setStatut(true);
        utilisateurRepository.save(utilisateur);
        return "redirect:/utilisateur/liste";
    }

    /**
     * Désactive un utilisateur (statut inactif).
     */
    @PostMapping("/desactiver/{id}")
    public String desactiverUtilisateur(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur introuvable"));
        utilisateur.setStatut(false);
        utilisateurRepository.save(utilisateur);
        return "redirect:/utilisateur/liste";
    }

    /**
     * Supprime un utilisateur par son ID.Mais en réalité A ne pas faire. Utiliser un put avec le statut.
     */
    @GetMapping("/supprimer/{id}")
    public String supprimerUtilisateur(@PathVariable Long id) {
        utilisateurRepository.deleteById(id);
        return "redirect:/utilisateur/liste";
    }
}
