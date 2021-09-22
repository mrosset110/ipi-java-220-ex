package com.ipiecoles.java.java220;

import java.time.LocalDate;

public class Entreprise {

    //Création des constantes de la classe entreprise

    public static final Double SALAIRE_BASE = 1480.27;
    public static final Integer NB_CONGES_BASE = 25;
    public static final Double INDICE_MANAGER = 1.3;
    public static final Double PRIME_MANAGER_PAR_TECHNICIEN = 250.0;
    public static final Double PRIME_ANCIENNETE = 100d;

    public static Double primeAnnuelleBase() {
        // diviser par 2d ou 2.0 pour éviter la division
        // entre deux entiers qui produit un entier
        return LocalDate.now().getYear() / 2d;

    }


}
