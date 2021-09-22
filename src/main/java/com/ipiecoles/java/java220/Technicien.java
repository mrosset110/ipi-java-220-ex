package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Technicien extends Employe{

    //Attribut de la classe technicien
    private Integer grade;


    // Création du Constructeur par defaut
    public Technicien() {

    }

    //Création du constructeur technicien qui hérite des attributs d'employé

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.grade = grade;
    }

    //Getter et Setter de l'attribut grade
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;

    }
    //Redéfinition du setter de l'attribut salaire
    @Override
    public void setSalaire(Double salaire) {
        super.setSalaire(salaire * (1 + grade / 10d));
    }

    //Redéfinition du getter de l'attribut nombre de congés
    @Override
    public Integer getNbConges() {
        return super.getNbConges() + this.getNombreAnneeAnciennete();
    }

    //Redéfinition de la méthode prime annuelle de base
    @Override
    public Double getPrimeAnnuelle() {
        return super.getPrimeAnnuelle() * (1 + grade / 10d)
                + Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Technicien that = (Technicien) o;
        return Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grade);
    }
}

