package trab;

/**
 * Classe que representa um candidato à vaga de vereador
 */
public class Candidato
{
    private String nome; // Nome do candidato
    private String partido; // Nome do partido
    private int votos; // Quantidade de votos do candidato

    /**
     * Método construtor do candidato
     * @param nome Nome do candidato
     * @param partido Partido do candidato
     * @param votos Quantidade de votos do candidato
     */
    public Candidato(String nome, String partido, int votos)
    {
        this.nome = nome;
        this.partido = partido;
        this.votos = votos;
    }

    /**
     * @return Nome do candidato
     */
    public String getNome()
    {
        return nome;
    }

    /**
     * @return Partido do candidato
     */
    public String getPartido()
    {
        return partido;
    }

    /**
     * @return Votos do candidato
     */
    public int getVotos()
    {
        return votos;
    }
}
