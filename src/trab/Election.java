package trab;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Class reponsible to make the calculations of the elections and print on the screen
 */
public class Election
{
    private Map<String, Coalition> coalitions; // The map relating the coalitions name with the coalition
    private List<Candidate> mostVoted = new ArrayList<Candidate>(); // This array will contain the most voted candidates
    private List<Candidate> elected = new ArrayList<Candidate>(); // This list has the elected candidates
    private int vacancies; // The total amount of vacancies in the election
    private int totalVotes; // The total amount of votes in the election

    /**
     * Election object's constructor method:
     * 
     * @param coalitions the map that contains the coalitions in the election
     * 
     * @return a new instance of Election
     */
    public Election(Map<String, Coalition> coalitions, int vacancies)
    {
        this.coalitions = coalitions;
        this.vacancies = vacancies;
        // Getting the total amount of votes in the election:
        for (Coalition coalition : coalitions.values())
        {
            totalVotes += coalition.getVotes();    
        }
    }

    /**
     * Method that tells the number of elected candidates
     * 
     * @return a String with the number of elected candidates
     */
    public String numberOfVacancies()
    {
        return "Número de vagas: " + vacancies;
    }

    /**
     * Method that tells who was elected
     * 
     * @return a String with data about the elected candidates
     */
    public String electedCandidates()
    {
        String elected = "Vereadores eleitos:\n"; // Initializing the return string

        // Getting the elected candidates of each party and putting their info in the return string:
        for (Coalition coalition : coalitions.values())
        {
            for (Party party : coalition.getParties())
            {
                float proportion = (float)party.getVotes() / (float)totalVotes;
            }
        }

        return elected;
    }

    /**
     * Method that tells the most voted candidates
     * 
     * @return a String with data about the most voted candidates
     */
    public String mostVotedCandidates()
    {
        // Looking for every candidate in the election:
        for (Coalition coalition : coalitions.values())
        {
            for (Party party : coalition.getParties())
            {
                for (Candidate candidate : party.getCandidates())
                {
                    this.mostVoted.add(candidate);
                }
            }
        }

        // Ordering the candidate list:
        Collections.sort(this.mostVoted, new Candidate.CandidateComparator());

        // Getting info about the most voted cadidates and putting it in a String:
        String ret = "Candidatos mais votados (em ordem decrescente de votação e respeitando número de vagas):\n";
        for (int i = 0; i < vacancies; i++)
        {
            Candidate c = this.mostVoted.get(i); // Getting the candidate
            int p = i + 1;
            ret += p + " - " + c + "\n";
        }
        
        // Removing the candidates that were not the most voted:
        while (this.mostVoted.size() > vacancies)
            this.mostVoted.remove(vacancies);

        return ret;
    }

    /**
     * Method that tells who would be elected by majority but weren't
     * 
     * @return the String with data about the candidates in interest
     */
    public String electedByMajority()
    {
        return null;
    }

    /**
     * Method that tells which candidates were elected because of the proportiona system
     * 
     * @return the String with data about the candidates in interest
     */
    public String electedByProportion()
    {
        return null;
    }

    /**
     * Method that tells the amount of votes and elected candidates in each coalition
     * 
     * @return the String with data about the coalitions
     */
    public String votesByCoalition()
    {
        return null;
    }

    /**
     * Method that tells the amount of votes that each party had
     * 
     * @return the String that tells the amount of votes for each party in every coalition
     */
    public String votesByParty()
    {
        return null;
    }

    /**
     * Method that returns the amount of votes in the election
     * 
     * @return the total quantity of votes
     */
    public int amountOfVotes()
    {
        int votes = 0;

        for (Coalition coalition : coalitions.values())
        {
            votes += coalition.getVotes();
        }

        return votes;
    }
}
