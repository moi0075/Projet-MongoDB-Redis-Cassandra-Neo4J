package fr.miage.m1.projetmongodbrediscassandraneo4j.service;

import fr.miage.m1.projetmongodbrediscassandraneo4j.domain.Utilisateur;
import fr.miage.m1.projetmongodbrediscassandraneo4j.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Utilisateur create(Utilisateur utilisateur) {
        if (utilisateur.getAmisIds() == null) utilisateur.setAmisIds(List.of());
        if (utilisateur.getAchatsIds() == null) utilisateur.setAchatsIds(List.of());
        return utilisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur findById(String id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur not found: " + id));
    }

    public Utilisateur addAmi(String id, String amiId) {
        Utilisateur u = findById(id);

        if (u.getAmisIds() == null) {
            u.setAmisIds(new java.util.ArrayList<>());
        }
        if (!u.getAmisIds().contains(amiId)) {
            u.getAmisIds().add(amiId);
        }

        return utilisateurRepository.save(u);
    }

    public Utilisateur addAchat(String id, String produitId) {
        Utilisateur u = findById(id);

        if (u.getAchatsIds() == null) {
            u.setAchatsIds(new java.util.ArrayList<>());
        }
        if (!u.getAchatsIds().contains(produitId)) {
            u.getAchatsIds().add(produitId);
        }

        return utilisateurRepository.save(u);
    }
}