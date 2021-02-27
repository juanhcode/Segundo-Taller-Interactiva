/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galeria;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Galeria_imagenesController implements Initializable {

    @FXML
    private Button bottonUltimaIgen;
    @FXML
    private Button btAnteriorImg;
    @FXML
    private Button btsgteImagen;
    @FXML
    private Button botonPrimeraimagen;

    @FXML
    private ImageView imagen;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void clickUltimaimagen(ActionEvent event) {
        Image image = new Image("/imagenes/a8.jpg");
        imagen.setImage(image);

    }

    @FXML
    private void clickAnteriorimagen(ActionEvent event) {
    }

    @FXML
    private void clicksiguenteimagen(ActionEvent event) {

        
            
        Image imagen1 = new Image("/imagenes/a1.jpg");
        Image imagen2 = new Image("/imagenes/a2.jpg");
        Image imagen3 = new Image("/imagenes/a3.jpg");
        Image imagen4 = new Image("/imagenes/a4.jpg");
        Image imagen5 = new Image("/imagenes/a5.jpg");
        Image imagen6 = new Image("/imagenes/a6.jpg");
        Image imagen7 = new Image("/imagenes/a7.jpg");
        Image imagen8 = new Image("/imagenes/a8.jpg");

        ArrayList<Image> listaImagenes = new ArrayList<Image>();
    
        listaImagenes.add(imagen1);
        listaImagenes.add(imagen2);
        listaImagenes.add(imagen3);
        listaImagenes.add(imagen4);
        listaImagenes.add(imagen5);
        listaImagenes.add(imagen6);
        listaImagenes.add(imagen7);
        listaImagenes.add(imagen8);
        
        
        for (Image listaImagene : listaImagenes) {
            imagen.setImage(listaImagene);
            
        }
        
        
    }

    @FXML
    private void clickPrimeraimagen(ActionEvent event) {
        Image image = new Image("/imagenes/a1.jpg");

        imagen.setImage(image);
    }

    @FXML
    private void mostrarIntegrantes(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Emanuel Benjumea Bejarano" + "\n"
                + "Sebastian Cifuentes Florez" + "\n"
                + "Juan Manuel Hoyos Contreras");

    }

}
