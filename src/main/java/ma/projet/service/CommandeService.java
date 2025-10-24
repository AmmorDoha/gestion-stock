package ma.projet.service;

import ma.projet.classes.Commande;
import ma.projet.dao.CommandeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {
    private final CommandeRepository commandeRepository;

    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    // ➕ Ajouter une commande
    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }

    // 🔄 Modifier une commande
    public Commande update(Commande commande) {
        return commandeRepository.save(commande);
    }

    // ❌ Supprimer une commande
    public void delete(Long id) {
        commandeRepository.deleteById(id);
    }

    // 🔍 Trouver une commande par ID
    public Commande findById(Long id) {
        Optional<Commande> commande = commandeRepository.findById(id);
        return commande.orElse(null);
    }

    // 📋 Lister toutes les commandes
    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }

    // 🗓️ Trouver les commandes entre deux dates
    public List<Commande> findCommandesBetweenDates(LocalDate dateDebut, LocalDate dateFin) {
        return commandeRepository.findByDateCommandeBetween(dateDebut, dateFin);
    }
}