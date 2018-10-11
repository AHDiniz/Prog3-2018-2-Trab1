package trab;

import java.util.Map;

//import java.util.*;
//import java.io.*;

/**
 * Program's entry point:
 * 
 * TODO: CSV file reader
 */
public class Program
{
    public static void main(String[] args)
    {
        Map<String, Coalition> coalitions = Reader.readFile(args[0], args[1]);
        
        coalitions.forEach((s, c) -> System.out.println("Key = " + s + " Parties: " + c));
    }
}