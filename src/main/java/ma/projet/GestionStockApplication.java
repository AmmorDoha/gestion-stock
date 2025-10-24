package ma.projet;

import ma.projet.classes.*;
import ma.projet.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class GestionStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionStockApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            ProduitService produitService,
            CategorieService categorieService,
            CommandeService commandeService,
            LigneCommandeService ligneCommandeService
    ) {
        return args -> {
            System.out.println("=== Initialisation de la base ===");

            // 🔹 Création des catégories
            Categorie c1 = categorieService.save(new Categorie(null, "Ordinateurs"));
            Categorie c2 = categorieService.save(new Categorie(null, "Accessoires"));

            // 🔹 Création des produits
            Produit p1 = produitService.save(new Produit(null, "ES12", 120.0, 10, c1));
            Produit p2 = produitService.save(new Produit(null, "ZR85", 100.0, 14, c1));
            Produit p3 = produitService.save(new Produit(null, "EE85", 200.0, 5, c2));

            // 🔹 Création des commandes
            Commande cmd1 = commandeService.save(new Commande(null, LocalDate.of(2013, 3, 14)));
            Commande cmd2 = commandeService.save(new Commande(null, LocalDate.of(2014, 1, 5)));

            // 🔹 Lignes de commande
            ligneCommandeService.save(new LigneCommande(null, 7, p1, cmd1));
            ligneCommandeService.save(new LigneCommande(null, 14, p2, cmd1));
            ligneCommandeService.save(new LigneCommande(null, 5, p3, cmd1));

            ligneCommandeService.save(new LigneCommande(null, 2, p1, cmd2));
            ligneCommandeService.save(new LigneCommande(null, 1, p3, cmd2));

            System.out.println("=== Données enregistrées ===");

            // 🔍 Afficher les produits par catégorie
            System.out.println("\nProduits dans la catégorie 'Ordinateurs':");
            produitService.getProduitsParCategorie("Ordinateurs")
                    .forEach(p -> System.out.println(p.getReference() + " - " + p.getPrix() + " DH"));

            // 🔍 Produits dont le prix > 100 DH
            System.out.println("\nProduits dont le prix > 100 DH:");
            produitService.produitsPrixSup100()
                    .forEach(p -> System.out.println(p.getReference() + " - " + p.getPrix() + " DH"));

            // 🔍 Produits commandés entre deux dates
            System.out.println("\nProduits commandés entre 2013-01-01 et 2013-12-31:");
            produitService.produitsCommandesEntreDates(
                    LocalDate.of(2013, 1, 1),
                    LocalDate.of(2013, 12, 31)
            ).forEach(p -> System.out.println(p.getReference()));

            // 🔍 Produits d'une commande donnée
            System.out.println("\nProduits de la commande 1 :");
            produitService.produitsParCommande(cmd1.getId())
                    .forEach(p -> System.out.println(p.getReference()));
        };
    }
}
