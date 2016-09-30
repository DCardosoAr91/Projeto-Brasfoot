
package main;

import interfaces.TelaInicial;
import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) throws ClassNotFoundException {
        
        JFrame janela = new TelaInicial();
        janela.setVisible(true);
        janela.setLocationRelativeTo(null);
        janela.setTitle("Brasfoot APIII");      
    }   
}
