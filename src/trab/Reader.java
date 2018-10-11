package trab;

import java.io.*;
import java.util.*;

public class Reader
{
    public static Map<String,Coalition> readFile(String filePath, String encoding)
    {
        Map<String,Coalition> coalitions = new HashMap<String,Coalition>(); // Map with all coalitions
        int vacancies=0;                                                    // Total number of elected candidates
        String aux, name, coalition, party, percent;                        // Auxiliar variables
        int votes=0;                                                        // ...
        Coalition temp;                                                     // ...

        Locale brLocale = Locale.forLanguageTag("pt-Br"); // Seting locale

        try (Scanner file = new Scanner( new BufferedReader( new InputStreamReader(new FileInputStream(filePath), encoding)));)
        {
        	file.useLocale(brLocale);   // Seting file locale
        	file.nextLine();            // Junping header
        	
            while(file.hasNextLine())   // Reading every line of the entrance
            {
                Scanner line = new Scanner(file.nextLine()); // Seting a new scanner for the actual line
                line.useLocale(brLocale); // Seting the locale in the line
                line.useDelimiter(";"); // Seting line delimiter as ';' 

                aux = line.next(); // Geting the identification number
                if(aux.startsWith("#")) // Break the loop if the section of valid candidates end
                    {
                        break;
                    }
                if(aux.startsWith("*")) // Incrementing the number of vacancies if find a elected candidate
                {
                    vacancies++;
                }

                line.next(); // Junping the candidate's number
                name = line.next(); // Geting the candidate's name

                Scanner parties = new Scanner(line.next()); // Seting a auxiliar scanner for the parties and coligations
                parties.useDelimiter("-"); // Seting delimiter as '-'
                party = (parties.next()).trim(); // Geting the candidate's party
                if(parties.hasNext()) // If it have a coligation
                {
                    coalition = (parties.next()).trim(); // Geting the coligation
                }
                else // Else, seting it as the party
                {
                    coalition = party;
                }
                parties.close(); // Closing the auxiliar scanner

                votes = line.nextInt(); // Geting the candidate's votes
                percent = line.next(); // Geting the candidate's percent of votes

                temp = coalitions.get(coalition); // Serching the candidate's coalition
                if(temp == null) // If there's none
                {
                    temp = new Coalition(); // Creating a new coalition
                    coalitions.put(coalition, temp); // And add it to the Map
                }

                temp.addCandidate(name, party, votes, percent); // Adding candidate to coalition

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