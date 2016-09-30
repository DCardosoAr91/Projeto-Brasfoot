
package clube;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;


public class Clube {
    
    private String nome;
    private ArrayList<Jogador> elenco;
    private ArrayList<Jogador> titulares;
    private ArrayList<Jogador> reservas;
    private ArrayList<Clube> confrontos;
    private String anoDeFuncacao;
    private boolean visitante;
    private int pontuacao;
    private int numVitorias;
    private int numDerrotas;
    private int numEmpates;
    private int numGols;
    private int saldoGols;
    private int GP;
    private int GC;
    private int codigo;
    private JLabel imagemClube;
    
    public Clube(String nome, ArrayList<Jogador> titulares, ArrayList<Jogador> reservas, String anoDeFundacao){
        this.nome = nome;
        this.titulares = titulares;
        this.reservas = reservas;
        this.anoDeFuncacao = anoDeFundacao;
        pontuacao = 0;
        numVitorias = 0;
        numDerrotas = 0;
        numEmpates = 0;
        elenco = new ArrayList<Jogador>();
        imagemClube = new JLabel();
    }
    
    public boolean atacar(int rodada){
        if(gerarAtaque() > confrontos.get(rodada -1).gerarDefesa()){
            return true;
        }else{
            return false;
        } 
    }
    
    
    public int calcularMediaGerarElenco(){
        int somaAtaque = 0;
        int somaDefesa = 0;
        int media = 0;
        for (int i = 0; i < elenco.size(); i++) {
            somaAtaque = somaAtaque + elenco.get(i).getAtaque();
            somaDefesa = somaDefesa + elenco.get(i).getDefesa();
        }
        somaAtaque = somaAtaque/17;
        somaDefesa = somaDefesa/17;
        media = (somaAtaque + somaDefesa)/2;
        return media;
    }
    
    public boolean defender(int rodada){
        if(gerarDefesa() > confrontos.get(rodada -1).gerarAtaque()){
            return true;
        }else{
            return false;
        }
    }
    
    private int calcularForçaAtaque(){
        int soma = 0, media = 0;
        for (int i = 0; i < titulares.size(); i++) {
            soma = soma + titulares.get(i).getAtaque();
        }
        media = soma/11;
        return media;
    }
    
    private int calcularForçaDefesa(){
        int soma = 0, media = 0;
        for (int i = 0; i < titulares.size(); i++) {
            soma = soma + titulares.get(i).getDefesa();
        }
        media = soma/11;
        return media;
    }
    
    
    private int gerarAtaque(){
        Random random = new Random();
        if(visitante == false){
            return random.nextInt(calcularForçaAtaque()+6);
        }else{
            return random.nextInt(calcularForçaAtaque()+1);
        }
    }
    
    private int gerarDefesa(){
        Random random = new Random();
        return random.nextInt(calcularForçaDefesa()+1);
    }

    public void gerarElenco(){
        for (int i = 0; i < titulares.size(); i++) {
            elenco.add(titulares.get(i));
        }
        for (int i = 0; i < reservas.size(); i++) {
            elenco.add(reservas.get(i));
        }
    }
    
    
    public String getAnoDeFuncacao() {
        return anoDeFuncacao;
    }

    public void setAnoDeFuncacao(String anoDeFuncacao) {
        this.anoDeFuncacao = anoDeFuncacao;
    }
    
    public String getNome() {
        return nome;
    }

    public ArrayList<Jogador> getTitulares() {
        return titulares;
    }

    public void setTitulares(ArrayList<Jogador> titalares) {
        this.titulares = titalares;
    }

    public ArrayList<Jogador> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Jogador> reservas) {
        this.reservas = reservas;
    }

    public ArrayList<Clube> getConfrontos() {
        return confrontos;
    }

    public void setConfrontos(ArrayList<Clube> confrontos) {
        this.confrontos = confrontos;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getNumVitorias() {
        return numVitorias;
    }

    public void setNumVitorias(int numVitorias) {
        this.numVitorias = numVitorias;
    }

    public int getNumDerrotas() {
        return numDerrotas;
    }

    public void setNumDerrotas(int numDerrotas) {
        this.numDerrotas = numDerrotas;
    }

    public int getNumEmpates() {
        return numEmpates;
    }

    public void setNumEmpates(int numEmpates) {
        this.numEmpates = numEmpates;
    }

    public ArrayList<Jogador> getElenco() {
        return elenco;
    }

    public void setElenco(ArrayList<Jogador> elenco) {
        this.elenco = elenco;
    }

    public int getNumGols() {
        return numGols;
    }

    public void setNumGols(int numGols) {
        this.numGols = numGols;
    }

    public int getSaldoGols() {
        return saldoGols;
    }

    public void setSaldoGols(int saldoGols) {
        this.saldoGols = saldoGols;
    }

    public int getGP() {
        return GP;
    }

    public void setGP(int GP) {
        this.GP = GP;
    }
    
    public int getGC() {
        return GC;
    }

    public void setGC(int GC) {
        this.GC = GC;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public JLabel getImagemClube() {
        return imagemClube;
    }

    public boolean isVisitante() {
        return visitante;
    }

    public void setVisitante(boolean visitante) {
        this.visitante = visitante;
    }
    
}
