/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galeria;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.*;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Galeria_imagenesController implements Initializable {

    private int contador = 0;
    private Label labelimagen;
    private Image imagenes[] = new Image[6];
    @FXML
    private ImageView campoImagen;
    @FXML
    private Button botonAnterior;
    @FXML
    private Button botonSiguiente;
    @FXML
    private Label campoLabel;
    @FXML
    private Button botonVolverPrimera;
    @FXML
    private Button botonUltimaImagen;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (int i = 0; i < 6; i++) {
            imagenes[i] = new Image("/imagenes/a" + i + ".jpg");
        }
        campoImagen.setImage(imagenes[0]);
    }

    @FXML
    private void Anterior() {

        if (contador == 6) {
            contador = 0;
        } else {
            contador--;
            campoImagen.setImage(imagenes[contador]);
        }

    }

    @FXML
    private void siguiente() {
        if (contador == 6) {
            campoImagen.setImage(imagenes[6]);
        } else {
            contador++;
            campoImagen.setImage(imagenes[contador]);
        }

    }
    //4 ERRORES
    //VOY A ULTIMA IMAGEN Y NO ME DEJA PRESIONAR ANTERIOR
    //VOY A PRIMERA IMAGEN Y NO ME DEJA PRESIONAR SIGUIENTE
    //CUANDO VOY A LA ULTIMA Y LE DOY SIGUIENTE SALE ERROR
    //CUANDO VOY A LA PRIMERA Y LE DOY ANTERIOR SALE ERROR

    
    @FXML
    private void volverPrimeraImagen() {
        int primerImagen = 0;
        campoImagen.setImage(imagenes[primerImagen]);
        siguiente();
    }

    @FXML
    private void irUltimaImagen() {
        int ultimaImagen = 5;
        campoImagen.setImage(imagenes[ultimaImagen]);
        Anterior();
        
        
    }

}
