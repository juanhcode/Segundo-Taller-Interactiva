/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class JuegoVistaController implements Initializable {

    @FXML
    private AnchorPane AnchorFondo;

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
    private int puntajeCupier;

    //Valor de la Carta Jugador
    int valorActualCarta1;
    int valorActualCarta2;
    int valorActualCarta3;
    int valorActualCarta4;

    //Valor de la Carta Cupier
    int valorActualCartaCupier1;
    int valorActualCartaCupier2;
    int valorActualCartaCupier3;
    int valorActualCartaCupier4;

    //Cartas Cambiadas
    Image carta1;
    Image cartaCupier;

    private int cartaActual;
    @FXML
    private Label campoMensajeGanadorOperdedor;
    private final String mensajeHacerApuesta = "***Haga su apuesta***";
    private final String mensajeGanador = "***Usted Gana***";
    private final String mensajePerdedor = "***Usted Pierde***";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        asignarCartasAJugadorYCupier();

    }

    @FXML
    private void otraCarta() {
        imagenJugador3 = paquete.barajar();
        valorActualCarta3 = paquete.getCartaActual();
        carta1 = new Image(imagenJugador3);
        campoImagenJugador3.setImage(carta1);
        puntaje += valorActualCarta3;
        campoPuntajeJugador.setText(puntaje + "");
        if (puntaje == 21) {
            botonOtraCarta.setDisable(true);
            campoMensajeGanadorOperdedor.setText(mensajeGanador);
            /*
            String dinero = campoEfectivo.getText();
            String efectivoDisponible = campoApuesta.getText();
            int puntajeGanado;
            int dineroGanado;
            int valorApuesta;
            puntajeGanado = Integer.parseInt(dinero);
            valorApuesta = Integer.parseInt(campoApuesta.getText());
            dineroGanado = puntajeGanado + valorApuesta;
            campoEfectivo.setText(dineroGanado+"");
            */
        }
        if (puntaje > 21) {
            campoMensajeGanadorOperdedor.setText(mensajePerdedor);
            //Cambia la carta tapada del cupier a tener valor
            imagenCupier = paquete.barajar();
            valorActualCartaCupier1 = paquete.getCartaActual();
            cartaCupier = new Image(imagenCupier);
            campoImagenCupier.setImage(cartaCupier);

            //Suma
            puntajeCupier += valorActualCartaCupier1;
            campoPuntajeCupier.setText(puntajeCupier + "");
            campoApuesta.setText(0 + "");
            botonOtraCarta.setDisable(true);
            botonSeguro.setDisable(true);

        }
    }

    @FXML
    private void seguro() {
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

        //habilitar fichas
        botonFicha1.setDisable(false);
        botonFicha5.setDisable(false);
        botonFicha10.setDisable(false);
        botonFicha25.setDisable(false);
        botonFicha50.setDisable(false);
        botonFicha100.setDisable(false);

        //Deshabilitar Otra carta
        botonOtraCarta.setDisable(true);
        //Deshabilitar Repartir
        botonRepartir.setDisable(true);
        
        //Actualizar Mensaje
        campoMensajeGanadorOperdedor.setText(mensajeHacerApuesta);
        
        //Actualizar Apuesta,puntaje Jugador y cupier
        campoApuesta.setText(0+"");
        campoPuntajeJugador.setText(0+"");
        campoPuntajeCupier.setText(0+"");
    }

    private int quitarDinero(Ficha f, int suma) {
        int resultado = f.getEfectivo() - suma;
        System.out.println("Esta es la resta=" + resultado);
        return resultado;
    }

    @FXML
    private void obtenerValor1() {
        botonRepartir.setDisable(false);
        int conver = Integer.parseInt(campoEfectivo.getText());
        System.out.println(conver);
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

    private void asignarCartasAJugadorYCupier() {

        //Se agrega la primera carta al jugador
        imagenJugador = paquete.barajar();
        //System.out.println("Carta Jugador" + imagenJugador);
        valorActualCarta1 = paquete.getCartaActual(); //Se obtiene el valor de la carta
        //System.out.println("Valor Carta" + valorActualCarta1);
        carta1 = new Image(imagenJugador);
        campoImagenJugador.setImage(carta1);

        //Se agrega la segunda carta al Cupier
        imagenCupier2 = paquete.barajar();
        //System.out.println("Carta Cupier" + imagenCupier2);
        valorActualCartaCupier2 = paquete.getCartaActual(); //Se obtiene el valor de la carta
        puntajeCupier = valorActualCartaCupier2;
        //System.out.println("Valor Carta" + valorActualCartaCupier2);
        cartaCupier = new Image(imagenCupier2);
        campoImagenCupier2.setImage(cartaCupier);
        campoPuntajeCupier.setText(valorActualCartaCupier2 + "");

        //Se agrega la tercera carta al Jugador
        imagenJugador2 = paquete.barajar();
        //System.out.println("Carta Jugador" + imagenJugador2);
        valorActualCarta2 = paquete.getCartaActual();
        carta1 = new Image(imagenJugador2);
        //System.out.println("Valor Carta" + valorActualCarta2);
        campoImagenJugador2.setImage(carta1);
        //campoPuntajeJugador.setText(valorActualCarta2 + "");

        //Suma De las dos cartas
        puntaje = valorActualCarta1 + valorActualCarta2;
        campoPuntajeJugador.setText(puntaje + "");
    }
}
