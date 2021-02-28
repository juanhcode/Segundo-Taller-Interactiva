/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galeria;

import java.applet.AudioClip;

/**
 *
 * @author Usuario
 */
public class Audio {
    private String ruta = "/galeria/Cancion.wav";
    private AudioClip sound;
    
    public Audio(){
        
    }
    
    public void iniciarCancion(){
        sound = java.applet.Applet.newAudioClip(getClass().getResource(ruta));
        sound.play();
    }
    
    
    public void pausarCancion(){
        sound.stop();
        
    }
}
