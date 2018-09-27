package trab;

import java.util.*;

/**
 * Class that represents a political coalition
 */
public class Coalition
{
    // Coalition's parties set:
    private Set<String> parties = new HashSet<String>();
    // Coalition's cadidates set:
    private Set<Candidate> candidates = new HashSet<Candidate>();
    // Coalition's number of votes:
    private int votes;

    /**
     * Method that adds a candidate to the coalition
     * @param candidate
     */
    public void addCandidate(Candidate candidate)
    {
        votes += candidate.getVotes(); // Adicionando os votos do candidato à coligação
        candidates.add(candidate); // Adicionando o candidato ao conjunto de candidatos da coligação
        parties.add(candidate.getParty()); // Adicionando o partido do candidato ao conjunto de partidos da coligação
    }

    /**
     * @return Coalition votes
     */
    public int getVotes()
    {
        return votes;
    }

    /**
     * @return Coalition's parties set
     */
    public Set<String> getPartidos()
    {
        return new Set<String>(parties);
    }
}
