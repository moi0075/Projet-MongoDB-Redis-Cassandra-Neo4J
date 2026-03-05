package fr.miage.m1.projetmongodbrediscassandraneo4j.controller;

import fr.miage.m1.projetmongodbrediscassandraneo4j.domain.Utilisateur;
import fr.miage.m1.projetmongodbrediscassandraneo4j.service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    // Créer utilisateur
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Utilisateur create(@RequestBody Utilisateur utilisateur) {
        return utilisateurService.create(utilisateur);
    }

    // Récupérer tous les utilisateurs
    @GetMapping
    public List<Utilisateur> findAll() {
        return utilisateurService.findAll();
    }

    // Récupérer un utilisateur par ID
    @GetMapping("/{idUtilisateur}")
    public Utilisateur findById(@PathVariable String idUtilisateur) {
        return utilisateurService.findById(idUtilisateur);
    }

    // Ajouter un ami
    @PatchMapping("/{id}/amis/{amiId}")
    public Utilisateur addAmi(@PathVariable String id, @PathVariable String amiId) {
        return utilisateurService.addAmi(id, amiId);
    }

    // Ajouter un achat (produitId)
    @PatchMapping("/{id}/achats/{produitId}")
    public Utilisateur addAchat(@PathVariable String id, @PathVariable String produitId) {
        return utilisateurService.addAchat(id, produitId);
    }
}