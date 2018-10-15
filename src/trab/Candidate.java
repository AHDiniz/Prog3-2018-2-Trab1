package trab;

/**
 * Class that represents a political candidate
 */
public class Candidate implements Comparable<Candidate>
{
    private String name; // Candidate's name
    private Party party; // Candidate's party
    private int votes; // Candidate's amount of votes
    private String percent; // Candidate's percentage of valid votes
    private boolean elected; // boolean that is true if the candidate was elected

    /**
     * Candidate's constructor
     * 
     * @param name Candidate's name
     * @param party Candidate's party
     * @param votes Candidate's amount of votes
     * @param percent Candidate's percentage of valid votes
     * @param elected true if candidate was elected, otherwise false 
     */
    public Candidate(String name, Party party, int votes, String percent,boolean elected)
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
        String ret = "";
        ret += name+" (" + party.getName() + ", " + votes + " votos)";

        String temp = party.getCoalition();
        if(temp != null)
        {
            ret += " - Coligação: "+temp;
        }
        return ret;
    }

    /**
     * Method that compares two candidates
     * 
     * @param c candidate that will be compared
     * ! The object must be a Candidate too
     * 
     * @return an integer that tells if this candidate is less then, equal to or bigger then the input
     */
    @Override
    public int compareTo(Candidate c)
    {
        if (this.votes < c.getVotes())
            return -1;
        else if (this.votes == c.getVotes())
        {
            if (this.name.compareTo(c.getName()) == 0)
                return 0;
            else if (this.name.compareTo(c.getName()) > 0)
                return -1;
            else return 1;
        }
        else return 1;
    }
}
