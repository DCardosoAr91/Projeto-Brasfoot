package interfaces;

import clube.Campeonato;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author anton
 */
public class TabelaClassificacao extends javax.swing.JDialog {
    
    
    int cont = 0;
    
    public TabelaClassificacao(Campeonato c){
        initComponents();
        this.setTitle("Classificação");
        c.atualizarTabela();
        atualizarDadosTabelaClassificacao(c);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaTitulares = new javax.swing.JTable();
        voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Tabela de Classificação");

        tabelaTitulares.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Posicao", "Clube", "Pontos", "Saldo", "V", "E", "D", "GP", "GC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaTitulares.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaTitulares);
        if (tabelaTitulares.getColumnModel().getColumnCount() > 0) {
            tabelaTitulares.getColumnModel().getColumn(0).setResizable(false);
            tabelaTitulares.getColumnModel().getColumn(1).setResizable(false);
            tabelaTitulares.getColumnModel().getColumn(2).setResizable(false);
            tabelaTitulares.getColumnModel().getColumn(3).setResizable(false);
            tabelaTitulares.getColumnModel().getColumn(4).setResizable(false);
            tabelaTitulares.getColumnModel().getColumn(6).setResizable(false);
            tabelaTitulares.getColumnModel().getColumn(8).setResizable(false);
        }

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(voltar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel1)))
                .addContainerGap(191, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(voltar)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atualizarDadosTabelaClassificacao(Campeonato c){
            DefaultTableModel modelClassificacao = (DefaultTableModel) tabelaTitulares.getModel();
            for (int i = 0; i < c.getClassificacao().size(); i++) {
            cont = cont +1;
            String posicao = ""+cont;
            String nome = c.getClassificacao().get(i).getNome();
            String pontos = ""+c.getClassificacao().get(i).getPontuacao();
            String saldo = ""+c.getClassificacao().get(i).getSaldoGols();
            String vitorias = ""+c.getClassificacao().get(i).getNumVitorias();
            String empates = ""+c.getClassificacao().get(i).getNumEmpates();
            String derrotas = ""+c.getClassificacao().get(i).getNumDerrotas();
            String gp = ""+c.getClassificacao().get(i).getGP();
            String gc = ""+c.getClassificacao().get(i).getGC();
            modelClassificacao.addRow(new String []{
            posicao, nome, pontos, saldo, vitorias, empates, derrotas, gp, gc});
            tabelaTitulares.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            
            TableColumn col = tabelaTitulares.getColumnModel().getColumn(0);
            col.setPreferredWidth(55);
            col = tabelaTitulares.getColumnModel().getColumn(1);
            col.setPreferredWidth(80);
            col = tabelaTitulares.getColumnModel().getColumn(2);
            col.setPreferredWidth(60);
            col = tabelaTitulares.getColumnModel().getColumn(3);
            col.setPreferredWidth(60);
            col = tabelaTitulares.getColumnModel().getColumn(4);
            col.setPreferredWidth(25);
            col = tabelaTitulares.getColumnModel().getColumn(5);
            col.setPreferredWidth(25);
            col = tabelaTitulares.getColumnModel().getColumn(6);
            col.setPreferredWidth(25);
            col = tabelaTitulares.getColumnModel().getColumn(7);
            col.setPreferredWidth(25);
            col = tabelaTitulares.getColumnModel().getColumn(8);
            col.setPreferredWidth(25);
        }
    }
    
    
    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_voltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaTitulares;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
