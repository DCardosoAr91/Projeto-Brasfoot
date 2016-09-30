
package interfaces;

import clube.Campeonato;
import clube.Jogador;
import clube.Tecnico;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class EscalarTime extends javax.swing.JDialog {

    Tecnico tecnico;
    Campeonato campeonato;
    DefaultTableModel modelTitulares;
    DefaultTableModel modelReservas;
    Dimension dimensao;
    GerenciarClube gc;
    
    public EscalarTime(Tecnico tecnico, Campeonato campeonato, GerenciarClube gc) {
        this.gc = gc;
        this.tecnico = tecnico;
        this.campeonato = campeonato;
        initComponents();
        carregarDadosElenco();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaTitulares = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaReservas = new javax.swing.JTable();
        labelTimeTitular = new javax.swing.JLabel();
        labelTimeReserva = new javax.swing.JLabel();
        iniciarPartida = new javax.swing.JButton();
        substituir = new javax.swing.JButton();
        voltarParaOTime = new javax.swing.JButton();

        tabelaTitulares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Posicao", "Ataque", "Defesa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaTitulares.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaTitulares);

        tabelaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Posicao", "Ataque", "Defesa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaReservas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabelaReservas);

        labelTimeTitular.setText("Time Titular");

        labelTimeReserva.setText("Time Reserva");

        iniciarPartida.setText("Ir para a Partida");
        iniciarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarPartidaActionPerformed(evt);
            }
        });

        substituir.setText("Substituir");
        substituir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                substituirActionPerformed(evt);
            }
        });

        voltarParaOTime.setText("Voltar para o Time");
        voltarParaOTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarParaOTimeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(labelTimeTitular)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTimeReserva)
                .addGap(238, 238, 238))
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(voltarParaOTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iniciarPartida)
                .addGap(102, 102, 102))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(substituir)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTimeTitular)
                    .addComponent(labelTimeReserva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addComponent(substituir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(voltarParaOTime)
                    .addComponent(iniciarPartida))
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carregarDadosElenco(){
        
        modelTitulares = (DefaultTableModel) tabelaTitulares.getModel();     
        for (int i = 0; i < tecnico.getClube().getTitulares().size(); i++) {
            String nome = tecnico.getClube().getTitulares().get(i).getNome();
            String posicao = tecnico.getClube().getTitulares().get(i).getPosicao();
            String forcaAtaque = ""+tecnico.getClube().getTitulares().get(i).getAtaque();
            String forcaDefesa = ""+tecnico.getClube().getTitulares().get(i).getDefesa();
            modelTitulares.addRow(new String []{
            nome, posicao, forcaAtaque, forcaDefesa});
        }
        
        modelReservas = (DefaultTableModel) tabelaReservas.getModel();
        for (int i = 0; i < tecnico.getClube().getReservas().size(); i++) {
            String nome = tecnico.getClube().getReservas().get(i).getNome();
            String posicao = tecnico.getClube().getReservas().get(i).getPosicao();
            String forcaAtaque = ""+tecnico.getClube().getReservas().get(i).getAtaque();
            String forcaDefesa = ""+tecnico.getClube().getReservas().get(i).getDefesa();
            modelReservas.addRow(new String []{
            nome, posicao, forcaAtaque, forcaDefesa});
        }
    }
    
    
    private void voltarParaOTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarParaOTimeActionPerformed
        this.setVisible(false);
        this.setModal(false);
    }//GEN-LAST:event_voltarParaOTimeActionPerformed

    private void substituirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_substituirActionPerformed
       if(tabelaTitulares.getSelectedRow()!= -1 && tabelaReservas.getSelectedRow()!= -1){
           int titular = tabelaTitulares.getSelectedRow();
           int reserva = tabelaReservas.getSelectedRow();
           
            modelTitulares.setValueAt(tecnico.getClube().getReservas().get(reserva).getNome(), titular, 0);
            modelTitulares.setValueAt(tecnico.getClube().getReservas().get(reserva).getPosicao(), titular, 1);
            modelTitulares.setValueAt(tecnico.getClube().getReservas().get(reserva).getAtaque(), titular, 2);
            modelTitulares.setValueAt(tecnico.getClube().getReservas().get(reserva).getDefesa(), titular, 3);
           
            modelReservas.setValueAt(tecnico.getClube().getTitulares().get(titular).getNome(), reserva, 0);
            modelReservas.setValueAt(tecnico.getClube().getTitulares().get(titular).getPosicao(), reserva, 1);
            modelReservas.setValueAt(tecnico.getClube().getTitulares().get(titular).getAtaque(), reserva, 2);
            modelReservas.setValueAt(tecnico.getClube().getTitulares().get(titular).getDefesa(), reserva, 3);
            
           Jogador aux = tecnico.getClube().getTitulares().remove(titular);
           tecnico.getClube().getTitulares().add(titular,tecnico.getClube().getReservas().remove(reserva));
           tecnico.getClube().getReservas().add(reserva, aux);
               
       }else{
           JOptionPane.showMessageDialog(null, "Selecione um jogador reserva e um titular para efetuar a substituição!", "ERRO", 0);
       }
    }//GEN-LAST:event_substituirActionPerformed

    private void iniciarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarPartidaActionPerformed
        this.setVisible(false);
        campeonato.getMusicaDeFundo().getClip().stop();
        Partida partida = new Partida(dimensao, tecnico, campeonato, gc);
        partida.setVisible(true);
        partida.tempo();
        partida.setDefaultCloseOperation(partida.DO_NOTHING_ON_CLOSE);
    }//GEN-LAST:event_iniciarPartidaActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton iniciarPartida;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelTimeReserva;
    private javax.swing.JLabel labelTimeTitular;
    private javax.swing.JButton substituir;
    private javax.swing.JTable tabelaReservas;
    private javax.swing.JTable tabelaTitulares;
    private javax.swing.JButton voltarParaOTime;
    // End of variables declaration//GEN-END:variables
    public void definirPosicao(Dimension dimensao) {
        this.dimensao = dimensao;
        this.setLocation((int) ((dimensao.getWidth() - this.getSize().width) / 2), (int) ((dimensao.getHeight() - this.getSize().height)/2));
    }
  
}

