package trab;

import java.util.Comparator;
import java.util.Scanner;

/**
 * Class that represents a political candidate
 */
public class Candidate implements Comparable<Candidate>
{
    /**
     * Creating a candidate comparator class that "belongs" to the Candidate
     * This class will contain the method to compare two given candidates
     */
    public static class CandidateComparator implements Comparator<Object>
    {
        /**
         * Method that compares two candidates
         * 
         * @param a the first candidate in the comparision
         * @param b the second candidate in the comparision
         * 
         * @return the difference between the inputs' positions
         */
        @Override
        public int compare(Object a, Object b)
        {
            int diff = ((Candidate) a).getVotes() - ((Candidate) b).getVotes();
            if (diff != 0) return -diff;
            else return ((Candidate) a).getName().compareTo(((Candidate) b).getName());
        }
    }

    private String name; // Candidate's name
    private Party party; // Candidate's party
    private int votes; // Candidate's amount of votes
    private String percent; // Candidate's percentage of valid votes
    private boolean elected; // boolean that is true if the candidate was elected, else false

    /**
     * Candidate's constructor
     * 
     * @param name Candidate's name
     * @param party Candidate's party
     * @param votes Candidate's amount of votes
     * @param percent Candidate's percentage of valid votes
     * @param elected true if candidate was elected, otherwise false
     */
    public Candidate(String name, Party party, int votes, String percent, boolean elected)
    {
        this.name = name;
        this.party = new Party(party);
        this.votes = votes;
        this.percent = percent;
        this.elected = elected;
    }

    /**
     * Candidate's constructor
     * 
     * @param candidate Original candidate
     */
    public Candidate(Candidate candidate)
    {
        this.name = candidate.name;
        this.party = new Party(candidate.party);
        this.votes = candidate.votes;
    }

    /**
     * @return Candidate's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return Candidate's party
     */
    public Party getParty()
    {
        return new Party(party);
    }

    /**
     * @return Candidate's votes
     */
    public int getVotes()
    {
        return votes;
    }

    /**
     * @return Candidate's percentage of valid votes
     */
    public String getPercent()
    {
        return percent;
    }

    /**
     * @return true if the candidate was elected, otherwise return false
     */
    public boolean getElected()
    {
        return elected;
    }

    /**
     * @return String convertion of the candidate
     */
    @Override
    public String toString()
    {
        String ret = ""; // Return string
        ret += name+" (" + party.getName() + ", " + votes + " votos)"; // Adding name, party and amount of votes to the return

        String temp = party.getCoalition(); // Geting the candidate's coalition name
        Scanner cName = new Scanner(temp); // Seting a scanner to analyze the name
        cName.useDelimiter("/"); // Seting the scanner dalimiter as '/'
        cName.next(); // Jumping the first party in the name
        if(cName.hasNext()) // If there are more than one party the coalition will be added, else it is irrelevant
        {
            ret += " - Coligação: " + temp;
        }
        cName.close(); // Closing auxiliar scanner
        return ret;
    }

    /**
     * Method that compares this instance of candidate with another one
     */
    @Override
    public int compareTo(Candidate c)
    {
        int diff = this.getVotes() - c.getVotes();
        if (diff != 0)
            return -diff;
        else
            return this.getName().compareTo(c.getName());
    }
}
