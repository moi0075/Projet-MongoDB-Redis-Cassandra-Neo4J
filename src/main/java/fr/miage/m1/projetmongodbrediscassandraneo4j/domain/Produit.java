package fr.miage.m1.projetmongodbrediscassandraneo4j.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "produits")

public class Produit {
    @Id
    private String id;
    private String nom;
    private Double prix;
    private String categorie;
}
