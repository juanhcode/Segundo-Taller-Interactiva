package galeria;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.*;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Galeria_imagenesController implements Initializable {

    private int contador = 0;
    private Label labelimagen;
    private final Image imagenes[] = new Image[6];
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
    @FXML
    private MenuItem botonIniciarCancion;
    @FXML
    private MenuItem botonPausarCancion;
    @FXML
    private MenuItem botonSalir;

    private Audio audio = new Audio();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (int i = 0; i < 6; i++) {
            imagenes[i] = new Image("/imagenes/a" + i + ".jpg");
        }
        campoImagen.setImage(imagenes[0]);
        campoLabel.setText("a" + 0 + ".jpg");
    }

    @FXML
    private void Anterior() {
        if (contador == 0) {
            contador = 1;
            botonAnterior.setDisable(true);  
        } else {
            botonSiguiente.setDisable(false); 
            contador--;
            campoImagen.setImage(imagenes[contador]);
            campoLabel.setText("a" + contador + ".jpg");
        }
    }

    @FXML
    private void siguiente() {
        if (contador == 5) {
            contador = 6;
            botonSiguiente.setDisable(true); 
        } else {
            botonAnterior.setDisable(false);
            contador++;
            campoImagen.setImage(imagenes[contador]);
            campoLabel.setText("a" + contador + ".jpg");
        }
    }

    @FXML
    private void volverPrimeraImagen() {
        contador = 0;
        int primerImagen = 0;
        botonAnterior.setDisable(true);
        botonSiguiente.setDisable(false);
        campoImagen.setImage(imagenes[primerImagen]);
        campoLabel.setText("a" + 0 + ".jpg");
    }

    @FXML
    private void irUltimaImagen() {
        contador = 5;
        int ultimaImagen = 5;
        botonSiguiente.setDisable(true);
        botonAnterior.setDisable(false);
        campoImagen.setImage(imagenes[ultimaImagen]);
        campoLabel.setText("a" + ultimaImagen + ".jpg");
    }

    @FXML
    private void iniciarCancion() {
        audio.iniciarCancion();
    }

    @FXML
    private void PausarCancion() {
        audio.pausarCancion();
    }

    @FXML
    private void salir() {
        System.exit(0);
        
    }

    @FXML
    private void mostrarIntegrantes(ActionEvent event) {
        JOptionPane ventana = new JOptionPane();
        ventana.showMessageDialog(null, "Juan Manuel Hoyos Contreras" + "\n"
                + "Sebastian Cifuentes Florez" + "\n"
                + "Emanuel Benjumea Bejarano", "Quienes somos", JOptionPane.INFORMATION_MESSAGE);
    }

}
