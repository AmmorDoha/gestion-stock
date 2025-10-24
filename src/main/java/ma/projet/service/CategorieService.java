package ma.projet.service;

import ma.projet.classes.Categorie;
import ma.projet.dao.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {
    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    // ➕ Ajouter une catégorie
    public Categorie save(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    // 🔄 Modifier une catégorie
    public Categorie update(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    // ❌ Supprimer une catégorie
    public void delete(Long id) {
        categorieRepository.deleteById(id);
    }

    // 🔍 Trouver une catégorie par ID
    public Categorie findById(Long id) {
        Optional<Categorie> categorie = categorieRepository.findById(id);
        return categorie.orElse(null);
    }

    // 📋 Lister toutes les catégories
    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }
}