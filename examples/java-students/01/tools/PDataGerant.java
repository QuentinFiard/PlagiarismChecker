import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.String;

public class PDataGerant {

    public static void main(String[] arguments) {
	FileReader mydatafile = null;

	File file = new File("./data/gerant.sql");
	
	try{
	    FileWriter fw1 = new FileWriter(file, false);

	    BufferedReader buff = null;

	    String[][] datatab = new String[2500][10];
	    int i = 0;

	    try {
		mydatafile = new FileReader("./data/data.csv");
		buff = new BufferedReader(mydatafile);
		String delimiter = "\\|";
		String str_data = "";

		String nom,prenom,login,motdepasse;
	    
		while (true) {

		    // Lit une ligne de data.csv
		    String line = buff.readLine();
		    // Vérifie la fin de fichier
		    if (line == null)
			break;

		    datatab[i]=line.split(delimiter);

		    if((Integer.parseInt(datatab[i][0]))==60){
			prenom=datatab[i][1];
			nom=datatab[i][2];
			login=datatab[i][3];
			motdepasse=datatab[i][4];
			/** generer requete d'insertion **/
			str_data =
			    "INSERT INTO intervenant VALUES('"
			    +login
			    +"','"+motdepasse
			    +"','"+nom
			    +"',NULL,NULL,NULL,NULL,NULL);\nINSERT INTO personne VALUES('"
			    +login
			    +"','"+prenom+"');\nINSERT INTO gerant VALUES('"+login+"');\n";
			// System.out.print(str_data);
			fw1.write(str_data);
			fw1.flush();
			i++;
		    }
		}

		// Fin du while
	    } catch (IOException exception) {
		exception.printStackTrace();
	    } finally {
		try {
		    buff.close();
		    mydatafile.close();
		} catch(IOException exception1) {
		    exception1.printStackTrace();
		}
	    }
	} catch (IOException exception0) {
	    exception0.printStackTrace();
	}
    }
}