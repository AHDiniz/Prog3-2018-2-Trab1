package trab;

import java.util.*;

/**
 * Program's entry point:
 */
public class Program
{
    public static void main(String[] args)
    {
        Election election = Reader.readFile(args[0], args[1]);
        
        System.out.println(election.numberOfVacancies() + "\n");
        System.out.println(election.electedCandidates() + "\n");
        System.out.println(election.mostVotedCandidates() + "\n");
        System.out.println(election.electedByMajority() + "\n");
        System.out.println(election.electedByProportion() + "\n");
        System.out.println(election.votesByCoalition() + "\n");
        System.out.println(election.votesByParty() + "\n");
        System.out.println("Total de votos nominais: " + election.amountOfVotes());
    }
}