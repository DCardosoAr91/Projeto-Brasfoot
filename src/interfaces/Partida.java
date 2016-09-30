
package interfaces;

import clube.Campeonato;
import clube.Tecnico;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import som.PlaySound;


public class Partida extends javax.swing.JDialog {
    
    Tecnico tecnico;
    Campeonato campeonato;
    GerenciarClube gerenciar;
    int tempo, gol1, gol2;
    boolean atacar;
    boolean trocarMensagem;
    Timer tempoPartida;
    Timer turnoPartida;
    Timer turnoMensagem;
    Substituicao sub;
    PlaySound somTorcida;
    
    public Partida(Dimension x, Tecnico t,  Campeonato c, GerenciarClube gc){
        initComponents();
        this.setTitle("Partida");
        somTorcida = new PlaySound();
        somTorcida.playWavLoop(getClass().getResource("/som/torcida.wav"));
        gerenciar = gc;
        tecnico = t;
        campeonato = c;
        labelNomeCampeonato.setText("Campeonato Gaúcho");
        labelNumRodada.setText("Rodada "+campeonato.getRodada());
        labelAdversario.setText(""+tecnico.getClube().getConfrontos().get(campeonato.getRodada()-1).getNome());
        if(tecnico.getClube().isVisitante()){
            labelLocalPartida.setText("Fora");
        }else{
            labelLocalPartida.setText("Casa");
        }
        labelNomeClubeEscolhido.setText(""+tecnico.getClube().getNome());
        this.setLocation((int) ((x.getWidth() - this.getSize().width) / 2), (int) ((x.getHeight() - this.getSize().height)/2));
        barraDeTempo.setMinimum(0);
        barraDeTempo.setMaximum(90);
        tempo = 0;
        labelEventosPartida.setHorizontalTextPosition(SwingConstants.CENTER);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelNomeCampeonato = new javax.swing.JLabel();
        labelNumRodada = new javax.swing.JLabel();
        labelNomeClubeEscolhido = new javax.swing.JLabel();
        labelPlacarClubeEscolhido = new javax.swing.JLabel();
        labelPlacarAdversario = new javax.swing.JLabel();
        labelAdversario = new javax.swing.JLabel();
        barraDeTempo = new javax.swing.JProgressBar();
        labelTempo = new javax.swing.JLabel();
        fazerSubstituicao = new javax.swing.JButton();
        labelVersus = new javax.swing.JLabel();
        labelEventosPartida = new javax.swing.JLabel();
        labelTempoBarraProgresso = new javax.swing.JLabel();
        labelLocalPartida = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelNomeCampeonato.setText("Nome Campeonato");

        labelNumRodada.setText("Numero da Rodada");

        labelNomeClubeEscolhido.setText("Clube 1");

        labelPlacarClubeEscolhido.setText("0");

        labelPlacarAdversario.setText("0");

        labelAdversario.setText("Clube2");

        labelTempo.setText("Tempo");

        fazerSubstituicao.setText("Substituição");
        fazerSubstituicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fazerSubstituicaoActionPerformed(evt);
            }
        });

        labelVersus.setText("x");

        labelEventosPartida.setText("Eventos da Partida");

        labelTempoBarraProgresso.setText("0");

        labelLocalPartida.setText("Local");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fazerSubstituicao)
                .addGap(177, 177, 177))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(barraDeTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelNomeClubeEscolhido)
                                        .addGap(37, 37, 37)
                                        .addComponent(labelPlacarClubeEscolhido, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelVersus, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelPlacarAdversario, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(labelAdversario))))
                            .addComponent(labelEventosPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(156, 156, 156)
                                .addComponent(labelTempo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelTempoBarraProgresso, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNomeCampeonato)
                        .addGap(89, 89, 89)
                        .addComponent(labelNumRodada)
                        .addGap(88, 88, 88))))
            .addGroup(layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(labelLocalPartida)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumRodada)
                    .addComponent(labelNomeCampeonato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelLocalPartida)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTempo)
                    .addComponent(labelTempoBarraProgresso))
                .addGap(2, 2, 2)
                .addComponent(barraDeTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeClubeEscolhido)
                    .addComponent(labelPlacarClubeEscolhido)
                    .addComponent(labelVersus)
                    .addComponent(labelPlacarAdversario)
                    .addComponent(labelAdversario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEventosPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fazerSubstituicao)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fazerSubstituicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fazerSubstituicaoActionPerformed

        if(sub == null){
            sub = new Substituicao(tempoPartida, turnoPartida, tecnico, turnoMensagem);
            sub.setLocationRelativeTo(null);
            sub.setDefaultCloseOperation(sub.DO_NOTHING_ON_CLOSE);
        }
        sub.setVisible(true);
        turnoPartida.stop();
        tempoPartida.stop();
        turnoMensagem.stop();
    }//GEN-LAST:event_fazerSubstituicaoActionPerformed
    public void tempo(){
        tempoPartida = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(tempo == 45){
                    if(sub == null){
                        PlaySound p = new PlaySound();
                        p.playWavLoop(getClass().getResource("/som/apito.wav"));
                        sub = new Substituicao(tempoPartida, turnoPartida, tecnico, turnoMensagem);
                        sub.setLocationRelativeTo(null);
                        sub.setDefaultCloseOperation(sub.DO_NOTHING_ON_CLOSE);
                        turnoMensagem.stop();
                        labelEventosPartida.setText("Acaba o primeiro tempo. Jogo pegado até o momento hein o Batista..");
                    }
                    sub.setVisible(true);
                    turnoPartida.stop();
                    tempoPartida.stop();
                }
                if(tempo >90){
                    PlaySound p = new PlaySound();
                    p.playWavLoop(getClass().getResource("/som/apito.wav"));
                    somTorcida.getClip().stop();
                    tempoPartida.stop();
                    turnoMensagem.stop();
                    turnoPartida.stop();
                    visibilidade(false);
                    if(gol1 == gol2){
                        tecnico.getClube().setNumEmpates(tecnico.getClube().getNumEmpates()+1);
                        tecnico.getClube().getConfrontos().get(campeonato.getRodada()-1).setNumEmpates(tecnico.getClube().getConfrontos().get(campeonato.getRodada()-1).getNumEmpates()+1);
                    }else if(gol1 > gol2){
                        tecnico.getClube().setNumVitorias(tecnico.getClube().getNumVitorias()+1);
                        tecnico.getClube().getConfrontos().get(campeonato.getRodada()-1).setNumDerrotas(tecnico.getClube().getConfrontos().get(campeonato.getRodada()-1).getNumDerrotas()+1);
                    }else{
                        tecnico.getClube().setNumDerrotas(tecnico.getClube().getNumDerrotas()+1);
                        tecnico.getClube().getConfrontos().get(campeonato.getRodada()-1).setNumVitorias(tecnico.getClube().getConfrontos().get(campeonato.getRodada()-1).getNumVitorias()+1);
                    }
                    
                    tecnico.getClube().setNumGols(gol1);
                    tecnico.getClube().setGP(tecnico.getClube().getGP() + gol1);
                    tecnico.getClube().setGC(tecnico.getClube().getGC() + gol2);
                    tecnico.getClube().setSaldoGols(tecnico.getClube().getGP() - tecnico.getClube().getGC());
                    tecnico.getClube().getConfrontos().get(campeonato.getRodada()-1).setNumGols(gol2);
                    tecnico.getClube().getConfrontos().get(campeonato.getRodada()-1).setGP(tecnico.getClube().getConfrontos().get(campeonato.getRodada()-1).getGP() + gol2);
                    tecnico.getClube().getConfrontos().get(campeonato.getRodada()-1).setGC(tecnico.getClube().getConfrontos().get(campeonato.getRodada()-1).getGC() + gol1);
                    tecnico.getClube().getConfrontos().get(campeonato.getRodada()-1).setSaldoGols(tecnico.getClube().getConfrontos().get(campeonato.getRodada()-1).getGP() - tecnico.getClube().getConfrontos().get(campeonato.getRodada()-1).getGC());
                    campeonato.simularPartidas(tecnico.getClube(), tecnico.getClube().getConfrontos().get(campeonato.getRodada() - 1));
                    Resultados resultados = new Resultados(gerenciar, campeonato);
                    resultados.setVisible(true);
                    resultados.setLocationRelativeTo(null);
                    resultados.setDefaultCloseOperation(resultados.DO_NOTHING_ON_CLOSE);
                    resultados.setModal(true);
                }else{
                    barraDeTempo.setValue(tempo);
                    labelTempoBarraProgresso.setText(""+tempo);
                    tempo++;
                }
            }
        });
        
        turnoPartida = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(tempo >= 90){
                    
                    turnoPartida.stop();
                    turnoMensagem.stop();
                    tempoPartida.stop();
                }else{
                    if(atacar == true){
                        turnoAtaque();
                        //turnoMensagem.start();
                        atacar = false;
                    }else{
                        turnoDefesa();
                        //turnoMensagem.start();
                        atacar = true;
                    }
                }     
            }
        });
        
        turnoMensagem = new Timer(4600, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String time1 = tecnico.getClube().getNome();
                String time2 = tecnico.getClube().getConfrontos().get(campeonato.getRodada() -1).getNome();
                if(tempo >= 90){
                    turnoPartida.stop();
                }else{
                    if(atacar == true){
                        if(trocarMensagem == false){
                            labelEventosPartida.setText(""+time1+" esta trocando passes na intermediária..");
                            trocarMensagem = true;
                        }else{
                            trocarMensagem = false;
                            labelEventosPartida.setText(""+time1+" esta no ataque, pressionando o "+time2);
                        }
                    }else{
                        if(trocarMensagem == false){
                            trocarMensagem = true;
                            labelEventosPartida.setText(""+time2+" esta trocando passes na intermediária..");
                        }else{
                            trocarMensagem = false;
                            labelEventosPartida.setText(""+time2+" esta no ataque, pressionando o "+time1);
                        }
                    }
                }
            }
        });
        
        tempoPartida.start();
        turnoPartida.start();
        turnoMensagem.start();
        labelEventosPartida.setText("As duas equipes estão se estudando..");
    }
    
    public void turnoAtaque(){
        if(tecnico.getClube().atacar(campeonato.getRodada())){
            PlaySound p = new PlaySound();
            p.playWavLoop(getClass().getResource("/som/gol.wav"));
            labelEventosPartida.setText("FEITOOOOOO! Gol do "+tecnico.getClube().getNome());
            gol1 = gol1 +1;
            labelPlacarClubeEscolhido.setText(""+gol1);
        }else{
            labelEventosPartida.setText(""+tecnico.getClube().getConfrontos().get(campeonato.getRodada()-1).getNome()+" recuperou a posse da bola");
        }
    }
    
    public void turnoDefesa(){          
        if(tecnico.getClube().defender(campeonato.getRodada())){
            labelEventosPartida.setText(""+tecnico.getClube().getNome()+" recuperou a posse da bola ");
        }else{
            PlaySound p = new PlaySound();
            p.playWavLoop(getClass().getResource("/som/gol.wav"));
            labelEventosPartida.setText("Vish... Gol do "+tecnico.getClube().getConfrontos().get(campeonato.getRodada()-1).getNome()+"!");
            gol2 = gol2 +1;
            labelPlacarAdversario.setText(""+gol2);
        }
    }
    
    public void visibilidade(boolean x){
        this.setVisible(x);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraDeTempo;
    private javax.swing.JButton fazerSubstituicao;
    private javax.swing.JLabel labelAdversario;
    private javax.swing.JLabel labelEventosPartida;
    private javax.swing.JLabel labelLocalPartida;
    private javax.swing.JLabel labelNomeCampeonato;
    private javax.swing.JLabel labelNomeClubeEscolhido;
    private javax.swing.JLabel labelNumRodada;
    private javax.swing.JLabel labelPlacarAdversario;
    private javax.swing.JLabel labelPlacarClubeEscolhido;
    private javax.swing.JLabel labelTempo;
    private javax.swing.JLabel labelTempoBarraProgresso;
    private javax.swing.JLabel labelVersus;
    // End of variables declaration//GEN-END:variables
}
