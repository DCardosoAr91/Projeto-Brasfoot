/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clube;

import java.util.ArrayList;


public class Rodada {
    
    private ArrayList<Clube> clubes;
 
    public Rodada(Clube c1, Clube c2, Clube c3, Clube c4){
        clubes = new ArrayList<Clube>();
        clubes.add(c1);
        clubes.add(c2);
        clubes.add(c3);
        clubes.add(c4);
    }


    public ArrayList<Clube> getClubes() {
        return clubes;
    }
    
}
