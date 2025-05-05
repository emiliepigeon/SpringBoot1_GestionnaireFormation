package com.emi.GestionnaireFormation;

// Import de Spring Boot pour démarrer l'application
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Annotation qui indique que c'est une application Spring Boot
@SpringBootApplication
public class GestionnaireFormationApplication {

    // Point d'entrée principal de l'application
    public static void main(String[] args) {
        // Cette ligne démarre le serveur Spring Boot
        SpringApplication.run(GestionnaireFormationApplication.class, args);
    }
}
