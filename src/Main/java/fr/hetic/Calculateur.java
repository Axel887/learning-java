package fr.hetic;

/*Écrire un programme de type console Calculateur.java prenant 3 paramètres
(numérique, numérique, chaîne de caractères) qui, après avoir validé les entrées affichera
le résultat de l’opération mathématique décrite.
Liste des opérateurs à prendre en compte : + - * */

class Calculateur {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println (" Le calculateur a besoin de 3 paramètres pour fonctionner <nombre> <nombre> <opérateur> ");
            return;
        }
       double nombre1, nombre2;
       String  operateur;

        try {
            nombre1 = Double.parseDouble(args[0]);
            nombre2 = Double.parseDouble(args[1]);
            operateur = args[2];
        } catch (NumberFormatException e) {
            System.out.println ("Les deux premiers arguments doivent êtres des nombres");
            return;
        }

        double resultat = 0;
        switch (operateur) {
            case "+":
             resultat = nombre1 + nombre2;
                    break;
            case "*":
             resultat = nombre1 * nombre2;
                    break;
            case "-":
             resultat = nombre1 - nombre2;
             if (nombre1 > nombre2) { resultat = nombre1 - nombre2; }
                    else { resultat = nombre2 - nombre1; }
                    break;
        }

        System.out.println ("Résultat de l'opération :" + resultat);

    }
}



