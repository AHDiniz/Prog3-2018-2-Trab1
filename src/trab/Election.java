package trab;

import java.util.*;

/**
 * Class reponsible to make the calculations of the elections nd print on the screen
 */
public class Election
{
    private Map<String, Coalition> coalitions = new Map<String, Coalition>();

    /**
     * Election object's constructor method:
     * 
     * @param coalitions the map that contains the coalitions in the election
     * 
     * @return a new instance of Election
     */
    public Election(Map<String, Coalition> coalitions)
    {
        this.coalitions = coalitions;
    }

    /**
     * Method that tells who was elected
     * 
     * @return a String with data about the elected candidates
     */
    public String electedCandidates()
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
