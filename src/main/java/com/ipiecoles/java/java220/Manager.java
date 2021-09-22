package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.HashSet;

public class Manager extends Employe {



    private HashSet<Technicien> equipe = new HashSet<>();

    public void ajoutTechnicienEquipe(Technicien technicien){
        //Ajouter dans l'équipe
        equipe.add(technicien);
    }

    public void ajoutTechnicienEquipe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade){
        this.ajoutTechnicienEquipe(new Technicien(nom, prenom, matricule, dateEmbauche, salaire, grade));
    }

    @Override
    public void augmenterSalaire(Double pourcentage) {
        augmenterSalaireEquipe(pourcentage);
        super.augmenterSalaire(pourcentage);
    }

    private void augmenterSalaireEquipe(Double pourcentage){
        for (Technicien technicien : equipe) {
            technicien.augmenterSalaire(pourcentage);
        }
    }

    @Override
    public Double getPrimeAnnuelle() {
        return super.getPrimeAnnuelle()
                + Entreprise.PRIME_MANAGER_PAR_TECHNICIEN * equipe.size();
    }

    @Override
    public void setSalaire(Double salaire) {
        super.setSalaire(salaire * Entreprise.INDICE_MANAGER + (salaire * equipe.size() / 10));
    }

    public HashSet<Technicien> getEquipe() {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }

}

