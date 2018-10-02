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
    // Coalition's parties set:
    private Set<Party> parties = new HashSet<Party>();
    // Coalition's cadidates set:
    private Set<Candidate> candidates = new HashSet<Candidate>();
    // Coalition's number of votes:
    private int votes;

    /**
     * Method that adds a candidate to the coalition
     * 
     * @param id Candidate's id
     * @param name Candidate's name
     * @param party Candidate's party
     * @param votes Candidate's amount of votes
     */
    public void addCandidate(Integer id, String name, Party party, int votes)
    {
        Candidate candidate = new Candidate(name, party, votes);
        candidates.put(id, candidate);
        this.votes += votes;
        parties.add(party);
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
     * @return Copy of the candidates set
     */
    public HashSet<Candidate> getCandidates()
    {
        HashSet<Candidate> c = new HashSet<Candidate>();
        for (Candidate candidate : candidates)
        {
            c.add(new Candidate(candidate));    
        }
        return c; // Returning the created set
    }

    /**
     * @return String coversion of the coalition
     */
    @Override
    public String toString()
    {
        String ret = "Coligação: ";
        
        return ret;
    }
}
