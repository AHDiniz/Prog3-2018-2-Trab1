package trab;

import java.io.*;
import java.util.*;

public class Reader {

    public static Set<Coalition> ReadFile(String filePath) {

        Set<Coalition> coalitions = new HashSet<Coalition>();

        Locale brLocale = Locale.forLanguageTag("pt-Br");

        Scanner data = null;

        try(Scanner file = new Scanner(new File(filePath));) {

            file.useDelimiter(";");

            while(file.hasNextLine()) {
                data = new Scanner(file.nextLine());
                while(data.hasNext()) {
                    String aux = data.next()
                    System.out.println(aux);
                }
                
            }

        }
        catch(IOException ex) {
            System.out.println("Erro de leitura");
        }
        

        return coalitions;
    }
}