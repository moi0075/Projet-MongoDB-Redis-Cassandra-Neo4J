package fr.miage.m1.projetmongodbrediscassandraneo4j.service;

import fr.miage.m1.projetmongodbrediscassandraneo4j.domain.Produit;
import fr.miage.m1.projetmongodbrediscassandraneo4j.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    /**
     * Enregistre un nouveau produit dans MongoDB.
     */
    public Produit creerProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    /**
     * Récupère la liste de tous les produits.
     */
    public List<Produit> recupererTousLesProduits() {
        return produitRepository.findAll();
    }

    /**
     * Récupère les produits appartenant à une catégorie spécifique.
     */
    public List<Produit> recupererParCategorie(String categorie) {
        return produitRepository.findByCategorie(categorie);
    }
}