package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Main {

    public static void main(String [] args) {
        Employe employe = new Employe();
//Setter
        employe.setNom("Doe");
        employe.setPrenom("John");
        try {
            employe.setDateEmbauche(new LocalDate(2020, 12, 5));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Employe employe2 = new Employe("Doe", "Jane", "M12345", null, 2000.0,);
//Getter
        System.out.println(employe2.getNom());
        System.out.println(employe2.getPrenom());
        System.out.println(employe2.getMatricule());

        //System.out.println(employe2.getDateEmbauche().getYear());
        System.out.println(employe2.getSalaire());
        System.out.println(employe2.getNombreAnneeAnciennete());


    }
}
