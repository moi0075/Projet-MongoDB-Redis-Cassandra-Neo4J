package fr.miage.m1.projetmongodbrediscassandraneo4j.repository;

import fr.miage.m1.projetmongodbrediscassandraneo4j.domain.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends MongoRepository<Produit, String> {
    List<Produit> findByCategorie(String categorie);
}
