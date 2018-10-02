package trab;

import java.util.*;

/**
 * Class that represents a political party
 */
public class Party
{
    private String name; // The party's name
    private int votes; // The party's amount of votes
    private Set<Candidate> candidates = new HashSet<Candidate>(); // The candidate's that belong to the party

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
     * Function that adds a candidate to the party
     * 
     * @param c the candidate that will be added to the party
     */
    public void addCandidate(Candidate c)
    {
        candidates.add(c);
    }
}
