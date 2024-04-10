package fr.hetic;

class FileReader{
    public static void main(String[] args) {

        // Creation d'un filereader
        try {
            FileReader fileReader = new FileReader(/learning-java/src/fr/hetic/textfile/results.txt);
            BufferedReader reader = new BufferedReader(fileReader);

            //affichage de la ligne
            String line = reader.readline();
            while (line =! null) {
                System.out.println(line);
                //lecture de la prochaine ligne
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        }
    }
