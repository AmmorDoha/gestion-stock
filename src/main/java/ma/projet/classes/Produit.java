package ma.projet.classes;

import jakarta.persistence.*;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private double prix;
    private int quantite;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    public Produit() {}

    public Produit(Long id, String reference, double prix, int quantite, Categorie categorie) {
        this.id = id;
        this.reference = reference;
        this.prix = prix;
        this.quantite = quantite;
        this.categorie = categorie;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
