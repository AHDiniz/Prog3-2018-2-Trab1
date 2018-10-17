package trab;

import java.io.*;
import java.util.*;

public class Reader
{
    /**
     * Static method that reads a file, given it's location, with a given encoding. The file must have the format of the divulga.csv reports given by the brazilian Top Electoral Court (TSE).
     * 
     * @param filePath the location of the file that will be read
     * @param encoding the encoding used to write the file
     */
    public static Election readFile(String filePath, String encoding)
    {
        Map<String, Coalition> coalitions = new HashMap<String, Coalition>(); // Map with all coalitions
        boolean elected; // Mark elected candidates
        String aux, name, coalition, party, percent; // Auxiliar reading variables
        int votes = 0; // Vote counter
        int vacancies = 0; // Number of elected candidates
        Coalition temp; // Auxiliar variable

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
                    elected = true; // Marking the candidate as elected
                }
                else // Else, marking candidate as non elected
                    elected = false;

                line.next(); // Jumping the candidate's number
                name = line.next(); // Getting the candidate's name

                Scanner parties = new Scanner(line.next()); // Setting an auxiliar scanner for the parties and coalitions
                parties.useDelimiter("-"); // Setting delimiter as '-'
                party = (parties.next()).trim(); // Getting the candidate's party
                if (parties.hasNext()) // If it is in a coalition
                {
                    coalition = (parties.next()).trim(); // Getting the coalition
                }
                else // Else, it will be seted as the party's name. It needs to be in a coalition to integrate the coalitions map
                {
                    coalition = party;
                }
                parties.close(); // Closing the auxiliar scanner

                votes = line.nextInt(); // Getting the candidate's votes
                percent = line.next(); // Getting the candidate's percent of votes

                line.close(); // Closing the line scanner

                temp = coalitions.get(coalition); // Serching the candidate's coalition
                if (temp == null) // If the coalition don't exists...
                {
                    temp = new Coalition(); // Creating a new coalition
                    temp.setName(coalition); // Set the coalition's name
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