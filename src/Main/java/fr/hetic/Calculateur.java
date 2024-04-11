package fr.hetic;

public class Calculateur {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Le calculateur a besoin de 3 paramètres pour fonctionner <nombre> <nombre> <opérateur>");
            return;
        }

        double nombre1, nombre2;
        String operateur;

        try {
            nombre1 = Double.parseDouble(args[0]);
            nombre2 = Double.parseDouble(args[1]);
            operateur = args[2];
        } catch (NumberFormatException e) {
            System.out.println("Les deux premiers arguments doivent être des nombres");
            return;
        }

        Operation operation = OperationFactory.createOperation(operateur);
        if (operation == null) {
            System.out.println("Opérateur non supporté");
            return;
        }

        double resultat = operation.calculer(nombre1, nombre2);
        System.out.println("Résultat de l'opération : " + resultat);
    }
}




