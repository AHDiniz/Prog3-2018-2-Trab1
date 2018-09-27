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
    private Set<String> parties = new HashSet<String>();
    // Coalition's cadidates set:
    private Map<Integer, Candidate> candidates = new HashMap<Integer, Candidate>();
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
    public void addCandidate(Integer id, String name, String party, int votes)
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
    public Set<String> getParties()
    {
        return new Set<String>(parties);
    }

    /**
     * @return Map with the names of the candidates in the coalition's set
     */
    public HashMap<Integer, String> getCandidates()
    {
        HashMap<Integer, String> names = new HashMap<Integer, String>(); // Creating the map of the candidates' ids and names
        Iterator it = candidates.entrySet().iterator(); // This iterator will help with running through the map
        while (it.hasNext()) // While there's a next item in the map
        {
            // Creating an item of the candidates map and putting it in the names map:
            Map.Entry<Integer, Candidate> pair = (Map.Entry<Integer, Candidate>)it.next();
            names.put(pair.getKey(), pair.getValue().getName());
        }
        return names; // Returning the created map
    }
}
