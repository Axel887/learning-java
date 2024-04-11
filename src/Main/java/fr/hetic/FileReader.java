import java.io.*;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Préciser le chemin du dossier");
            return;
        }

        String dossier = args[0];
        File dossierFichiers = new File(dossier);
        File[] fichiers = dossierFichiers.listFiles((dir, name) -> name.endsWith(".op"));

        if (fichiers == null) {
            System.out.println("Aucun fichier .op trouvé dans le dossier spécifié.");
            return;
        }

        for (File fichier : fichiers) {
            String fichierResultat = fichier.getAbsolutePath().replace(".op", ".res");
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

                    double nombre1, nombre2;
                    String operateur;

                    try {
                        nombre1 = Double.parseDouble(elements[0]);
                        nombre2 = Double.parseDouble(elements[1]);
                        operateur = elements[2];
                    } catch (NumberFormatException e) {
                        System.out.println("Les deux premiers arguments doivent être des nombres");
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
                            break;
                        default:
                            writer.write("ERROR");
                            writer.newLine();
                            continue; // Passer à la prochaine ligne
                    }

                    writer.write(String.valueOf(resultat));
                    writer.newLine();
                }

            } catch (IOException e) {
                System.out.println("Erreur lors du traitement du fichier " + fichier.getName() + ": " + e.getMessage());
            }
        }
    }
}
