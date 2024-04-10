package fr.hetic;

public class FileWriter {
    public static void main (String[] args) {
        try {
            // Création d'un fileWriter pour écrire dans un fichier
            FileWriter fileWriter = new FileWriter(/learning-java/src/fr/hetic/textfile/results.txt, false);

            // Création d'un bufferedWriter qui utilise le fileWriter
            BufferedWriter writer = new BufferedWriter(fileWriter);


            writer.write("");
            writer.newLine();

            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}