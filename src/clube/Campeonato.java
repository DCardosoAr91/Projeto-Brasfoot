
package clube;

import java.util.ArrayList;
import som.PlaySound;


public class Campeonato {
    
    private ArrayList<Clube> listaDeClubes;
    private ArrayList<Clube> classificacao;
    private ArrayList<Clube> tabelaDeJogos;
    private int rodada;
    private ArrayList<Jogador> artilharia;
    private ArrayList<Jogador> rankingAssistencias;
    private ArrayList<Rodada> rodadas;
    private PlaySound musicaDeFundo;
    
    public Campeonato(){
        rodada = 1;
        listaDeClubes = new ArrayList<Clube>();
    }
    
    public void atualizarTabela(){
        classificacao = new ArrayList<>();
        Clube maior;
        ArrayList<Clube> aux = new ArrayList<>();
        for (int i = 0; i < listaDeClubes.size(); i++) {
            int pontos = 0;
            pontos = (listaDeClubes.get(i).getNumVitorias() * 3) + listaDeClubes.get(i).getNumEmpates();
            listaDeClubes.get(i).setPontuacao(pontos);
            aux.add(listaDeClubes.get(i));
        }
        
        for (int i = 0; i < 4; i++) {
            maior = aux.get(0);
            for (int j = 0; j < aux.size(); j++) {
                if(maior.getPontuacao() < aux.get(j).getPontuacao()){
                    maior = aux.get(j);
                }else if(maior.getPontuacao() == aux.get(j).getPontuacao()){
                    if(aux.get(j).getSaldoGols() > maior.getSaldoGols()){
                        maior = aux.get(j);
                    }else if(aux.get(j).getSaldoGols() == maior.getSaldoGols()){
                        if(aux.get(j).getGP() > maior.getGP()){
                            maior = aux.get(j);
                        }
                    }
                }
            }
            aux.remove(maior);
            classificacao.add(maior);
        }
    }
    
    
    public void simularPartidas(Clube escolhido, Clube adversario){
        for (int i = 0; i < getRodadas().get(rodada -1).getClubes().size(); i++) {
            if(getRodadas().get(rodada -1).getClubes().get(i).getNome().equals(escolhido.getNome())
                    || getRodadas().get(rodada -1).getClubes().get(i).getNome().equals(adversario.getNome())){
                getRodadas().get(rodada -1).getClubes().remove(i);
               i--;
            }
        }
        simularDisputa(getRodadas().get(rodada -1).getClubes().get(0), getRodadas().get(rodada -1).getClubes().get(1));
        rodada++;
    }
    
    private void simularDisputa(Clube x, Clube y){
        int placar1 = 0, placar2 = 0;
        for (int i = 0; i < 5; i++) {
            if(x.atacar(rodada)){
                placar1 = placar1 +1;
            }
            if(y.atacar(rodada)){
                placar2 = placar2 +1;
            }
        }
        if(placar1 == placar2){
            x.setNumEmpates(x.getNumEmpates() + 1);
            y.setNumEmpates(y.getNumEmpates() + 1);
        }else if(placar1 > placar2){
            x.setNumVitorias(x.getNumVitorias() + 1);
            y.setNumDerrotas(y.getNumDerrotas() + 1);
        }else{
            x.setNumDerrotas(x.getNumDerrotas() + 1);
            y.setNumVitorias(y.getNumVitorias() + 1);
        }
        x.setNumGols(placar1);
        x.setGP(x.getGP() + placar1);
        x.setGC(x.getGC() + placar2);
        x.setSaldoGols(x.getGP() - x.getGC());
        y.setNumGols(placar2);
        y.setGP(y.getGP() + placar2);
        y.setGC(y.getGC() + placar1);
        y.setSaldoGols(y.getGP() - y.getGC());
    }
    
