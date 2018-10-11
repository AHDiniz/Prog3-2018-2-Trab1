package trab;

import java.io.*;
import java.util.*;

public class Reader
{
    public static Map<String,Coalition> readFile(String filePath, String encoding)
    {
        Map<String,Coalition> coalitions = new HashMap<String,Coalition>();
        int vacancies=0;
        String aux, name, coalition, party, percent;
        int votes=0;
        Coalition temp;

        Locale brLocale = Locale.forLanguageTag("pt-Br");

        Scanner data = null;

        try (Scanner file = new Scanner( new BufferedReader( new InputStreamReader(new FileInputStream(filePath), encoding)));)
        {
        	file.useLocale(brLocale);
        	file.nextLine();
        	
            while(file.hasNextLine())
            {
                data = new Scanner(file.nextLine());
                data.useLocale(brLocale);
                data.useDelimiter(";");

                aux = data.next();
                if(aux.startsWith("#"))
                    {
                        break;
                    }
                if(aux.startsWith("*"))
                {
                    vacancies++;
                }

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
                percent = data.next();

                temp = coalitions.get(coalition);
                if(temp == null)
                {
                    temp = new Coalition();
                    coalitions.put(coalition, temp);
                }

                temp.addCandidate(name, party, votes, percent);

                //System.out.println("\nName = "+name+"\nParty = ["+party+"]\nCoalition = ["+coalition+"]\nVotes = "+votes+"\nPercent = "+percent);
                
            }
            //System.out.println("Vagas = "+vacancies);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        

        return coalitions;
    }
}