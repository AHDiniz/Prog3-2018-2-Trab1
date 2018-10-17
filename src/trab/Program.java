package trab;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * Program's entry point:
 */
public class Program
{
    public static void main(String[] args)
    {
        try (PrintStream ps = new PrintStream(System.out, true, args[1]);)
        {
            Election election = Reader.readFile(args[0], args[1]);

            ps.println(election.numberOfVacancies() + "\n");
            ps.println(election.electedCandidates() + "\n");
            ps.println(election.mostVotedCandidates() + "\n");
            ps.println(election.electedByMajority() + "\n");
            ps.println(election.electedByProportion() + "\n");
            ps.println(election.votesByCoalition() + "\n");
            ps.println(election.votesByParty() + "\n");
            ps.println("Total de votos nominais: " + election.amountOfVotes());
        }
        catch (UnsupportedEncodingException e)
        {
            System.err.println("ERROR: The encoding " + args[1] + " is not valid!");
            e.printStackTrace();
        }
    }
}