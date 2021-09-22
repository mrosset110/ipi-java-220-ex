package com.exemple;

public class Client {
    //Attribut Nom
    String nom;

    //Prénom
    String prenom;

    //Numéro
    Integer numero = 1;

    //Calcul réduction
    Integer calculReduction(){
        if(this.numero > 200000){
            return 10;
        }
        return 0;
    }
}
