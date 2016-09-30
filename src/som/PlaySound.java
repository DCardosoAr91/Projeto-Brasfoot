/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package som;

import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author anton
 */
public class PlaySound {
    
    private Clip clip;
    /*
    public void playSound(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            clip = AudioSystem.getClip();
            getClip().open(audioInputStream);
            getClip().loop(0);
        } catch (Exception ex) {
            System.out.println("Erro ao executar SOM!");
            ex.printStackTrace();
        }
    }
    */
    public void playWavLoop(URL wav) {
        try {
          AudioInputStream audioIn = AudioSystem.getAudioInputStream(wav);
          clip = AudioSystem.getClip();
          clip.open(audioIn);
          clip.start();
          //clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception ex) {
          ex.printStackTrace();
        }
    }

    public Clip getClip() {
        return clip;
    }
}
