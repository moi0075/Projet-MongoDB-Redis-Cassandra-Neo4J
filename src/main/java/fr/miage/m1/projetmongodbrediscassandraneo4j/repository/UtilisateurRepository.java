package fr.miage.m1.projetmongodbrediscassandraneo4j.repository;

import fr.miage.m1.projetmongodbrediscassandraneo4j.domain.Utilisateur;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UtilisateurRepository extends MongoRepository<Utilisateur, String> {
}