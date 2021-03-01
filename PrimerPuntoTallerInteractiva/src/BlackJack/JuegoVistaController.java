/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private int resultado;
    @FXML
    private ImageView campoImagenCupier;

    private PaqueteDeCartas paquete;

    @FXML
    private ImageView campoImagenJugador;
    @FXML
    private ImageView campoJugador3;
    @FXML
    private ImageView campoJugador2;
    
    //RUTA CARTAS al Azar
    
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        campoEfectivo.setText(ficha.getEfectivo() + "");
        campoApuesta.setText(0 + "");
        botonRepartir.setDisable(true);
        botonOtraCarta.setDisable(true);
        botonSeguro.setDisable(true);
        campoPuntajeJugador.setText(0 + "");
        campoPuntajeCupier.setText(0 + "");
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
        botonFicha1.setDisable(true);
        botonFicha5.setDisable(true);
        botonFicha10.setDisable(true);
        botonFicha25.setDisable(true);
        botonFicha50.setDisable(true);
        botonFicha100.setDisable(true);
        
        String cara = "/Imagenes Cartas/"+obtenerLetra();
        String cara2 = "/Imagenes Cartas/"+obtenerLetra();
        String cara3 = "/Imagenes Cartas/"+obtenerLetra();
        Image imagen1 = new Image(cara);
        Image imagen2 = new Image(cara2);
        Image imagen3 = new Image(cara3);
        campoImagenJugador.setImage(imagen1);
        campoJugador2.setImage(imagen2);
        campoJugador3.setImage(imagen3);
        
        
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

    private int quitarDinero(Ficha f, int suma) {
        int resultado = f.getEfectivo() - suma;
        return resultado;
    }

    @FXML
    private void obtenerValor1() {
        botonRepartir.setDisable(false);
        int conver = Integer.parseInt(campoEfectivo.getText());
        int texto = Integer.parseInt(campoApuesta.getText());
        int suma = ficha.getFicha1() + texto;
        if (conver > 0) {
            campoApuesta.setText(suma + "");
            resultado = quitarDinero(ficha, suma);
            campoEfectivo.setText(resultado + "");
        } else {
            campoEfectivo.setText("0");
            JOptionPane.showMessageDialog(null, "No puede Apostar mas", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void obtenerValor5() {
        botonRepartir.setDisable(false);
        int conver = Integer.parseInt(campoEfectivo.getText());
        int texto = Integer.parseInt(campoApuesta.getText());
        int suma = ficha.getFicha5() + texto;
        if (conver > 0) {
            campoApuesta.setText(suma + "");
            resultado = quitarDinero(ficha, suma);
            campoEfectivo.setText(resultado + "");
        } else {
            campoEfectivo.setText("0");
            JOptionPane.showMessageDialog(null, "No puede Apostar mas", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void obtenerValor10() {
        botonRepartir.setDisable(false);
        int conver = Integer.parseInt(campoEfectivo.getText());
        int texto = Integer.parseInt(campoApuesta.getText());
        int suma = ficha.getFicha10() + texto;
        if (conver > 0) {
            campoApuesta.setText(suma + "");
            resultado = quitarDinero(ficha, suma);
            campoEfectivo.setText(resultado + "");
        } else {
            campoEfectivo.setText("0");
            JOptionPane.showMessageDialog(null, "No puede Apostar mas", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void obtenerValor25() {
        botonRepartir.setDisable(false);
        int conver = Integer.parseInt(campoEfectivo.getText());
        int texto = Integer.parseInt(campoApuesta.getText());
        int suma = ficha.getFicha25() + texto;
        if (conver > 0) {
            campoApuesta.setText(suma + "");
            resultado = quitarDinero(ficha, suma);
            campoEfectivo.setText(resultado + "");
        } else {
            campoEfectivo.setText("0");
            JOptionPane.showMessageDialog(null, "No puede Apostar mas", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void obtenerValor50() {
        botonRepartir.setDisable(false);
        int conver = Integer.parseInt(campoEfectivo.getText());
        int texto = Integer.parseInt(campoApuesta.getText());
        int suma = ficha.getFicha50() + texto;
        if (conver > 0) {
            campoApuesta.setText(suma + "");
            resultado = quitarDinero(ficha, suma);
            campoEfectivo.setText(resultado + "");
        } else {
            campoEfectivo.setText("0");
            JOptionPane.showMessageDialog(null, "No puede Apostar mas", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    @FXML
    private void obtenerValor100() {
        botonRepartir.setDisable(false);
        int conver = Integer.parseInt(campoEfectivo.getText());
        int texto = Integer.parseInt(campoApuesta.getText());
        int suma = ficha.getFicha100() + texto;
        if (conver > 0) {
            campoApuesta.setText(suma + "");
            resultado = quitarDinero(ficha, suma);
            campoEfectivo.setText(resultado + "");
        } else {
            campoEfectivo.setText("0");
            JOptionPane.showMessageDialog(null, "No puede Apostar mas", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public String barajar() {
        Random numeros = new Random();
        int numero = 1 + numeros.nextInt(13);
        String hola;
        //numerosAleatorios = (int) (Math.random()) * 13 + "";
        hola = numero + "";
        return hola;
    }
    
    public String obtenerLetra() {
        Random aleatorios = new Random();
        int numero = 1 + aleatorios.nextInt(4);
        //letra = (int) ((Math.random()) * 4);
        String variable = "";
        switch (numero) {
            case 1:
                variable = barajar() + "C" + ".png";
                break;
            case 2:
                variable = barajar() + "D" + ".png";
                break;
            case 3:
                variable = barajar() + "T" + ".png";
                break;
            case 4:
                variable = barajar() + "P" + ".png";
                break;
        }
        return variable;
    }

}
