
package clube;

import java.awt.Dimension;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Inicializador {
    
        private Clube lajeandese;
        private Clube aimore;
        private Clube caxias;
        private Clube passoFundo;
        Campeonato campeonato = new Campeonato();
        
        public Inicializador(){
            lajeandese = new Clube("Lajeadense", new ArrayList<Jogador>(), new ArrayList<Jogador>(),"1911");
            lajeandese.setCodigo(1);
            lajeandese.getImagemClube().setIcon(new ImageIcon(getClass().getResource("/imagens/lajeadense.jpg")));
            aimore = new Clube("Aimore", new ArrayList<Jogador>(), new ArrayList<Jogador>(),"1936");
            aimore.setCodigo(2);
            aimore.getImagemClube().setIcon(new ImageIcon(getClass().getResource("/imagens/aimore.png")));
            caxias = new Clube("Caxias", new ArrayList<Jogador>(), new ArrayList<Jogador>(),"1935");
            caxias.getImagemClube().setIcon(new ImageIcon(getClass().getResource("/imagens/caxias.png")));
            caxias.setCodigo(3);
            passoFundo = new Clube("Passo Fundo", new ArrayList<Jogador>(), new ArrayList<Jogador>(),"1986");
            passoFundo.setCodigo(4);
            passoFundo.getImagemClube().setIcon(new ImageIcon(getClass().getResource("/imagens/passo fundo.png")));
            campeonato.getListaDeClubes().add(lajeandese);
            campeonato.getListaDeClubes().add(aimore);
            campeonato.getListaDeClubes().add(caxias);
            campeonato.getListaDeClubes().add(passoFundo);
            campeonato.definirTabelaDeJogos();
        }
        
        public Campeonato pegarDadosBanco(){
        
        try{
            Connection conexao = (Connection) DriverManager.getConnection("jdbc:sqlite:C:/Users/Public/Documents/Brasfoot 2.0/projeto_brasfoot.db");
            PreparedStatement comando = null;
            
            for (int i = 1; i < 5; i++) {
                String sql= "select *from jogadores\n" +
                        "	where ID_CLUBE = "+i+";";
                comando = (PreparedStatement) conexao.prepareStatement(sql);
                ResultSet rs = comando.executeQuery();
                while (rs.next()) {
                    String nome = rs.getString("nome");
                    String posicao = rs.getString("posicao");
                    String ataque = rs.getString("ataque");
                    String defesa = rs.getString("defesa");
                    String idade = rs.getString("idade");
                    String titular = rs.getString("titular");
                    switch(i){
                        case 1:{
                            if(titular.equals("1")){
                                lajeandese.getTitulares().add(new Jogador(nome, posicao, Integer.parseInt(ataque),
                                        Integer.parseInt(defesa), Integer.parseInt(idade)));
                            }else{
                                lajeandese.getReservas().add(new Jogador(nome, posicao, Integer.parseInt(ataque),
                                        Integer.parseInt(defesa), Integer.parseInt(idade)));
                            }
                            break;
                        }
                        case 2:{
                            if(titular.equals("1")){
                                aimore.getTitulares().add(new Jogador(nome, posicao, Integer.parseInt(ataque),
                                        Integer.parseInt(defesa), Integer.parseInt(idade)));
                            }else{
                                aimore.getReservas().add(new Jogador(nome, posicao, Integer.parseInt(ataque),
                                        Integer.parseInt(defesa), Integer.parseInt(idade)));
                            }
                            break;
                        }
                        case 3:{
                            if(titular.equals("1")){
                                caxias.getTitulares().add(new Jogador(nome, posicao, Integer.parseInt(ataque),
                                        Integer.parseInt(defesa), Integer.parseInt(idade)));
                            }else{
                                caxias.getReservas().add(new Jogador(nome, posicao, Integer.parseInt(ataque),
                                        Integer.parseInt(defesa), Integer.parseInt(idade)));
                            }
                            break;
                        }
                        case 4:{
                            if(titular.equals("1")){
                                passoFundo.getTitulares().add(new Jogador(nome, posicao, Integer.parseInt(ataque),
                                        Integer.parseInt(defesa), Integer.parseInt(idade)));
                            }else{
                                passoFundo.getReservas().add(new Jogador(nome, posicao, Integer.parseInt(ataque),
                                        Integer.parseInt(defesa), Integer.parseInt(idade)));
                            }
                            break;
                        }
                    }
                }   
            }
            lajeandese.gerarElenco();
            aimore.gerarElenco();
            caxias.gerarElenco();
            passoFundo.gerarElenco();
            comando.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return campeonato;
    }  
}
