package trab;

/**
 * Class that represents a political candidate
 */
public class Candidate implements Comparable
{
    private String name; // Candidate's name
    private Party party; // Candidate's party
    private int votes; // Candidate's amount of votes
    private String percent; // Candidate's percentage of valid votes

    /**
     * Candidate's constructor
     * 
     * @param name Candidate's name
     * @param party Candidate's party
     * @param votes Candidate's amount of votes
     * @param percent Candidate's percentage of valid votes
     */
    public Candidate(String name, Party party, int votes, String percent)
    {
        this.name = name;
        this.party = new Party(party);
        this.votes = votes;
        this.percent = percent;
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
     * @return Candidate's percent
     */
    public String getPercent()
    {
        return percent;
    }

    /**
     * @return String convertion of the candidate
     */
    @Override
    public String toString()
    {
        String ret = "";
        ret += name;
        ret += "(" + party.getName() + ", " + votes + " votos)";
        return ret;
    }

    /**
     * Method that compares a candidate to an object
     * 
     * @param o object that will be compared
     * ! The object must be a Candidate too
     * 
     * @return an integer that tells if this object is less then, equal to or bigger then the input
     */
    @Override
    public int compareTo(Object o)
    {
        if (this.votes < ((Candidate)o).getVotes())
            return -1;
        else if (this.votes == ((Candidate)o).getVotes())
        {
            if (this.name.compareTo(((Candidate)o).getName()) == 0)
                return 0;
            else if (this.name.compareTo(((Candidate)o).getName()) == 1)
                return -1;
            else return 1;
        }
        else return 1;
    }
}
