package trab;

import java.io.*;
import java.util.*;

public class Reader
{
    public static Set<Coalition> readFile(String filePath, String encoding)
    {
        Set<Coalition> coalitions = new HashSet<Coalition>();
        int vacancies=0;
        String aux, name, coalition, party;
        int votes=0, percent=0;

        Locale brLocale = Locale.forLanguageTag("pt-Br");

        Scanner data = null;

        try (Scanner file = new Scanner( new BufferedReader( new InputStreamReader(new FileInputStream(filePath), encoding)));)
        {
        	file.useLocale(brLocale);
        	file.nextLine();
        	
            //while(file.hasNextLine())
            //{
                data = new Scanner(file.nextLine());
                data.useDelimiter(";");

                aux = data.next();
                if(aux.startsWith("*"))
                {
                    vacancies++;
                }
                // if(aux.startsWith("#"))
                // {
                //     break;
                // }

                data.next();
                name = data.next();

                Scanner parties = new Scanner(data.next());
                parties.useDelimiter("-");
                party = (parties.next()).trim();
                if(parties.hasNext())
                {
                    coalition = (parties.next()).trim();
                }
                else
                {
                    coalition = party;
                }
                parties.close();

                votes = data.nextInt();
                //percent = data.nextInt(4);

                System.out.println("\nName = "+name+"\nParty = ["+party+"]\nCoalition = ["+coalition+"]\nVotes = "+votes+"\nPercent = "+percent);
                
            //}
            System.out.println("Vagas = "+vacancies);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        

        return coalitions;
    }
}