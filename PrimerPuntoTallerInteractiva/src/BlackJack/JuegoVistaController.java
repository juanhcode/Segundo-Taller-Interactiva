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

    //Menu
    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem mostrarIntegrantes;

    //Campos
    @FXML
    private TextField campoEfectivo;
    @FXML
    private TextField campoApuesta;
    @FXML
    private TextField campoPuntajeJugador;
    @FXML
    private TextField campoPuntajeCupier;

    //Repartir,otra Carta,Seguro y Otro Juego
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

    //Ficha
    private Ficha ficha = new Ficha();
    private int resultado; //actualiza el efectivo

    //Paquete
    private PaqueteDeCartas paquete = new PaqueteDeCartas();

    private int cartaActual;

    //ImageView Jugador
    @FXML
    private ImageView campoImagenJugador;
    @FXML
    private ImageView campoImagenJugador2;
    @FXML
    private ImageView campoImagenJugador3;
    @FXML
    private ImageView campoImagenJugador4;

    //ImageView Cupier
    @FXML
    private ImageView campoImagenCupier;
    @FXML
    private ImageView campoImagenCupier2;
    @FXML
    private ImageView campoImagenCupier3;
    @FXML
    private ImageView campoImagenCupier4;

    //RUTA CARTAS al Azar Jugador
    String imagenJugador;
    String imagenJugador2;
    String imagenJugador3;
    String imagenJugador4;

    //RUTA CARTAS al Azar Cupier
    String imagenCupier;
    String imagenCupier2;
    String imagenCupier3;
    String imagenCupier4;

    private Image imagenInicial;
    private Image imagenVacia;
    
    //Puntaje
    private int puntaje;
    
    //Valor de la Carta
    int carta1;
    int carta2;
    int carta3;
    int carta4;
    

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
    private void Repartir() {
        imagenVacia = campoImagenCupier4.getImage();
        
        //Deshabilitada Fichas al repartir
        botonFicha1.setDisable(true);
        botonFicha5.setDisable(true);
        botonFicha10.setDisable(true);
        botonFicha25.setDisable(true);
        botonFicha50.setDisable(true);
        botonFicha100.setDisable(true);

        //Deshabilita Repartir
        botonRepartir.setDisable(true);

        //Habilita Otra Carta y Seguro
        botonOtraCarta.setDisable(false);
        botonSeguro.setDisable(false);

        int suma=0;
        String cara = paquete.barajar();
        int carta1 = paquete.getCartaActual();
        String cara2 = paquete.barajar();
        int carta2 = paquete.getCartaActual();
        
        Image imagen1 = new Image(cara);
        Image imagen2 = new Image(cara2);
        suma = carta1 + carta2;
        campoPuntajeJugador.setText(suma+"");
        
        //String cara3 = paquete.barajar();        
        //Image imagen3 = new Image(cara3);
        campoImagenJugador.setImage(imagen1);
        campoImagenJugador2.setImage(imagen2);
        //campoImagenCupier2.setImage(imagen3);
        //campoPuntajeCupier.setText(cartaActual + "");
    }

    @FXML
    private void otraCarta() {
        imagenJugador3 = "/Imagenes Cartas/" + obtenerLetra();
        Image imagen3 = new Image(imagenJugador3);
        campoImagenJugador3.setImage(imagen3);
    }

    @FXML
    private void seguro() {
        imagenCupier3 = "/Imagenes Cartas/" + obtenerLetra();
        imagenCupier = "/Imagenes Cartas/" + obtenerLetra();
        imagenInicial = new Image(imagenCupier);
        campoImagenCupier.setImage(imagenInicial);
        botonOtraCarta.setDisable(true);
        Image imagen3 = new Image(imagenCupier3);
        campoImagenCupier3.setImage(imagen3);
    }

    @FXML
    private void otroJuego() {
        imagenInicial = new Image("/Imagenes Cartas/0.png");
        botonRepartir.setDisable(false);
        botonSeguro.setDisable(true);
        campoImagenCupier.setImage(imagenInicial);
        campoImagenJugador.setImage(imagenInicial);
        campoImagenJugador2.setImage(imagenVacia);
        campoImagenJugador3.setImage(imagenVacia);
        campoImagenJugador4.setImage(imagenVacia);
        campoImagenCupier2.setImage(imagenVacia);
        campoImagenCupier3.setImage(imagenVacia);
        campoImagenCupier4.setImage(imagenVacia);

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

    public String barajar() {
        Random numeros = new Random();
        int numero = 1 + numeros.nextInt(13);
        String hola;
        hola = numero + "";
        return hola;
    }

    public String obtenerLetra() {
        Random aleatorios = new Random();
        int numero = 1 + aleatorios.nextInt(4);
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
        if (variable.equals("2C.png") || (variable.equals("2D.png") || (variable.equals("2P.png") || (variable.equals("2T.png"))))) {
            cartaActual = 2;
        } else if (variable.equals("3C.png") || (variable.equals("3D.png") || (variable.equals("3P.png") || (variable.equals("3T.png"))))) {
            cartaActual = 3;
        } else if (variable.equals("4C.png") || (variable.equals("4D.png") || (variable.equals("4P.png") || (variable.equals("4T.png"))))) {
            cartaActual = 4;
        } else if (variable.equals("5C.png") || (variable.equals("5D.png") || (variable.equals("5P.png") || (variable.equals("5T.png"))))) {
            cartaActual = 5;
        } else if (variable.equals("6C.png") || (variable.equals("6D.png") || (variable.equals("6P.png") || (variable.equals("6T.png"))))) {
            cartaActual = 6;
        } else if (variable.equals("7C.png") || (variable.equals("7D.png") || (variable.equals("7P.png") || (variable.equals("7T.png"))))) {
            cartaActual = 7;
        } else if (variable.equals("8C.png") || (variable.equals("8D.png") || (variable.equals("8P.png") || (variable.equals("8T.png"))))) {
            cartaActual = 8;
        } else if (variable.equals("9C.png") || (variable.equals("9D.png") || (variable.equals("9P.png") || (variable.equals("9T.png"))))) {
            cartaActual = 9;
        } else {
            cartaActual = 10;
        }
        return variable;
    }

    public void Imprimir() {
        String Hola = paquete.barajar();
        if (Hola == null) {
            System.out.println("perra");
        } else {
            System.out.println(Hola);
            System.out.println("Valor: " + paquete.getCartaActual());
        }
    }
}
