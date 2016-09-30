
package interfaces;

import clube.Campeonato;
import clube.Tecnico;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author antoni 
 */
public class GerenciarClube extends javax.swing.JFrame {

    Campeonato campeonato;
    Tecnico tecnico;
    
    public GerenciarClube(Campeonato c, Tecnico t) {
        initComponents();
        campeonato = c;
        tecnico = t;
        labelNomeDoTime.setText(tecnico.getClube().getNome());
        labelNomeDoCampeonato.setText("Gauchão");
        labelNomeTecnico.setText(tecnico.getNome());
        atualizarDadosDoClube(); 
    }

    private void atualizarDadosDoClube(){
        if(campeonato.getRodada() == 7) {
            labelAnoCriaçãoTimeAdversario.setText("----------");
            labelNumRodada.setText("Rodada -----");
            labelNomeClubeAdversario.setText("----------");
            definirEscalacao.setEnabled(false);
        }else{
            labelAnoCriaçãoTimeAdversario.setText(tecnico.getClube().getConfrontos().get(campeonato.getRodada() -1).getAnoDeFuncacao());
            labelNumRodada.setText("Rodada "+campeonato.getRodada());
            labelNomeClubeAdversario.setText(tecnico.getClube().getConfrontos().get(campeonato.getRodada() -1).getNome());
            labelImagemAdversario.setIcon(tecnico.getClube().getConfrontos().get(campeonato.getRodada() -1).getImagemClube().getIcon());
            if(tecnico.getClube().isVisitante()){
                getLabelLocalConfronto().setText("Fora");
            }else{
                getLabelLocalConfronto().setText("Casa");
            }
        }
        labelNacionalidade.setText(tecnico.getNacionalidade());
        DefaultTableModel model = (DefaultTableModel) tabelaDeJogadoresDoClube.getModel();
        labelImagemClubeAtual.setIcon(tecnico.getClube().getImagemClube().getIcon());
        
        for (int i = 0; i < tecnico.getClube().getTitulares().size(); i++) {
            String nome = tecnico.getClube().getTitulares().get(i).getNome();
            String posicao = tecnico.getClube().getTitulares().get(i).getPosicao();
            String forcaAtaque = ""+tecnico.getClube().getTitulares().get(i).getAtaque();
            String forcaDefesa = ""+tecnico.getClube().getTitulares().get(i).getDefesa();
            String idade = ""+tecnico.getClube().getTitulares().get(i).getIdade();
            model.addRow(new String []{
            nome, posicao, forcaAtaque, forcaDefesa, idade});
        }
        
        for (int i = 0; i < tecnico.getClube().getReservas().size(); i++) {
            String nome = tecnico.getClube().getReservas().get(i).getNome();
            String posicao = tecnico.getClube().getReservas().get(i).getPosicao();
            String forcaAtaque = ""+tecnico.getClube().getReservas().get(i).getAtaque();
            String forcaDefesa = ""+tecnico.getClube().getReservas().get(i).getDefesa();
            String idade = ""+tecnico.getClube().getReservas().get(i).getIdade();
            model.addRow(new String []{
            nome, posicao, forcaAtaque, forcaDefesa, idade});
        }  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dadosAdversario = new javax.swing.JPanel();
        labelNumRodada = new javax.swing.JLabel();
        labelNomeClubeAdversario = new javax.swing.JLabel();
        labelAnoCriaçãoTimeAdversario = new javax.swing.JLabel();
        labelProxJogo = new javax.swing.JLabel();
        labelImagemAdversario = new javax.swing.JLabel();
        labelImgAdv = new javax.swing.JLabel();
        labelLocalConfronto = new javax.swing.JLabel();
        dadosDoClube = new javax.swing.JPanel();
        labelNomeDoTime = new javax.swing.JLabel();
        labelNomeDoCampeonato = new javax.swing.JLabel();
        labelNomeTecnico = new javax.swing.JLabel();
        labelNacionalidade = new javax.swing.JLabel();
        labelImagemClubeAtual = new javax.swing.JLabel();
        definirEscalacao = new javax.swing.JButton();
        dadosJogadorSelecionado = new javax.swing.JPanel();
        labelForcaAtaque = new javax.swing.JLabel();
        labelNomeJogador = new javax.swing.JLabel();
        labelForcaDefesa = new javax.swing.JLabel();
        labelIdade = new javax.swing.JLabel();
        labelPosicaoJogador = new javax.swing.JLabel();
        labelGols = new javax.swing.JLabel();
        labelAssistencias = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDeJogadoresDoClube = new javax.swing.JTable();
        verificarTabelaClassificacao = new javax.swing.JButton();
        salvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelNumRodada.setText("Rodada");

        labelNomeClubeAdversario.setText("Clube Adversario");

        labelAnoCriaçãoTimeAdversario.setText("Ano de Criação");

        labelProxJogo.setText("Proximo Jogo");

        labelLocalConfronto.setText("Local Confronto");

        javax.swing.GroupLayout dadosAdversarioLayout = new javax.swing.GroupLayout(dadosAdversario);
        dadosAdversario.setLayout(dadosAdversarioLayout);
        dadosAdversarioLayout.setHorizontalGroup(
            dadosAdversarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosAdversarioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelImagemAdversario)
                .addGap(101, 101, 101)
                .addComponent(labelAnoCriaçãoTimeAdversario)
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dadosAdversarioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(dadosAdversarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelImgAdv, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelProxJogo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(dadosAdversarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNumRodada, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNomeClubeAdversario)
                    .addComponent(labelLocalConfronto))
                .addContainerGap())
        );
        dadosAdversarioLayout.setVerticalGroup(
            dadosAdversarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosAdversarioLayout.createSequentialGroup()
                .addGroup(dadosAdversarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosAdversarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelProxJogo))
                    .addGroup(dadosAdversarioLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(labelNumRodada)))
                .addGap(18, 18, 18)
                .addGroup(dadosAdversarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dadosAdversarioLayout.createSequentialGroup()
                        .addComponent(labelLocalConfronto)
                        .addGap(18, 18, 18)
                        .addComponent(labelNomeClubeAdversario)
                        .addGap(30, 30, 30)
                        .addComponent(labelAnoCriaçãoTimeAdversario))
                    .addComponent(labelImgAdv, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelImagemAdversario))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        labelNomeDoTime.setText("Nome do Time");

        labelNomeDoCampeonato.setText("Nome do Campeonato");

        labelNomeTecnico.setText("Nome do Treinador");

        labelNacionalidade.setText("Nacionalidade");

        javax.swing.GroupLayout dadosDoClubeLayout = new javax.swing.GroupLayout(dadosDoClube);
        dadosDoClube.setLayout(dadosDoClubeLayout);
        dadosDoClubeLayout.setHorizontalGroup(
            dadosDoClubeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dadosDoClubeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImagemClubeAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(dadosDoClubeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosDoClubeLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(labelNomeDoTime)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dadosDoClubeLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dadosDoClubeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNacionalidade)
                            .addComponent(labelNomeDoCampeonato)
                            .addComponent(labelNomeTecnico)))))
        );
        dadosDoClubeLayout.setVerticalGroup(
            dadosDoClubeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosDoClubeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosDoClubeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosDoClubeLayout.createSequentialGroup()
                        .addComponent(labelImagemClubeAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(dadosDoClubeLayout.createSequentialGroup()
                        .addComponent(labelNomeDoTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelNomeDoCampeonato)
                        .addGap(18, 18, 18)
                        .addComponent(labelNomeTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(labelNacionalidade))))
        );

        definirEscalacao.setText("Escalação");
        definirEscalacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                definirEscalacaoActionPerformed(evt);
            }
        });

        labelForcaAtaque.setText("Força Ataque");

        labelNomeJogador.setText("Nome Do Jogador");

        labelForcaDefesa.setText("Força Defesa");

        labelIdade.setText("Idade");

        labelPosicaoJogador.setText("Posicao");

        labelGols.setText("Gols");

        labelAssistencias.setText("Assistências");

        javax.swing.GroupLayout dadosJogadorSelecionadoLayout = new javax.swing.GroupLayout(dadosJogadorSelecionado);
        dadosJogadorSelecionado.setLayout(dadosJogadorSelecionadoLayout);
        dadosJogadorSelecionadoLayout.setHorizontalGroup(
            dadosJogadorSelecionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosJogadorSelecionadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosJogadorSelecionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosJogadorSelecionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(labelIdade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelForcaDefesa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelForcaAtaque, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(labelPosicaoJogador)
                    .addComponent(labelGols)
                    .addComponent(labelAssistencias)
                    .addComponent(labelNomeJogador))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        dadosJogadorSelecionadoLayout.setVerticalGroup(
            dadosJogadorSelecionadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosJogadorSelecionadoLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(labelNomeJogador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPosicaoJogador)
                .addGap(5, 5, 5)
                .addComponent(labelForcaAtaque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelForcaDefesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelIdade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelGols)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelAssistencias)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelaDeJogadoresDoClube.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Posicao", "Força Ataque", "Força Defesa", "Idade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaDeJogadoresDoClube.getTableHeader().setReorderingAllowed(false);
        tabelaDeJogadoresDoClube.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabelaDeJogadoresDoClubeFocusGained(evt);
            }
        });
        tabelaDeJogadoresDoClube.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabelaDeJogadoresDoClubeMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaDeJogadoresDoClube);

        verificarTabelaClassificacao.setText("Tabela");
        verificarTabelaClassificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarTabelaClassificacaoActionPerformed(evt);
            }
        });

        salvar.setText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(147, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dadosAdversario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(dadosJogadorSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67))
                            .addComponent(dadosDoClube, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(verificarTabelaClassificacao)
                        .addGap(74, 74, 74)
                        .addComponent(definirEscalacao)
                        .addGap(146, 146, 146)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(112, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salvar)
                        .addGap(366, 366, 366))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(dadosDoClube, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dadosAdversario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(definirEscalacao)
                            .addComponent(verificarTabelaClassificacao))
                        .addGap(18, 18, 18)
                        .addComponent(dadosJogadorSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(salvar)))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void definirEscalacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_definirEscalacaoActionPerformed
        EscalarTime escalarTime = new EscalarTime(tecnico, campeonato, this);
        escalarTime.setVisible(true);
        escalarTime.setModal(true);
        escalarTime.setTitle("Escalacao");
        //Removendo a ação padrão do botão 'X'
        escalarTime.setDefaultCloseOperation(escalarTime.DO_NOTHING_ON_CLOSE);
        escalarTime.definirPosicao(this.getSize());
       
    }//GEN-LAST:event_definirEscalacaoActionPerformed

    private void tabelaDeJogadoresDoClubeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabelaDeJogadoresDoClubeFocusGained
        
    }//GEN-LAST:event_tabelaDeJogadoresDoClubeFocusGained

    private void tabelaDeJogadoresDoClubeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDeJogadoresDoClubeMousePressed
        labelNomeJogador.setText(tecnico.getClube().getElenco().get(tabelaDeJogadoresDoClube.getSelectedRow()).getNome());
        labelIdade.setText("Idade "+tecnico.getClube().getElenco().get(tabelaDeJogadoresDoClube.getSelectedRow()).getIdade());
        labelForcaAtaque.setText("Ataque "+tecnico.getClube().getElenco().get(tabelaDeJogadoresDoClube.getSelectedRow()).getAtaque());
        labelForcaDefesa.setText("Defesa "+tecnico.getClube().getElenco().get(tabelaDeJogadoresDoClube.getSelectedRow()).getDefesa());
        labelPosicaoJogador.setText(tecnico.getClube().getElenco().get(tabelaDeJogadoresDoClube.getSelectedRow()).getPosicao());
        labelGols.setText("Gols "+tecnico.getClube().getElenco().get(tabelaDeJogadoresDoClube.getSelectedRow()).getGols());
        labelAssistencias.setText("Assistências "+tecnico.getClube().getElenco().get(tabelaDeJogadoresDoClube.getSelectedRow()).getAssistencias());
    }//GEN-LAST:event_tabelaDeJogadoresDoClubeMousePressed

    private void verificarTabelaClassificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarTabelaClassificacaoActionPerformed
        TabelaClassificacao classificacao = new TabelaClassificacao(this.campeonato);
        classificacao.setVisible(true);
        classificacao.setDefaultCloseOperation(classificacao.DO_NOTHING_ON_CLOSE);
        classificacao.setLocationRelativeTo(null);
        //classificacao.setSize(this.getSize());
    }//GEN-LAST:event_verificarTabelaClassificacaoActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
    try{
            Connection conexao = (Connection) DriverManager.getConnection("jdbc:sqlite:C:/Users/Public/Documents/Brasfoot 2.0/projeto_brasfoot.db");
            //Informa que o jogo foi salvo pelo meenos uma vez.
            String sql = "update primeiro_acesso set PRIMEIRO_ACESSO = '0';";
            PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            // Salva o nome e a nacionalidade do Técnico;
            String nome = tecnico.getNome();
            String nacionalidade = tecnico.getNacionalidade();
            int codigo = tecnico.getClube().getCodigo();
            int rodada = campeonato.getRodada();
            sql = "update tecnicos set nome = '"+nome+"', NACIONALIDADE = '"+nacionalidade+"', "
                    + "RODADA = '"+rodada+"', ESCOLHIDO = 1    "+
                        "	where ID_TECNICO = '"+codigo+"';";
            
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            
            int vist = 0;
            if(tecnico.getClube().isVisitante()){
                vist = 1;
            }else{
                vist = 0;
            }
            
            sql =  "update CLUBES set VISITANTE = '"+vist+"'"+
                    " where ID_TECNICO = (select ID_TECNICO from TECNICOS "+
                                                "where ESCOLHIDO = '1');+";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            
            // Salva a tabela de classificacao
            int cont = 0;
            if(campeonato.getClassificacao()== null){
                campeonato.atualizarTabela();
            }
            for (int i = 0; i < campeonato.getClassificacao().size(); i++) {
                cont = cont +1;
                String posicao = ""+cont;
                String pontos = ""+campeonato.getClassificacao().get(i).getPontuacao();
                String saldo = ""+campeonato.getClassificacao().get(i).getSaldoGols();
                String vitorias = ""+campeonato.getClassificacao().get(i).getNumVitorias();
                String empates = ""+campeonato.getClassificacao().get(i).getNumEmpates();
                String derrotas = ""+campeonato.getClassificacao().get(i).getNumDerrotas();
                String gp = ""+campeonato.getClassificacao().get(i).getGP();
                String gc = ""+campeonato.getClassificacao().get(i).getGC();
                
                sql = "update classificacao set POSICAO = '"+posicao+"', PONTUACAO = '"+pontos+"', VITORIAS = '"+vitorias+
                        "',EMPATES = '"+empates+"', DERROTAS = '"+derrotas+"', SALDO_GOLS = '"+saldo+"', GP = '"+gp+"', "
                            + "gc = '"+gc+
                                "' where ID_CLUBE = '"+campeonato.getClassificacao().get(i).getCodigo()+"'";
                comando = (PreparedStatement) conexao.prepareStatement(sql);
                comando.execute();
            }
            comando.close();
            JOptionPane.showMessageDialog(null, "Salvo progresso com sucesso!");    
            conexao.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_salvarActionPerformed
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dadosAdversario;
    private javax.swing.JPanel dadosDoClube;
    private javax.swing.JPanel dadosJogadorSelecionado;
    private javax.swing.JButton definirEscalacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAnoCriaçãoTimeAdversario;
    private javax.swing.JLabel labelAssistencias;
    private javax.swing.JLabel labelForcaAtaque;
    private javax.swing.JLabel labelForcaDefesa;
    private javax.swing.JLabel labelGols;
    private javax.swing.JLabel labelIdade;
    private javax.swing.JLabel labelImagemAdversario;
    private javax.swing.JLabel labelImagemClubeAtual;
    private javax.swing.JLabel labelImgAdv;
    private javax.swing.JLabel labelLocalConfronto;
    private javax.swing.JLabel labelNacionalidade;
    private javax.swing.JLabel labelNomeClubeAdversario;
    private javax.swing.JLabel labelNomeDoCampeonato;
    private javax.swing.JLabel labelNomeDoTime;
    private javax.swing.JLabel labelNomeJogador;
    private javax.swing.JLabel labelNomeTecnico;
    private javax.swing.JLabel labelNumRodada;
    private javax.swing.JLabel labelPosicaoJogador;
    private javax.swing.JLabel labelProxJogo;
    private javax.swing.JButton salvar;
    private javax.swing.JTable tabelaDeJogadoresDoClube;
    private javax.swing.JButton verificarTabelaClassificacao;
    // End of variables declaration//GEN-END:variables


    public javax.swing.JLabel getLabelNumRodada() {
        return labelNumRodada;
    }

    public javax.swing.JLabel getLabelNomeClubeAdversario() {
        return labelNomeClubeAdversario;
    }

    public javax.swing.JButton getDefinirEscalacao() {
        return definirEscalacao;
    }

    public javax.swing.JLabel getLabelAnoCriaçãoTimeAdversario() {
        return labelAnoCriaçãoTimeAdversario;
    }

    public javax.swing.JLabel getLabelImgAdv() {
        return labelImgAdv;
    }

    public javax.swing.JLabel getLabelImagemAdversario() {
        return labelImagemAdversario;
    }

    /**
     * @return the labelLocalConfronto
     */
    public javax.swing.JLabel getLabelLocalConfronto() {
        return labelLocalConfronto;
    }
}
