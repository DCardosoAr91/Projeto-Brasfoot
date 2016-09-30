
package clube;


public class Jogador {
    
    private String nome;
    private String posicao;
    private int ataque;
    private int defesa;
    private int idade;
    private int gols;
    private int assistencias;
   
    public Jogador(String nome, String posicao, int ataque, int defesa, int idade){
        this.nome = nome;
        this.posicao = posicao;
        this.ataque = ataque;
        this.defesa = defesa;
        this.idade = idade;
        gols = 0;
        assistencias = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getIdade() {
        return idade;
    }

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    public int getAssistencias() {
        return assistencias;
    }

    public void setAssistencias(int assistencias) {
        this.assistencias = assistencias;
    }
    
    
}
