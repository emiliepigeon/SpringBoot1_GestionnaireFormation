package com.emi.GestionnaireFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emi.GestionnaireFormation.model.Role;

/**
 * Repository Spring Data JPA pour l'entité Role
 * Fournit automatiquement les opérations CRUD de base
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Méthodes personnalisées peuvent être ajoutées ici
}
