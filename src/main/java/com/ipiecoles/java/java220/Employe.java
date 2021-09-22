package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Employe {

    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;
    private Boolean tempsPartiel;
    private String sexe;

    // Ajout

    //Création du constructeur
    public Employe(){

    }

    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Boolean tempsPartiel, String sexe){
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
        this.tempsPartiel = tempsPartiel;
        this.sexe = sexe;
    }

    public void augmenterSalaire(Double pourcentage){
        //Gérer le cas ou this.salaire est null (NPE)
        //Contrôler la valeur de pourcentage (null, négatif, supérieur à un seuil ?)
        this.salaire = this.salaire * (1 + pourcentage);
    }

    public final Integer getNombreAnneeAnciennete(){

        return LocalDate.now().getYear() - this.dateEmbauche.getYear();
    }

    public Integer getNbConges(){
        return Entreprise.NB_CONGES_BASE;
    }

    //Getter and Setter of attribut

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }
    public Double getPrimeAnnuelle(){
        return Entreprise.primeAnnuelleBase();
    }
    public Boolean getTempsPartiel() { return tempsPartiel; }
    public void setTempsPartiel(Boolean tempsPartiel) { this.tempsPartiel = tempsPartiel; }
    public String getSexe() { return sexe; }
    public void setSexe(String sexe) { this.sexe = sexe; }

    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        if (dateEmbauche == null) {
            throw new Exception("La date d'embauche ne peut pas être nulle");
        }
        if (dateEmbauche.isAfter(LocalDate.now())) {
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }
        //Si le paramètre est une date antérieure ou égale à la date courante
        this.dateEmbauche = dateEmbauche;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employe{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", matricule='").append(matricule).append('\'');
        sb.append(", dateEmbauche='").append(dateEmbauche);
        sb.append(", salaire=").append(salaire);
        sb.append(", tempsPartiel='").append(tempsPartiel);
        sb.append(", sexe='").append(sexe);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Objects.equals(nom, employe.nom) && Objects.equals(prenom, employe.prenom) && Objects.equals(matricule, employe.matricule) && Objects.equals(dateEmbauche, employe.dateEmbauche) && Objects.equals(salaire, employe.salaire) && Objects.equals(tempsPartiel, employe.tempsPartiel) && Objects.equals(sexe, employe.sexe);
    }



    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire, tempsPartiel, sexe);
    }

}
