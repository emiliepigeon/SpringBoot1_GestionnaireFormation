package com.emi.GestionnaireFormation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.emi.GestionnaireFormation.model.Role;
import com.emi.GestionnaireFormation.repository.RoleRepository;

/**
 * Service métier pour la gestion des rôles
 * Centralise la logique métier relative aux rôles
 */
@Service
public class RoleService {

    private final RoleRepository roleRepository;

    /**
     * Constructeur avec injection de dépendance
     * @param roleRepository Repository des rôles
     */
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * Récupère tous les rôles existants
     * @return Liste des rôles triés
     */
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
