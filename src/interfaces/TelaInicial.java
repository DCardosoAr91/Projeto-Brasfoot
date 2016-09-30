
package interfaces;

import clube.Campeonato;
import clube.Inicializador;
import clube.Tecnico;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.File;
import java.sql.*;
import javax.swing.JOptionPane;
import som.PlaySound;

public class TelaInicial extends javax.swing.JFrame {

    private Campeonato campeonato;
    private PlaySound musicaFundo;
    public TelaInicial() throws ClassNotFoundException {
        initComponents();
        musicaFundo = new PlaySound();
        musicaFundo.playWavLoop(getClass().getResource("/som/abertura.wav"));
        criarDiretorio();
        verificaPrimeiroAcesso();
    }
    
    public void criarDiretorio() {
            try {
                new File("C:\\Users\\Public\\Documents\\Brasfoot 2.0").mkdir();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao criar o diretorio");
                System.out.println(ex);
            }
    }
    
    private void verificaPrimeiroAcesso() throws ClassNotFoundException{
        
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conexao = (Connection) DriverManager.getConnection("jdbc:sqlite:C:/Users/Public/Documents/Brasfoot 2.0/projeto_brasfoot.db");
            //Informa que o jogo foi salvo pelo meenos uma vez.
            
            String sql = "CREATE TABLE if not exists PRIMEIRO_ACESSO(\n" +
                    "    ID_PA INTEGER NOT NULL,\n" +
                    "    PRIMEIRO_ACESSO BOOLEAN NOT NULL,\n" +
                    "    PRIMARY KEY (ID_PA)\n" +
                    ");";
            PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            
            sql = "select count(*) as cont from primeiro_acesso;";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            ResultSet rs = comando.executeQuery();
            while(rs.next()){
                String primeiroAcesso = rs.getString("cont");
                if(primeiroAcesso.equals("0")){
                    sql = "INSERT INTO PRIMEIRO_ACESSO VALUES ('1', '1');";
                    comando = (PreparedStatement) conexao.prepareStatement(sql);
                    comando.execute();
                }
            }  
            sql = "select primeiro_acesso from primeiro_acesso\n" +
                            "	where ID_PA = 1;";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            rs = comando.executeQuery();
            System.out.println(""+rs.getString("primeiro_acesso"));
            while(rs.next()){
                String primeiroAcesso = rs.getString("primeiro_acesso");
                if(primeiroAcesso.equals("1")){
                    continuarJogo.setEnabled(false);
                }
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFrame3 = new javax.swing.JFrame();
        jDialog1 = new javax.swing.JDialog();
        novoJogo = new javax.swing.JButton();
        continuarJogo = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelImagemInicial = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        novoJogo.setText("Novo Jogo");
        novoJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoJogoActionPerformed(evt);
            }
        });

        continuarJogo.setText("Continuar Jogo");
        continuarJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarJogoActionPerformed(evt);
            }
        });

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        jLabel1.setText("Desenvolvido por Antoni Sganzerla");

        jLabel2.setText("Disciplina Algoritmos III");

        labelImagemInicial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/home.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(labelImagemInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(novoJogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(continuarJogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(107, Short.MAX_VALUE)
                        .addComponent(novoJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(continuarJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sair)
                        .addGap(79, 79, 79))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(labelImagemInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_sairActionPerformed

    private void continuarJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarJogoActionPerformed
        Inicializador iniciar = new Inicializador();
        this.campeonato = iniciar.pegarDadosBanco();
        this.campeonato.setMusicaDeFundo(musicaFundo);

        try{
            Connection conexao = (Connection) DriverManager.getConnection("jdbc:sqlite:C:/Users/Public/Documents/Brasfoot 2.0/projeto_brasfoot.db");
            String sql = "SELECT *FROM tecnicos	\n" +
                "	WHERE ESCOLHIDO = 1;";
            PreparedStatement comando = (PreparedStatement) conexao.prepareStatement(sql);
            ResultSet rs = comando.executeQuery(); 
            String nome = null;
            String nacionalidade = null;
            String visitante = null;
            int rodada = 0;
            int numClube = 0;
            while(rs.next()){
                nome = rs.getString("nome");
                nacionalidade = rs.getString("nacionalidade");
                rodada = Integer.parseInt(rs.getString("rodada"));
                numClube = Integer.parseInt(rs.getString("id_tecnico"));
            }
            Tecnico tecnico = new Tecnico();
            tecnico.setNome(nome);
            tecnico.setNacionalidade(nacionalidade);
            
            sql = "select VISITANTE from CLUBES\n" +
                "    where ID_TECNICO = (select ID_TECNICO from TECNICOS\n" +
                            "    where ESCOLHIDO = 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            rs = comando.executeQuery(); 
            
            visitante = rs.getString("visitante");
            if(visitante.equals("1")){
                campeonato.getListaDeClubes().get(numClube -1).setVisitante(true);
            }else{
                campeonato.getListaDeClubes().get(numClube -1).setVisitante(false);
            }
            tecnico.setClube(campeonato.getListaDeClubes().get(numClube -1));
            campeonato.setRodada(rodada);
            
            sql = "select *from classificacao;";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            rs = comando.executeQuery(); 
            int cont = 0;
            while(rs.next()){
                int pontuacao = Integer.parseInt(rs.getString("pontuacao"));
                int vitorias = Integer.parseInt(rs.getString("vitorias"));
                int empates = Integer.parseInt(rs.getString("empates"));
                int derrotas = Integer.parseInt(rs.getString("derrotas"));
                int saldoGols = Integer.parseInt(rs.getString("saldo_gols"));
                int gp = Integer.parseInt(rs.getString("gp"));
                int gc = Integer.parseInt(rs.getString("gc"));
                campeonato.getListaDeClubes().get(cont).setPontuacao(pontuacao);
                campeonato.getListaDeClubes().get(cont).setNumVitorias(vitorias);
                campeonato.getListaDeClubes().get(cont).setNumEmpates(empates);
                campeonato.getListaDeClubes().get(cont).setNumDerrotas(derrotas);
                campeonato.getListaDeClubes().get(cont).setSaldoGols(saldoGols);
                campeonato.getListaDeClubes().get(cont).setGP(gp);
                campeonato.getListaDeClubes().get(cont).setGC(gc);
                cont = cont +1;
            }
            GerenciarClube gerenciar = new GerenciarClube(campeonato,tecnico);
            gerenciar.setVisible(true);
            gerenciar.setExtendedState(MAXIMIZED_BOTH);
            this.setVisible(false);
            gerenciar.setTitle("Brasfoot APIII");
            comando.close();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Seus dados foram carregados com sucesso."); 
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_continuarJogoActionPerformed

    private void novoJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoJogoActionPerformed

        try{
            Connection conexao = (Connection) DriverManager.getConnection("jdbc:sqlite:C:/Users/Public/Documents/Brasfoot 2.0/projeto_brasfoot.db");
            
            // Apaga os registros do banco
            String sql = "";
            PreparedStatement comando = null;
            sql = "drop table if exists jogadores;";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "drop table if exists classificacao;";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "drop table if exists clubes;";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "drop table if exists tecnicos;";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            
            // recria os dados iniciais do banco
            sql = "CREATE TABLE TECNICOS(\n" +
                "    ID_TECNICO INTEGER NOT NULL,\n" +
                "    NOME VARCHAR(45) NOT NULL,\n" +
                "    NACIONALIDADE VARCHAR(45) NOT NULL,\n" +
                "    RODADA INTEGER NOT NULL,\n" +
                "    ESCOLHIDO BOOLEAN NOT NULL,\n" +
                "    PRIMARY KEY (ID_TECNICO)\n" +
                ");";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "INSERT INTO TECNICOS VALUES\n"
                + "('1', 'Roger', 'Alemão', '1','0');";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "INSERT INTO TECNICOS VALUES\n"
                + "('2', 'Tite', 'Brasileiro', '1','0');";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "INSERT INTO TECNICOS VALUES\n"
                + "('3', 'Muricy Baralho', 'Coreano', '1', '0');";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "INSERT INTO TECNICOS VALUES\n"
                + "('4', 'Cuca', 'Argelino', '1', '0');";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            
            sql = "CREATE TABLE CLUBES(\n" +
                "    ID_CLUBE INTEGER NOT NULL,\n" +
                "    ID_TECNICO INTEGER,\n" +
                "    NOME VARCHAR(45) NOT NULL,\n" +
                "    PONTUACAO INTEGER NOT NULL,\n" +
                "    VITORIAS INTEGER NOT NULL,\n" +
                "    EMPATES INTEGER NOT NULL,\n" +
                "    DERROTAS INTEGER NOT NULL,    \n" +
                "    SALDO_GOLS INTEGER NOT NULL,\n" +
                "    GP INTEGER NOT NULL,\n" +
                "    GC INTEGER NOT NULL,\n" +
                "    VISITANTE BOOLEAN NOT NULL,"+
                "					\n" +
                "    PRIMARY KEY (ID_CLUBE),\n" +
                "    FOREIGN KEY (ID_TECNICO) REFERENCES TECNICOS(ID_TECNICO)\n" +
                ");";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            
            sql = "insert into clubes values\n" +
                "('1','1','Lajeandense','0','0','0','0','0','0','0','0');";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into clubes values\n" +
                "('2','2','Aimore','0','0','0','0','0','0','0','1');";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into clubes values\n" +
                "('3','3','Caxias','0','0','0','0','0','0','0','0');";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into clubes values\n" +
                "('4','4','Passo Fundo','0','0','0','0','0','0','0','1');";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            
            sql = "CREATE TABLE JOGADORES(\n" +
                "    ID_JOGADOR INTEGER NOT NULL,\n" +
                "    ID_CLUBE INTEGER NOT NULL,\n" +
                "    NOME VARCHAR(45) NOT NULL,\n" +
                "    POSICAO VARCHAR(45) NOT NULL,\n" +
                "    ATAQUE INTEGER NOT NULL,\n" +
                "    DEFESA INTEGER NOT NULL,\n" +
                "    IDADE INTEGER NOT NULL,\n" +
                "    TITULAR BOOLEAN NOT NULL,\n" +
                "		\n" +
                "    PRIMARY KEY (ID_JOGADOR),\n" +
                "    FOREIGN KEY(ID_CLUBE) REFERENCES CLUBES (ID_CLUBE)\n" +
                ");";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('1','1','Lauro', 'Goleiro', 18, 71, 35, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('2','1','Rodrigo Cardoso', 'Lateral Esquerdo', 55, 63, 26, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('3','1','Leo', 'Lateral Direito', 57, 65, 20, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('4','1','Rodrigo Vareta', 'Zagueiro', 30, 61, 25, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('5','1','Edson Borges', 'Zagueiro', 28, 60, 31, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('6','1','Du', 'Meia', 68, 55, 26, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('7','1','Maurinho', 'Meia', 66, 53, 32, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('8','1','Erik', 'Meia', 69, 58, 21, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('9','1','Alan', 'Meia', 68, 60, 32, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('10','1','Giovani', 'Atacante', 74, 27, 24, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('11','1','Murilo', 'Atacante', 73, 29, 21, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('12','1','Paulo', 'Goleiro', 9, 64, 28, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('13','1','Diego Hoffman', 'Lateral Direito', 49, 51, 23, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('14','1','Gabriel', 'Zagueiro', 18, 48, 34, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('15','1','Mateus', 'Meia', 57, 40, 28, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('16','1','Maraba', 'Meia', 54, 38, 29, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('17','1','Diego Miranda', 'Atacante', 66, 25, 31, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('18','2','Alessandro', 'Goleiro', 17, 68, 27, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('19','2','Mateus', 'Lateral Direito', 52, 63, 23, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('20','2','Joao Henrique', 'Lateral Direito', 50, 61, 20, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();  
            sql = "insert into jogadores values\n" +
            "('21','2','Cesar Lucena', 'Zagueiro', 29, 67, 35, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('22','2','Diego Rocha', 'Zagueiro', 33, 66, 24, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('23','2','Talysson', 'Meia', 71, 40, 24, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('24','2','Danilo Goiano', 'Meia', 67, 45, 33, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('25','2','Joazinho', 'Meia', 66, 42, 20, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('26','2','Tiago Alemao', 'Meia', 64, 38, 25, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('27','2','Lucas Kattah', 'Atacante', 68, 33, 21, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('28','2','Elias', 'Atacante', 73, 44, 22, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('29','2','Mikael', 'Goleiro', 11, 63, 19, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('30','2','Donato', 'Lateral Esquerdo', 48, 65, 22, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('31','2','Diego Superti', 'Zagueiro', 39, 57, 25, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('32','2','Bruno Araujo', 'Meia', 61, 55, 24, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('33','2','Moacir', 'Meia', 63, 57, 22, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('34','2','Igor Nobre', 'Atacante', 75, 60, 25, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('35','3','Marcelo Pitol', 'Goleiro', 15, 69, 33, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('36','3','Veloso', 'Lateral Direito', 54, 64, 30, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('37','3','Fabinho', 'Lateral Esquerdo', 50, 51, 32, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('38','3','Bronzatti', 'Zagueiro', 28, 68, 29, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('39','3','Lacerda', 'Zagueiro', 25, 53, 31, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('40','3','Glauber', 'Meia', 63, 55, 34, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('41','3','Raone', 'Meia', 57, 59, 34, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('42','3','Rafael Dutra', 'Meia', 68, 60, 32, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('43','3','Tallys', 'Meia', 63, 54, 28, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('44','3','Sato', 'Atacante', 71, 55, 26, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('45','3','Mailson', 'Atacante', 78, 50, 25, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('46','3','Hugo', 'Goleiro', 7, 55, 25, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('47','3','Lipe', 'Lateral Esquerdo', 57, 30, 26, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('48','3','Breno', 'Zagueiro', 19, 69, 29, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('49','3','Dinei', 'Meia', 60, 54, 32, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('50','3','Ramos', 'Meia', 61, 60, 32, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('51','3','Clebinho', 'Atacante', 69, 61, 29, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('52','4','Matheus', 'Goleiro', 20, 71, 29, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('53','4','Alisson Gaucho', 'Lateral Direito', 65, 70, 23, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('54','4','Thiago Machado', 'Lateral Esquerdo', 55, 61, 31, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('55','4','Gustavo Jose', 'Zagueiro', 44, 72, 27, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('56','4','Leo Kanu', 'Zagueiro', 53, 69, 28, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('57','4','Renan Oliveira', 'Meia', 69, 44, 33,  1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('58','4','Branquinho', 'Meia', 72, 55, 26, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('59','4','Rudieiro', 'Meia', 60, 80, 28, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('60','4','Nata', 'Meia', 61, 50, 30, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('61','4','Hyantony', 'Atacante', 88, 87, 31, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('62','4','Jean Silva', 'Atacante', 61, 57, 26, 1);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('63','4','Guilherme', 'Goleiro', 10, 59, 24, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('64','4','Brida', 'Lateral Direito', 67, 44, 31, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('65','4','Marcio Nunes', 'Zagueiro', 58, 68, 35, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('66','4','Amaral', 'Meia', 53, 73, 32, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('67','4','Leandro Capiroto', 'Meia', 66, 66, 66, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into jogadores values\n" +
            "('68','4','Dudu Mandai', 'Atacante', 69, 53, 23, 0);";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            
            
            sql = "CREATE TABLE CLASSIFICACAO(\n" +
                "    ID_CLASSIFICACAO INTEGER NOT NULL,\n" +
                "    ID_CLUBE INTEGER NOT NULL,\n" +
                "    POSICAO VARCHAR(5) NOT NULL, \n" +
                "    PONTUACAO INTEGER NOT NULL,\n" +
                "    VITORIAS INTEGER NOT NULL,\n" +
                "    EMPATES INTEGER NOT NULL,\n" +
                "    DERROTAS INTEGER NOT NULL,\n" +
                "    SALDO_GOLS INTEGER NOT NULL,\n" +
                "    GP INTEGER NOT NULL,\n" +
                "    GC INTEGER NOT NULL,\n" +
                "	\n" +
                "    PRIMARY KEY (ID_CLASSIFICACAO),\n" +
                "    FOREIGN KEY(ID_CLUBE) REFERENCES CLUBES (ID_CLUBE)\n" +
                ");";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into classificacao values\n" +
                    "('1','1','1','0','0','0','0','0','0','0');";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into classificacao values\n" +
                    "('2','2','2','0','0','0','0','0','0','0');";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into classificacao values\n" +
                    "('3','3','3','0','0','0','0','0','0','0');";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            sql = "insert into classificacao values\n" +
                    "('4','4','4','0','0','0','0','0','0','0');";
            comando = (PreparedStatement) conexao.prepareStatement(sql);
            comando.execute();
            
            comando.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        Inicializador iniciar = new Inicializador();
        this.campeonato = iniciar.pegarDadosBanco();
        this.campeonato.setMusicaDeFundo(musicaFundo);
        SelecaoDoTime selecao = new SelecaoDoTime(campeonato);
        selecao.setVisible(true);
        selecao.setLocationRelativeTo(null);
        this.setVisible(false);
        selecao.setTitle("Brasfoot APIII");
    }//GEN-LAST:event_novoJogoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continuarJogo;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelImagemInicial;
    private javax.swing.JButton novoJogo;
    private javax.swing.JButton sair;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the campeonato
     */
    public Campeonato getCampeonato() {
        return campeonato;
    }

    /**
     * @param campeonato the campeonato to set
     */
    public void setCampeonato(Campeonato campeonato) {
        this.campeonato = campeonato;
    }
}
