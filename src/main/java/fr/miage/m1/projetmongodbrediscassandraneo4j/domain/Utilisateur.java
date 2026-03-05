package fr.miage.m1.projetmongodbrediscassandraneo4j.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "utilisateurs")
public class Utilisateur {

    @Id
    private String id;

    private String nom;

    private String email;

    private List<String> amisIds = new ArrayList<>();

    private List<String> achatsIds = new ArrayList<>();
}