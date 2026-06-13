/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PR_RECURSOS;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author pikar
 */
public class Sonidos {
    
    private Clip clip;

    public void reproducir(String ruta) {
        try {
            detener();

            AudioInputStream audio = AudioSystem.getAudioInputStream(
                getClass().getClassLoader().getResource(ruta)
            );

            clip = AudioSystem.getClip();
            clip.open(audio);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (Exception e) {
            System.out.println("Error al reproducir música: " + e.getMessage());
}
    }

    public void detener() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
