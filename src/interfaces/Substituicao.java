package interfaces;

import clube.Jogador;
import clube.Tecnico;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


public class Substituicao extends javax.swing.JDialog {
    
    Tecnico tecnico;
    Timer x, y, z;
    DefaultTableModel modelTitulares;
    DefaultTableModel modelReservas;
    int contSubstituicoes;
    
    public Substituicao(Timer x, Timer y, Tecnico tecnico, Timer z) {
        x.stop();
        y.stop();
        this.tecnico = tecnico;
        this.x = x;
        this.y = y;
        this.z = z;
        initComponents();
        modelTitulares = (DefaultTableModel) tabelaTitulares.getModel();
        this.setTitle("Substituição");
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
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        voltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaTitulares = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaReservas = new javax.swing.JTable();
        substituir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

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
        tabelaTitulares.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tabelaTitularesAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
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

        substituir.setText("Substituir");
        substituir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                substituirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(voltar)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(substituir)
                .addGap(352, 352, 352))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(56, 56, 56)
                .addComponent(substituir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(voltar)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
       x.start();
       y.start();
       z.start();
       this.setVisible(false);
    }//GEN-LAST:event_voltarActionPerformed

    private void tabelaTitularesAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tabelaTitularesAncestorAdded
      
    }//GEN-LAST:event_tabelaTitularesAncestorAdded

    private void substituirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_substituirActionPerformed
        if(contSubstituicoes < 3){
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
               contSubstituicoes = contSubstituicoes + 1;
               if(contSubstituicoes == 3){
                   substituir.setEnabled(false);
               }
            }else{
               JOptionPane.showMessageDialog(null, "Selecione um jogador reserva e um titular para efetuar a substituição!", "ERRO", 0);
            }
        }
    }//GEN-LAST:event_substituirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton substituir;
    private javax.swing.JTable tabelaReservas;
    private javax.swing.JTable tabelaTitulares;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
