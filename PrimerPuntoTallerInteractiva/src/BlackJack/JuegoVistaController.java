/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class JuegoVistaController implements Initializable {

    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem mostrarIntegrantes;
    @FXML
    private TextField campoEfectivo;
    @FXML
    private TextField campoApuesta;
    @FXML
    private TextField campoPuntajeJugador;
    @FXML
    private TextField campoPuntajeCupier;
    @FXML
    private Button botonRepartir;
    @FXML
    private Button botonOtraCarta;
    @FXML
    private Button botonSeguro;
    @FXML
    private Button botonOtroJuego;
    
    //FICHAS
    @FXML
    private Button botonFicha1;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void salirDelJuego(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void mostrarIntegrantes(ActionEvent event) {
        JOptionPane ventana = new JOptionPane();
        ventana.showMessageDialog(null,"Juan Manuel Hoyos Contreras" + "\n"
                + "Sebastian Cifuentes Florez" + "\n"
                + "Emanuel Benjumea Bejarano", "Quienes somos", JOptionPane.INFORMATION_MESSAGE);

    }
    

    @FXML
    private void Repartir(ActionEvent event) {
    }

    @FXML
    private void otraCarta(ActionEvent event) {
    }

    @FXML
    private void seguro(ActionEvent event) {
    }

    @FXML
    private void otroJuego(ActionEvent event) {
    }

    @FXML
    private void imprimir(ActionEvent event) {
        System.out.println("Hola perras");
    }

}
