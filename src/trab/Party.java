package trab;

import java.util.*;

/**
 * Class that represents a political party
 */
public class Party
{
    private String name; // The party's name
    private int votes; // The party's amount of votes
    private Set<Candidate> candidates = new TreeSet<Candidate>(); // The candidate's that belong to the party

    /**
     * Party's constructor
     * 
     * @param name the party's name
     * @param votes the party's amount of votes
     */
    public Party(String name, int votes)
    {
        this.name = name;
        this.votes = votes;
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
     * Method that increments the amount of votes
     * 
     * @param voteIncrement 
     */
    public void addVotes(int voteIncrement)
    {
        votes += voteIncrement;
    }

    /**
     * Method that adds a candidate to the party
     * 
     * @param c the candidate that will be added to the party
     */
    public void addCandidate(Candidate c)
    {
        candidates.add(c);
    }

    /**
     * @return Copy of the candidates set
     */
    public TreeSet<Candidate> getCandidates()
    {
        return new TreeSet<Candidate>(candidates);
    }
}
