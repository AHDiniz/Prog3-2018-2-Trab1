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
        
        System.out.println(election.numberOfVacancies()+"\n");
        System.out.println(election.electedCandidates()+"\n");
    }
}