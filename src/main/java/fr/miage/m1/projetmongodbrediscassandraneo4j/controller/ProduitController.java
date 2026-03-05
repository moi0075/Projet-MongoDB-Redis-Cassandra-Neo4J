package fr.miage.m1.projetmongodbrediscassandraneo4j.controller;

import fr.miage.m1.projetmongodbrediscassandraneo4j.domain.Produit;
import fr.miage.m1.projetmongodbrediscassandraneo4j.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    /**
     * POST /produits : Crée un nouveau produit
     * Le corps de la requête doit être en JSON
     */
    @PostMapping
    public Produit creerProduit(@RequestBody Produit produit) {
        return produitService.creerProduit(produit);
    }

    /**
     * GET /produits : Récupère la liste de tous les produits
     */
    @GetMapping
    public List<Produit> getTousLesProduits() {
        return produitService.recupererTousLesProduits();
    }

    /**
     * GET /produits/categorie/{categorie} : Récupère les produits d'une catégorie
     */
    @GetMapping("/categorie/{categorie}")
    public List<Produit> getParCategorie(@PathVariable String categorie) {
        return produitService.recupererParCategorie(categorie);
    }
}