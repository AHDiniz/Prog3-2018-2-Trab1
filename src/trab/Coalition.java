package trab;

import java.util.*;

/**
 * Class that represents a political coalition
 * 
 * ! This class abstract the use of the Candidate class
 * ? Maybe stop using the Candidate as a public class?
 */
public class Coalition
{
    // Coalition's identificator:
    private String name;
    // Coalition's parties set:
    private Set<Party> parties = new HashSet<Party>();
    // Coalition's number of votes:
    private int votes;

    /**
     * Coalition Builder
     * 
     * @param name Coalition's name
     */
    public Coalition(String name)
    {
        this.name = name;
    }

    /**
     * Method that adds a candidate to the coalition
     * 
     * @param name Candidate's name
     * @param party Candidate's party
     * @param votes Candidate's amount of votes
     */
    public void addCandidate(String name, String party, int votes)
    {
        for (Party p : parties) // Checking if the party already exists
        {
            if (p.getName() == party) // If it does...
            {
                // The new candidate will be added to that party
                Candidate c = new Candidate(name, p, votes);
                p.addCandidate(c);
                return;
            }
        }
        // Otherwise, a new party is created:
        Party p = new Party(party, votes);
        parties.add(p); // and it's added to the coalition
    }
    
    /**
     * @return Coalition's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return Coalition's amount of votes
     */
    public int getVotes()
    {
        return votes;
    }

    /**
     * @return Copy of the coalition's parties set
     */
    public HashSet<Party> getParties()
    {
        HashSet<Party> p = new HashSet<Party>();
        for (Party party : parties)
        {
            p.add(new Party(party));
        }
        return p;
    }

    /**
     * @return String coversion of the coalition
     */
    @Override
    public String toString()
    {
        String ret = "Coligação: ";
        
        for (Party party : parties)
        {
            ret += party.getName() + " / ";
        }

        return ret;
    }
}
