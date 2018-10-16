package trab;

import java.util.*;

/**
 * Class that represents a political party
 */
public class Party
{
    private String coalition;
    private String name; // The party's name
    private int votes = 0; // The party's amount of votes
    private Set<Candidate> candidates = new HashSet<Candidate>(); // The candidates that belong to the party

    /**
     * Party's constructor
     * 
     * @param name the party's name
     * @param coalition the name of the party's coalition
     */
    public Party(String name, String coalition)
    {
        this.name = name;
        this.coalition = coalition;
    }

    /**
     * Party's constructor
     * 
     * @param party the party that will be copied
     */
    public Party(Party party)
    {
        this.name = party.name;
        this.votes = party.votes;
        this.coalition = party.coalition;
    }

    /**
     * @return party's coalition
     */
    public String getCoalition()
    {
        return coalition;
    }

    /**
     * @return party's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return party's amount of votes
     */
    public int getVotes()
    {
        return votes;
    }

    /**
     * Method that adds a candidate to the party
     * 
     * @param c the candidate that will be added to the party
     */
    public void addCandidate(Candidate c)
    {
        this.votes += c.getVotes(); // Updating the party's amount of votes
        candidates.add(c);
    }

    /**
     * @return Copy of the candidates set
     */
    public Set<Candidate> getCandidates()
    {
        return new HashSet<Candidate>(candidates);
    }
}
