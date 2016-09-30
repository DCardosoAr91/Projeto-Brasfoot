package interfaces;

import clube.Campeonato;
import clube.Tecnico;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author anton
 */
public class SelecaoDoTime extends javax.swing.JFrame {

    private Campeonato campeonato;
    
    public SelecaoDoTime(Campeonato c){ 
        campeonato = c;
        initComponents();
        carregarDadosListaDeClubes();
    }

    
    private void carregarDadosListaDeClubes(){
        this.setTitle("Selecionar Clube");
        DefaultTableModel model = (DefaultTableModel) tabelaClubes.getModel();
        for (int i = 0; i < campeonato.getListaDeClubes().size(); i++) {
            model.addRow(new String []{campeonato.getListaDeClubes().get(i).getNome(),
            campeonato.getListaDeClubes().get(i).getAnoDeFuncacao(),""+campeonato.getListaDeClubes().get(i).calcularMediaGerarElenco()});
        }
        model.isCellEditable(WIDTH, WIDTH);
        itemSelecoes.removeAllItems();
        itemSelecoes.addItem("Brasil");
        itemSelecoes.addItem("Alemanha");
        itemSelecoes.addItem("Italia");
        tabelaClubes.changeSelection(0,  3, false , false);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelNomeTecnico = new javax.swing.JLabel();
        campoTextoNomeTecnico = new javax.swing.JTextField();
        labelNacionalidade = new javax.swing.JLabel();
        itemSelecoes = new javax.swing.JComboBox();
        iniciarCampeonato = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClubes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Selecione o clube");

        jLabel2.setText("Dados do Treinador");

        labelNomeTecnico.setText("Nome");

        labelNacionalidade.setText("Nacionalidade");

        itemSelecoes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        itemSelecoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSelecoesActionPerformed(evt);
            }
        });

        iniciarCampeonato.setText("Iniciar Campeonato");
        iniciarCampeonato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarCampeonatoActionPerformed(evt);
            }
        });

        tabelaClubes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do Clube", "Ano de Criação", "Força Media"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaClubes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaClubes);
        if (tabelaClubes.getColumnModel().getColumnCount() > 0) {
            tabelaClubes.getColumnModel().getColumn(0).setResizable(false);
            tabelaClubes.getColumnModel().getColumn(1).setResizable(false);
            tabelaClubes.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(174, 174, 174)
                                .addComponent(labelNomeTecnico)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelNacionalidade)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemSelecoes, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTextoNomeTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(iniciarCampeonato)
                        .addGap(72, 72, 72)))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(labelNomeTecnico))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(campoTextoNomeTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemSelecoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNacionalidade))
                .addGap(52, 52, 52)
                .addComponent(iniciarCampeonato)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarCampeonatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarCampeonatoActionPerformed
        if(campoTextoNomeTecnico.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Favor insira um nome para o Tecnico!", "Atenção", WIDTH, null);
        }else{
            Tecnico tecnico = new Tecnico();
            tecnico.setNome(campoTextoNomeTecnico.getText());
            tecnico.setNacionalidade(itemSelecoes.getSelectedItem().toString());
            tecnico.setClube(campeonato.getListaDeClubes().get(tabelaClubes.getSelectedRow()));
            GerenciarClube gerenciar = new GerenciarClube(campeonato,tecnico);
            gerenciar.setVisible(true);
            gerenciar.setExtendedState(MAXIMIZED_BOTH);
            this.setVisible(false);
            gerenciar.setTitle("Brasfoot APIII");
        }
    }//GEN-LAST:event_iniciarCampeonatoActionPerformed

    private void itemSelecoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSelecoesActionPerformed
        
    }//GEN-LAST:event_itemSelecoesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoTextoNomeTecnico;
    private javax.swing.JButton iniciarCampeonato;
    private javax.swing.JComboBox itemSelecoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelNacionalidade;
    private javax.swing.JLabel labelNomeTecnico;
    private javax.swing.JTable tabelaClubes;
    // End of variables declaration//GEN-END:variables
}
