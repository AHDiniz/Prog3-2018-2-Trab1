package trab;

import java.util.*;

/**
 * Classe que representa uma coligação de partidos políticos
 */
public class Coligacao
{
    // Conjunto de partidos políticos da coligação:
    private Set<String> partidos = new HashSet<String>();
    // Conjunto de candidatos pertencentes à coligação:
    private Set<Candidato> candidatos = new HashSet<Candidato>();
    // Número de votos da coligação:
    private int votos;

    /**
     * Função que adiciona um candidato e seu partido à coligação
     * @param candidato
     */
    public void addCandidato(Candidato candidato)
    {
        votos += candidato.getVotos(); // Adicionando os votos do candidato à coligação
        candidatos.add(candidato); // Adicionando o candidato ao conjunto de candidatos da coligação
        partidos.add(candidato.getPartido()); // Adicionando o partido do candidato ao conjunto de partidos da coligação
    }

    /**
     * @return Votos da coligação
     */
    public int getVotos()
    {
        return votos;
    }

    /**
     * @return Conjunto de partidos da coligação
     */
    public Set<String> getPartidos()
    {
        return new Set<String>(partidos);
    }
}
