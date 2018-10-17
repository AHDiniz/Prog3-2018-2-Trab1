package trab;

import java.util.*;


/**
 * Class reponsible to make the calculations of the elections and print on the screen
 */
public class Election
{
    private Map<String, Coalition> coalitions;
    private List<Candidate> mostVoted = new ArrayList<Candidate>();
    private int vacancies;

    /**
     * Election object's constructor method:
     * 
     * @param coalitions the map that contains the coalitions in the election
     * 
     * @return a new instance of Election
     */
    public Election(Map<String, Coalition> coalitions, int vacancies)
    {
        this.coalitions = coalitions;
        this.vacancies = vacancies;

        for (Coalition coalition : this.coalitions.values())
        {
            //System.out.println("\nCoalition: "+coalition);
            for (Party party : coalition.getParties())
            {
                //System.out.println("Party: "+party.getName());
                for (Candidate c : party.getCandidates())
                {
                    //System.out.println("Name: "+c.getName());
                    mostVoted.add(c);
                }
            }
        }
        Collections.sort(mostVoted, new Candidate.CandidateComparator());
    }

    /**
     * Method that tells the number of elected candidates
     * 
     * @return a String with the number of elected candidates
     */
    public String numberOfVacancies()
    {
        return "Número de vagas: " + vacancies;
    }

    /**
     * Method that tells who was elected
     * 
     * @return a String with data about the elected candidates
     */
    public String electedCandidates()
    {
        String ret = "Vereadores eleitos:\n";
        
        for (int i = 0; i < vacancies; i++)
        {
            Candidate c = mostVoted.get(i);
            int p = i + 1;
            ret += p + " - " + c + "\n";
        }

        return ret;
    }

    /**
     * Method that tells the most voted candidates
     * 
     * @return a String with data about the most voted candidates
     */
    public String mostVotedCandidates()
    {
        String ret = "Candidatos mais votados (em ordem decrescente de votação e respeitando número de vagas):\n";
        int i = 1;

        for (Candidate c : mostVoted)
        {
            ret += i + " - " + c + "\n";
            i++;
            if (i > vacancies)
                break;
        }
        return ret;
    }

    /**
     * Method that tells who would be elected by majority but weren't
     * 
     * @return the String with data about the candidates in interest
     */
    public String electedByMajority()
    {
        String ret = "Teriam sido eleitos se a votação fosse majoritária, e não foram eleitos:\n";
        ret += "(com sua posição no ranking de mais votados)\n";

        for (int i = 0; i < vacancies; i++)
        {
            Candidate c = mostVoted.get(i);
            if (!c.getElected())
            {
                int p = i + 1;
                ret += p + " - " + c + "\n";
            }
        }
        
        return ret;
    }

    /**
     * Method that tells which candidates were elected because of the proportiona system
     * 
     * @return the String with data about the candidates in interest
     */
    public String electedByProportion()
    {
        String ret = "Eleitos, que se beneficiaram do sistema proporcional:\n";
        ret += "(com sua posição no ranking de mais votados)\n";

        for (int i = vacancies; i < mostVoted.size(); i++)
        {
            Candidate c = mostVoted.get(i);
            if (c.getElected())
            {
                int p = i + 1;
                ret += p + " - " + c + "\n";
            }
        }

        return ret;
    }

    /**
     * Method that tells the amount of votes and elected candidates in each coalition
     * 
     * @return the String with data about the coalitions
     */
    public String votesByCoalition()
    {
        String ret = "Votação (nominal) das coligações e número de candidatos eleitos:\n";

        ArrayList<Coalition> cList = new ArrayList<Coalition>(coalitions.values());

        for (int i = 0; i < cList.size(); i++)
        {
            int p = i + 1;
            ret += p + " - Coligação: ";
            
            Coalition c = cList.get(i);
            ret += c.getName() + ", " + c.getVotes() + " votos, ";
            
            int e = 0; // Elected candidates counter
            for (Party party : c.getParties())
                for (Candidate candidate : party.getCandidates())
                    if (candidate.getElected()) e++; 
            ret += (e >= 2) ? (e + " candidatos eleitos\n") : (e + " candidato eleito\n");
        }

        return ret;
    }

    /**
     * Method that tells the amount of votes that each party had
     * 
     * @return the String that tells the amount of votes for each party in every coalition
     */
    public String votesByParty()
    {
        String ret = "Votação (nominal) dos partidos e número de candidatos eleitos:\n";
        
        int amountOfParties = 1;
        for (Coalition coalition : coalitions.values())
        {
            for (Party party : coalition.getParties())
            {
                ret += amountOfParties + " " + party.getName() + ", " + party.getVotes() + " votos, ";
                int e = 0;
                for (Candidate candidate : party.getCandidates())
                    if (candidate.getElected()) e++;
                ret += (e >= 2) ? (e + " candidatos eleitos\n") : (e + " candidato eleito\n");
            }
        }

        return ret;
    }

    /**
     * Method that returns the amount of votes in the election
     * 
     * @return the total quantity of votes
     */
    public int amountOfVotes()
    {
        int votes = 0;

        for (Coalition coalition : coalitions.values())
        {
            votes += coalition.getVotes();
        }

        return votes;
    }
}
