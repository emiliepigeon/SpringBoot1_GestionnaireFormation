package com.emi.GestionnaireFormation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {
    @GetMapping("/")
    public String accueil() {
        // Affiche le template index.html
        return "index";
    }
}
