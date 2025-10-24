package ma.projet.service;

import ma.projet.classes.Produit;
import ma.projet.dao.ProduitRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    // ➕ Ajouter un produit
    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    // 🔄 Modifier un produit
    public Produit update(Produit produit) {
        return produitRepository.save(produit);
    }

    // ❌ Supprimer un produit
    public void delete(Long id) {
        produitRepository.deleteById(id);
    }

    // 🔍 Trouver un produit par ID
    public Produit findById(Long id) {
        Optional<Produit> produit = produitRepository.findById(id);
        return produit.orElse(null);
    }

    // 📋 Lister tous les produits
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    // 🔎 Trouver les produits par nom de catégorie
    public List<Produit> getProduitsParCategorie(String nomCategorie) {
        return produitRepository.findByCategorieNom(nomCategorie);
    }

    // 💰 Produits dont le prix est > 100 DH
    public List<Produit> produitsPrixSup100() {
        return produitRepository.findProduitsPrixSup100();
    }

    // 🗓️ Produits commandés entre deux dates
    public List<Produit> produitsCommandesEntreDates(LocalDate dateDebut, LocalDate dateFin) {
        return produitRepository.findProduitsCommandesEntreDates(dateDebut, dateFin);
    }

    // 📦 Produits d'une commande donnée
    public List<Produit> produitsParCommande(Long commandeId) {
        return produitRepository.findProduitsParCommande(commandeId);
    }
}
