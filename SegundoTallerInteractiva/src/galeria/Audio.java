package galeria;
import java.applet.AudioClip;
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
