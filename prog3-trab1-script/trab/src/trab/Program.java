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
            Election election = Reader.readFile(args[0], args[1]); // Reading and processing the given file

            ps.println(election.numberOfVacancies() + "\n"); // Printing the number of vacant positions
            ps.println(election.electedCandidates() + "\n"); // Printing the elected candidates
            ps.println(election.mostVotedCandidates() + "\n"); // Printing the most voted candidates
            ps.println(election.electedByMajority() + "\n"); // Printing the candidates that would be elected by majority but weren't
            ps.println(election.electedByProportion() + "\n"); // Printing the candidates elected by proportion that would't be elected by majority
            ps.println(election.votesByCoalition() + "\n"); // Printing the amount of votes for every coalition
            ps.println(election.votesByParty() + "\n"); // Printing the amount of votes for every party
            ps.println("Total de votos nominais: " + election.amountOfVotes()); // Printing the total of nominal votes
        }
        catch (UnsupportedEncodingException e)
        {
            System.err.println("ERROR: The encoding " + args[1] + " is not valid!");
            e.printStackTrace();
        }
    }
}