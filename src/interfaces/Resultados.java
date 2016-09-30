/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import clube.Campeonato;
import javax.swing.JOptionPane;

/**
 *
 * @author anton
 */
public class Resultados extends javax.swing.JDialog {

    GerenciarClube gc;
    Campeonato campeonato;
    public Resultados(GerenciarClube gc, Campeonato c) {
        initComponents();
        this.setTitle("Resultados da Rodada");
        this.gc = gc;
        this.gc.campeonato = c;
        carregarDadosResultado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ok = new javax.swing.JButton();
        labelResultados = new javax.swing.JLabel();
        labelNumRodada = new javax.swing.JLabel();
        labelNomeClube1 = new javax.swing.JLabel();
        labelPlacarClube1 = new javax.swing.JLabel();
        labelVersusp1 = new javax.swing.JLabel();
        labelPlacarClube2 = new javax.swing.JLabel();
        labelNomeClube2 = new javax.swing.JLabel();
        labelNomeClube3 = new javax.swing.JLabel();
        labelPlacarClube3 = new javax.swing.JLabel();
        labelVersusp2 = new javax.swing.JLabel();
        labelPlacarClube4 = new javax.swing.JLabel();
        labelNomeClube4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ok.setText("Ok");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        labelResultados.setText("Resultados da Rodada");

        labelNumRodada.setText("Rodada");

        labelNomeClube1.setText("Clube1");

        labelPlacarClube1.setText("0");

        labelVersusp1.setText("x");

        labelPlacarClube2.setText("0");

        labelNomeClube2.setText("Clube2");

        labelNomeClube3.setText("Clube3");

        labelPlacarClube3.setText("0");

        labelVersusp2.setText("x");

        labelPlacarClube4.setText("0");

        labelNomeClube4.setText("Clube4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(labelResultados))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(labelNumRodada))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelNomeClube1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelPlacarClube1)
                                .addGap(18, 18, 18)
                                .addComponent(labelVersusp1)
                                .addGap(18, 18, 18)
                                .addComponent(labelPlacarClube2)
                                .addGap(18, 18, 18)
                                .addComponent(labelNomeClube2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ok)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelNomeClube3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(labelPlacarClube3)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelVersusp2)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelPlacarClube4)))
                                .addGap(18, 18, 18)
                                .addComponent(labelNomeClube4)))))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(labelResultados)
                .addGap(27, 27, 27)
                .addComponent(labelNumRodada)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeClube1)
                    .addComponent(labelPlacarClube1)
                    .addComponent(labelVersusp1)
                    .addComponent(labelPlacarClube2)
                    .addComponent(labelNomeClube2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeClube3)
                    .addComponent(labelPlacarClube3)
                    .addComponent(labelVersusp2)
                    .addComponent(labelPlacarClube4)
                    .addComponent(labelNomeClube4))
                .addGap(44, 44, 44)
                .addComponent(ok)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarDadosResultado(){
        int rodada = gc.campeonato.getRodada() -1;
        labelNumRodada.setText("Rodada "+rodada);
        labelNomeClube1.setText(""+gc.tecnico.getClube().getNome());
        labelPlacarClube1.setText(""+gc.tecnico.getClube().getNumGols());
        labelNomeClube2.setText(""+gc.tecnico.getClube().getConfrontos().get(gc.campeonato.getRodada() -2).getNome());
        labelPlacarClube2.setText(""+gc.tecnico.getClube().getConfrontos().get(gc.campeonato.getRodada() -2).getNumGols());
        labelNomeClube3.setText(""+gc.campeonato.getRodadas().get(gc.campeonato.getRodada()-2).getClubes().get(0).getNome());
        labelPlacarClube3.setText(""+gc.campeonato.getRodadas().get(gc.campeonato.getRodada() -2).getClubes().get(0).getNumGols());
        labelNomeClube4.setText(""+gc.campeonato.getRodadas().get(gc.campeonato.getRodada() -2).getClubes().get(1).getNome());
        labelPlacarClube4.setText(""+gc.campeonato.getRodadas().get(gc.campeonato.getRodada() -2).getClubes().get(1).getNumGols());
    }
    
    
    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        this.setVisible(false);
        gc.campeonato.getMusicaDeFundo().getClip().start();
        if(gc.campeonato.getRodada() == 7){
            gc.getLabelNumRodada().setText("Rodada ------ ");
            gc.getLabelNomeClubeAdversario().setText(" ----------");
            gc.getLabelLocalConfronto().setText("--------------");
            gc.getDefinirEscalacao().setEnabled(false);
            JOptionPane.showMessageDialog(null, " Fim do Campeonato! Verifique sua classificação..", "Atenção", WIDTH, null);
        }else{
            gc.getLabelNumRodada().setText("Rodada "+gc.campeonato.getRodada() );
            gc.getLabelNomeClubeAdversario().setText(""+gc.tecnico.getClube().getConfrontos().get(gc.campeonato.getRodada()-1).getNome());
            gc.getLabelAnoCriaçãoTimeAdversario().setText(gc.tecnico.getClube().getConfrontos().get(gc.campeonato.getRodada()-1).getAnoDeFuncacao());
            gc.getLabelImagemAdversario().setIcon(gc.tecnico.getClube().getConfrontos().get(gc.campeonato.getRodada()-1).getImagemClube().getIcon());
            if(gc.tecnico.getClube().isVisitante() == true){
                gc.tecnico.getClube().setVisitante(false);
                gc.getLabelLocalConfronto().setText("Casa");
            }else{
                gc.tecnico.getClube().setVisitante(true);
                gc.getLabelLocalConfronto().setText("Fora");
            }
        }
    }//GEN-LAST:event_okActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelNomeClube1;
    private javax.swing.JLabel labelNomeClube2;
    private javax.swing.JLabel labelNomeClube3;
    private javax.swing.JLabel labelNomeClube4;
    private javax.swing.JLabel labelNumRodada;
    private javax.swing.JLabel labelPlacarClube1;
    private javax.swing.JLabel labelPlacarClube2;
    private javax.swing.JLabel labelPlacarClube3;
    private javax.swing.JLabel labelPlacarClube4;
    private javax.swing.JLabel labelResultados;
    private javax.swing.JLabel labelVersusp1;
    private javax.swing.JLabel labelVersusp2;
    private javax.swing.JButton ok;
    // End of variables declaration//GEN-END:variables
}
