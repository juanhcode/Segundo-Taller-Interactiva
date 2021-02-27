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
    @FXML
    private Button botonFicha5;
    @FXML
    private Button botonFicha10;
    @FXML
    private Button botonFicha25;
    @FXML
    private Button botonFicha50;
    @FXML
    private Button botonFicha100;

    private Ficha ficha = new Ficha();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        campoEfectivo.setText(ficha.getEfectivo() + "");
        campoApuesta.setText(0 + "");
    }

    @FXML
    private void salirDelJuego() {
        System.exit(0);
    }

    @FXML
    private void mostrarIntegrantes() {
        JOptionPane ventana = new JOptionPane();
        ventana.showMessageDialog(null, "Juan Manuel Hoyos Contreras" + "\n"
                + "Sebastian Cifuentes Florez" + "\n"
                + "Emanuel Benjumea Bejarano", "Quienes somos", JOptionPane.INFORMATION_MESSAGE);

    }

    @FXML
    private void Repartir() {
    }

    @FXML
    private void otraCarta() {
    }

    @FXML
    private void seguro() {
    }

    @FXML
    private void otroJuego() {
    }

    @FXML
    private void obtenerValor1() {
        int texto = Integer.parseInt(campoApuesta.getText());
        int suma = ficha.getFicha1() + texto;
        campoApuesta.setText(suma + "");

        //PRUEBA
        int quitarDinero = ficha.getEfectivo() - suma;
        campoEfectivo.setText(quitarDinero + "");
    }

    @FXML
    private void obtenerValor5() {
        int texto = Integer.parseInt(campoApuesta.getText());
        int suma = ficha.getFicha5() + texto;
        campoApuesta.setText(suma + "");
        int quitarDinero = ficha.getEfectivo() - suma;
        campoEfectivo.setText(quitarDinero + "");
    }

    @FXML
    private void obtenerValor10() {
        int texto = Integer.parseInt(campoApuesta.getText());
        int suma = ficha.getFicha10() + texto;
        campoApuesta.setText(suma + "");
        int quitarDinero = ficha.getEfectivo() - suma;
        campoEfectivo.setText(quitarDinero + "");

    }

    @FXML
    private void obtenerValor25() {
        int texto = Integer.parseInt(campoApuesta.getText());
        int suma = ficha.getFicha25() + texto;
        campoApuesta.setText(suma + "");
        int quitarDinero = ficha.getEfectivo() - suma;
        campoEfectivo.setText(quitarDinero + "");
    }

    @FXML
    private void obtenerValor50() {
        int texto = Integer.parseInt(campoApuesta.getText());
        int suma = ficha.getFicha50() + texto;
        campoApuesta.setText(suma + "");
        int quitarDinero = ficha.getEfectivo() - suma;
        campoEfectivo.setText(quitarDinero + "");
    }

    @FXML
    private void obtenerValor100() {
        int texto = Integer.parseInt(campoApuesta.getText());
        int suma = ficha.getFicha100() + texto;
        campoApuesta.setText(suma + "");
        int quitarDinero = ficha.getEfectivo() - suma;
        campoEfectivo.setText(quitarDinero + "");
    }

}
