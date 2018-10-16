package trab;

import java.io.*;
import java.util.*;

public class Reader
{
    /**
     * Static method that reads a file given it's location
     * 
     * @param filePath the location of the file that will be read
     * @param encoding the encoding used to write the file
     */
    public static Election readFile(String filePath, String encoding)
    {
        Map<String, Coalition> coalitions = new HashMap<String, Coalition>(); // Map with all coalitions
        boolean elected; // Tells if the candidate was elected
        String aux, name, coalition, party, percent; // Auxiliar variables
        int votes = 0; // Vote counter
        int vacancies = 0;
        Coalition temp; // Auxiliar coalition variable

        Locale brLocale = Locale.forLanguageTag("pt-Br"); // Setting the locale for Brazilian Portuguese

        try (Scanner file = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(filePath), encoding)));)
        {
        	file.useLocale(brLocale); // Setting the file locale to Brazilian Portuguese
        	file.nextLine(); // Skipping the header
        	
            while (file.hasNextLine()) // Reading every line after the header in the file
            {
                Scanner line = new Scanner(file.nextLine()); // Seting a new scanner for each line
                line.useLocale(brLocale); // Setting the locale in the line to Brazilian Portuguese
                line.useDelimiter(";"); // Setting line delimiter as ';' 

                aux = line.next(); // Getting the identification number
                if (aux.startsWith("#")) // Break the loop if the section of valid candidates end
                    break;
                if (aux.startsWith("*")) // Incrementing the number of vacancies if an elected candidate is found
                {
                    vacancies++;
                    elected = true;
                }
                else
                    elected = false;

                line.next(); // Jumping the candidate's number
                name = line.next(); // Getting the candidate's name

                Scanner parties = new Scanner(line.next()); // Setting an auxiliar scanner for the parties and coalitions
                parties.useDelimiter("-"); // Setting delimiter as '-'
                party = (parties.next()).trim(); // Getting the candidate's party
                if (parties.hasNext()) // If it has a coalition
                {
                    coalition = (parties.next()).trim(); // Getting the coalition
                }
                else // Otherwise, it will be saved as the party's name
                {
                    coalition = party;
                }
                parties.close(); // Closing the auxiliar scanner

                votes = line.nextInt(); // Getting the candidate's votes
                percent = line.next(); // Getting the candidate's percent of votes

                line.close();

                temp = coalitions.get(coalition); // Serching the candidate's coalition
                if (temp == null) // If the coalition don't exists...
                {
                    temp = new Coalition(); // Creating a new coalition
                    if (!(coalition.equals(party))) // Set the coalition's name if there are more than one party
                    {
                        temp.setName(coalition);
                    }
                    coalitions.put(coalition, temp); // And add it to the Map
                }

                temp.addCandidate(name, party, votes, percent, elected); // Adding the line's candidate to the coalition
            }
        }
        catch (IOException ex)
        {
            // Printing an error message to tell the user what happened:
            System.err.println("ERROR: the given filepath is invalid or there's a problem with the file itself.\n");
            ex.printStackTrace(); // Printing the exception stack trace
        }

        return new Election(coalitions, vacancies);
    }
}