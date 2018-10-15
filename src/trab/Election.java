package trab;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Class reponsible to make the calculations of the elections and print on the screen
 */
public class Election
{
    private Map<String, Coalition> coalitions;
    private List<Candidate> mostVotedCandidates = new ArrayList<Candidate>();
    private int vacancies;

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

        for (Coalition coalition : this.coalitions.values()) {
            for (Party party : coalition.getParties()) {
                for (Candidate c : party.getCandidates()) {
                    mostVotedCandidates.add(c);
                }
            }
        }
        Collections.sort(mostVotedCandidates, Collections.reverseOrder());
    }

    /**
     * Method that tells the number of elected candidates
     * 
     * @return a String with the number of elected candidates
     */
    public String numberOfVacancies()
    {
        return "Número de vagas: "+vacancies;
    }

    /**
     * Method that tells who was elected
     * 
     * @return a String with data about the elected candidates
     */
    public String electedCandidates()
    {
        String elected = "Vereadores eleitos:\n";
        int i=1;

        System.out.println("Vacancies = "+vacancies);

        for (Candidate c : mostVotedCandidates) {
            if(c.getElected())
            {
                elected += i+" - "+c+"\n";
                i++;
                if(i > vacancies)
                {
                    break;
                }
            }
        }
        return elected;
    }

    /**
     * Method that tells the most voted candidates
     * 
     * @return a String with data about the most voted candidates
     */
    public String mostVoted()
    {
        return null;
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
    public int amountVotes()
    {
        int votes = 0;

        for (Coalition coalition : coalitions.values())
        {
            votes += coalition.getVotes();
        }

        return votes;
    }
}
