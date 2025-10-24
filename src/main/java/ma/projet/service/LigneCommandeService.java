package ma.projet.service;

import ma.projet.classes.LigneCommande;
import ma.projet.dao.LigneCommandeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneCommandeService {
    private final LigneCommandeRepository ligneCommandeRepository;

    public LigneCommandeService(LigneCommandeRepository ligneCommandeRepository) {
        this.ligneCommandeRepository = ligneCommandeRepository;
    }

    // ➕ Ajouter une ligne de commande
    public LigneCommande save(LigneCommande ligneCommande) {
        return ligneCommandeRepository.save(ligneCommande);
    }

    // 🔄 Modifier une ligne de commande
    public LigneCommande update(LigneCommande ligneCommande) {
        return ligneCommandeRepository.save(ligneCommande);
    }

    // ❌ Supprimer une ligne de commande
    public void delete(Long id) {
        ligneCommandeRepository.deleteById(id);
    }

    // 🔍 Trouver une ligne par ID
    public LigneCommande findById(Long id) {
        Optional<LigneCommande> ligneCommande = ligneCommandeRepository.findById(id);
        return ligneCommande.orElse(null);
    }

    // 📋 Lister toutes les lignes de commande
    public List<LigneCommande> findAll() {
        return ligneCommandeRepository.findAll();
    }

    // 🧾 Lister les lignes par commande donnée
    public List<LigneCommande> findByCommandeId(Long commandeId) {
        return ligneCommandeRepository.findByCommandeId(commandeId);
    }
}
