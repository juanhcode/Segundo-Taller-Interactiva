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

    private Audio audio = new Audio();

    @FXML
    private MenuItem botonSalir;

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

    @FXML
    private void volverPrimeraImagen() {
        int primerImagen = 0;
        campoImagen.setImage(imagenes[primerImagen]);

    }

    @FXML
    private void irUltimaImagen() {
        int ultimaImagen = 5;
        campoImagen.setImage(imagenes[ultimaImagen]);

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
