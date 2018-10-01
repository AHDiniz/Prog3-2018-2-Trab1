package trab;

/**
 * Class that represents a political candidate
 */
public class Candidate
{
    private String name; // Candidate's name
    private String party; // Candidate's party
    private int votes; // Candidate's amount of votes

    /**
     * Candidate's constructor
     * 
     * @param name Candidate's name
     * @param party Candidate's party
     * @param votes Candidate's amount of votes
     */
    public Candidate(String name, String party, int votes)
    {
        this.name = name;
        this.party = party;
        this.votes = votes;
    }

    /**
     * Candidate's constructor
     * 
     * @param candidate Original candidate
     */
    public Candidate(Candidate candidate)
    {
        this.name = candidate.name;
        this.party = candidate.party;
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
    public String getParty()
    {
        return party;
    }

    /**
     * @return Candidate's votes
     */
    public int getVotes()
    {
        return votes;
    }

    /**
     * @return String convertion of the candidate
     */
    @Override
    public String toString()
    {
        String ret = "";
        ret += name;
        return ret;
    }
}
