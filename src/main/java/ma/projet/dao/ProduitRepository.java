package ma.projet.dao;

import ma.projet.classes.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    // 🔍 Produits d'une catégorie donnée
    List<Produit> findByCategorieNom(String nomCategorie);

    // 🔍 Produits dont le prix > 100 DH (via requête nommée)
    @Query("SELECT p FROM Produit p WHERE p.prix > 100")
    List<Produit> findProduitsPrixSup100();

    // 🔍 Produits commandés entre deux dates
    @Query("SELECT DISTINCT lc.produit FROM LigneCommande lc WHERE lc.commande.dateCommande BETWEEN :dateDebut AND :dateFin")
    List<Produit> findProduitsCommandesEntreDates(LocalDate dateDebut, LocalDate dateFin);

    // 🔍 Produits d'une commande donnée
    @Query("SELECT lc.produit FROM LigneCommande lc WHERE lc.commande.id = :commandeId")
    List<Produit> findProduitsParCommande(Long commandeId);
}