    public void definirTabelaDeJogos(){
        ArrayList<Clube> adversarios = new ArrayList<Clube>();
        adversarios.add(listaDeClubes.get(1));
        adversarios.add(listaDeClubes.get(2));
        adversarios.add(listaDeClubes.get(3));
        adversarios.add(listaDeClubes.get(1));
        adversarios.add(listaDeClubes.get(2));
        adversarios.add(listaDeClubes.get(3));
        listaDeClubes.get(0).setConfrontos(adversarios);
        
        adversarios = new ArrayList<Clube>();
        adversarios.add(listaDeClubes.get(0 ));
        adversarios.add(listaDeClubes.get(3));
        adversarios.add(listaDeClubes.get(2));
        adversarios.add(listaDeClubes.get(0 ));
        adversarios.add(listaDeClubes.get(3));
        adversarios.add(listaDeClubes.get(2));
        listaDeClubes.get(1).setConfrontos(adversarios);
        
        adversarios = new ArrayList<Clube>();
        adversarios.add(listaDeClubes.get(3 ));
        adversarios.add(listaDeClubes.get(0));
        adversarios.add(listaDeClubes.get(1));
        adversarios.add(listaDeClubes.get(3 ));
        adversarios.add(listaDeClubes.get(0));
        adversarios.add(listaDeClubes.get(1));
        listaDeClubes.get(2).setConfrontos(adversarios);
        
        adversarios = new ArrayList<Clube>();
        adversarios.add(listaDeClubes.get(2));
        adversarios.add(listaDeClubes.get(1));
        adversarios.add(listaDeClubes.get(0));
        adversarios.add(listaDeClubes.get(2));
        adversarios.add(listaDeClubes.get(1));
        adversarios.add(listaDeClubes.get(0));
        listaDeClubes.get(3).setConfrontos(adversarios);
        
        rodadas = new ArrayList<Rodada>();
        Rodada r1 = new Rodada(listaDeClubes.get(0),listaDeClubes.get(1), listaDeClubes.get(2), listaDeClubes.get(3));
        Rodada r2 = new Rodada(listaDeClubes.get(0),listaDeClubes.get(2), listaDeClubes.get(1), listaDeClubes.get(3));
        Rodada r3 = new Rodada(listaDeClubes.get(0),listaDeClubes.get(3), listaDeClubes.get(1), listaDeClubes.get(2));
        getRodadas().add(r1);
        getRodadas().add(r2);
        getRodadas().add(r3);
        getRodadas().add(r1);
        getRodadas().add(r2);
        getRodadas().add(r3);
    }

    public ArrayList<Clube> getListaDeClubes() {
        return listaDeClubes;
    }

    public void setListaDeClubes(ArrayList<Clube> listaDeClubes) {
        this.listaDeClubes = listaDeClubes;
    }
    
    public ArrayList<Clube> getClassificacao() {
        return classificacao;
    }

    public ArrayList<Clube> getTabelaDeJogos() {
        return tabelaDeJogos;
    }
    
    public void setTabelaDeJogos(ArrayList<Clube> tabelaDeJogos) {
        this.tabelaDeJogos = tabelaDeJogos;
    }

    public int getRodada() {
        return rodada;
    }
    
    public void setRodada(int rodada) {
        this.rodada = rodada;
    }

    public ArrayList<Jogador> getArtilharia() {
        return artilharia;
    }

    public void setArtilharia(ArrayList<Jogador> artilharia) {
        this.artilharia = artilharia;
    }

    public ArrayList<Jogador> getRankingAssistencias() {
        return rankingAssistencias;
    }

    public void setRankingAssistencias(ArrayList<Jogador> rankingAssistencias) {
        this.rankingAssistencias = rankingAssistencias;
    }

    public ArrayList<Rodada> getRodadas() {
        return rodadas;
    }

    public PlaySound getMusicaDeFundo() {
        return musicaDeFundo;
    }

    public void setMusicaDeFundo(PlaySound musicaDeFundo) {
        this.musicaDeFundo = musicaDeFundo;
    }
   
}
