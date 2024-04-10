import java.io.*;
package fr.hetic;

public class Main {
    public static void main(String[] args) {

        if (args.length ==0) {
            System.out.println("Préciser le chemin du dossier");
            return;

        }
        string dossier = args[0];
        File dossierFichiers = new File(textfile);
        File[] fichiers = dossierFichiers.listFiles((dir, name) -> name.endsWith(".op"));

        for (File fichier : fichiers) {
            String fichierResultat = fichier.getAbsolutePath().replace(".op,", ".res");
       try (BufferedReader reader = new BufferedReader(new FileReader(fichier));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fichierResultat))) {

                String ligne;
                while ((ligne = reader.readLine()) != null) {
                    String[] elements = ligne.split(";");
                    if (elements.length != 3) {
                        writer.write("ERROR");
                        writer.newLine();
                        continue;
                    }

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
        }
    }
