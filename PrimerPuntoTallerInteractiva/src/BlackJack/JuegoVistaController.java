/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.net.URL;
import java.util.ResourceBundle;
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
    @FXML
    private Button botonCarta4;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        campoEfectivo.setText(ficha.getEfectivo() + "");
        campoApuesta.setText(0 + "");
        botonRepartir.setDisable(true);
        botonOtraCarta.setDisable(true);
        botonCarta4.setDisable(true);
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
        botonCarta4.setDisable(false);
        botonOtraCarta.setDisable(false);
        botonSeguro.setDisable(false);
        botonOtroJuego.setDisable(true);
        asignarCartasAJugadorYCupier();

    }

    @FXML
    private void darCarta4() {
        //imagenJugador3 = "/Imagenes Cartas/1P.png";
        //valorActualCarta3 = 1;
        //TERCERA CARTA      
        imagenJugador3 = paquete.barajar(); //3C.Png
        valorActualCarta3 = paquete.getCartaActual();
        carta1 = new Image(imagenJugador3);
        if (valorActualCarta3 == 1) { //VALIDACION SI SALE UN AS
            valorActualCarta3 = paquete.valorAs();
        }
        campoImagenJugador3.setImage(carta1);
        puntaje += valorActualCarta3;
        campoPuntajeJugador.setText(puntaje + "");

        botonCarta4.setDisable(true);
        botonOtraCarta.setDisable(false);

        //VALIDACIONES
        if (puntaje == 21) {
            botonOtraCarta.setDisable(true);
            botonCarta4.setDisable(true);
            botonSeguro.setDisable(true);
            botonOtroJuego.setDisable(false);
            campoMensajeGanadorOperdedor.setText(mensajeGanador);
            int Apuesta = Integer.parseInt(campoApuesta.getText());
            int dinero = Integer.parseInt(campoEfectivo.getText());
            this.resultado = Apuesta * 2;
            dinero += resultado;
            campoEfectivo.setText(dinero + "");
        }

        if (puntaje > 21) {
            seguro();
            campoMensajeGanadorOperdedor.setText(mensajePerdedor);
            botonCarta4.setDisable(true);
            botonOtraCarta.setDisable(true);
            botonSeguro.setDisable(true);

        }
    }

    @FXML
    private void otraCarta() {

        //CUARTA CARTA     
        imagenJugador4 = paquete.barajar(); //3C.Png
        valorActualCarta4 = paquete.getCartaActual();
        carta1 = new Image(imagenJugador4);
        if (valorActualCarta4 == 1) { //VALIDACION SI SALE UN AS
            valorActualCarta4 = paquete.valorAs();
        }
        campoImagenJugador4.setImage(carta1);
        puntaje += valorActualCarta4;
        campoPuntajeJugador.setText(puntaje + "");

        //VALIDACIONES
        if (puntaje == 21) {
            botonOtraCarta.setDisable(true); //Boton
            botonCarta4.setDisable(true);
            botonSeguro.setDisable(true);
            botonSeguro.setDisable(false);
            campoMensajeGanadorOperdedor.setText(mensajeGanador);
            int Apuesta = Integer.parseInt(campoApuesta.getText());
            int dinero = Integer.parseInt(campoEfectivo.getText());
            this.resultado = Apuesta * 2;
            dinero += resultado;
            campoEfectivo.setText(dinero + "");
        }
        if (puntaje > 21) {
            seguro();
            campoMensajeGanadorOperdedor.setText(mensajePerdedor);
            botonCarta4.setDisable(true);
            botonOtraCarta.setDisable(true);
            botonSeguro.setDisable(true);
            botonOtroJuego.setDisable(false);

        }
        if (campoImagenJugador.isVisible() && campoImagenJugador2.isVisible() && campoImagenJugador3.isVisible() && campoImagenJugador4.isVisible()) {
            //seguro();
            //botonSeguro.setDisable(true);
        }
        botonOtraCarta.setDisable(true);

    }

    @FXML
    private void seguro() {
        imagenCupier = paquete.barajar();
        valorActualCartaCupier1 = paquete.getCartaActual();
        System.out.println("Carta 1: " + valorActualCartaCupier1);
        cartaCupier = new Image(imagenCupier);
        campoImagenCupier.setImage(cartaCupier);
        puntajeCupier += valorActualCartaCupier1;
        campoPuntajeCupier.setText(puntajeCupier + "");
        if (puntajeCupier < 16) {
            imagenCupier3 = paquete.barajar();
            valorActualCartaCupier3 = paquete.getCartaActual();
            System.out.println("Carta 3: " + valorActualCartaCupier3);
            cartaCupier = new Image(imagenCupier3);
            campoImagenCupier3.setImage(cartaCupier);
            puntajeCupier += valorActualCartaCupier3;
            campoPuntajeCupier.setText(puntajeCupier + "");

            if (puntajeCupier < 16) {
                imagenCupier4 = paquete.barajar();
                valorActualCartaCupier4 = paquete.getCartaActual();
                System.out.println("Carta 4: " + valorActualCartaCupier4);
                cartaCupier = new Image(imagenCupier4);
                campoImagenCupier4.setImage(cartaCupier);
                puntajeCupier += valorActualCartaCupier4;
                campoPuntajeCupier.setText(puntajeCupier + "");
            }

        }
        if (puntajeCupier > 21) {
            campoMensajeGanadorOperdedor.setText(mensajeGanador);
            botonOtraCarta.setDisable(true);
            botonCarta4.setDisable(true);
            botonSeguro.setDisable(true);
            botonOtroJuego.setDisable(false);
        }
        if (puntajeCupier == 21) {
            campoMensajeGanadorOperdedor.setText(mensajePerdedor);
            botonOtraCarta.setDisable(true);
            botonCarta4.setDisable(true);
            botonSeguro.setDisable(true);
            botonOtroJuego.setDisable(false);
        }
        if ((puntajeCupier > puntaje) && (puntajeCupier < 21)) {
            campoMensajeGanadorOperdedor.setText(mensajePerdedor);
            botonOtraCarta.setDisable(true);
            botonCarta4.setDisable(true);
            botonSeguro.setDisable(true);
            botonOtroJuego.setDisable(false);
        } else if (puntajeCupier == puntaje) {
            campoMensajeGanadorOperdedor.setText("Es un empate");
            botonOtraCarta.setDisable(true);
            botonCarta4.setDisable(true);
            botonSeguro.setDisable(true);
            botonOtroJuego.setDisable(false);
        } else {
            campoMensajeGanadorOperdedor.setText(mensajeGanador);
            botonOtraCarta.setDisable(true);
            botonCarta4.setDisable(true);
            botonSeguro.setDisable(true);
            botonOtroJuego.setDisable(false);
        }
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
        botonCarta4.setDisable(true);
        //Deshabilitar Repartir
        botonRepartir.setDisable(true);

        //Actualizar Mensaje
        campoMensajeGanadorOperdedor.setText(mensajeHacerApuesta);

        //Actualizar Apuesta,puntaje Jugador y cupier
        campoApuesta.setText(0 + "");
        campoPuntajeJugador.setText(0 + "");
        campoPuntajeCupier.setText(0 + "");
    }

    @FXML
    private void obtenerValor1() {
        botonRepartir.setDisable(false);
        int dinero = Integer.parseInt(campoEfectivo.getText());
        int apuesta = Integer.parseInt(campoApuesta.getText());
        int suma = apuesta + ficha.getFicha1();
        if (dinero > 0) {
            campoApuesta.setText(suma + "");
            this.resultado = dinero - ficha.getFicha1();
            campoEfectivo.setText(resultado + "");
        } else {
            campoEfectivo.setText("0");
            JOptionPane.showMessageDialog(null, "No puede Apostar mas", "ERROR", JOptionPane.ERROR_MESSAGE);
            botonRepartir.setDisable(true);
        }
    }

    @FXML
    private void obtenerValor5() {
        botonRepartir.setDisable(false);
        int dinero = Integer.parseInt(campoEfectivo.getText());
        int apuesta = Integer.parseInt(campoApuesta.getText());
        int suma = apuesta + ficha.getFicha5();
        if (dinero > 0) {
            campoApuesta.setText(suma + "");
            this.resultado = dinero - ficha.getFicha5();
            campoEfectivo.setText(resultado + "");
        } else {
            campoEfectivo.setText("0");
            JOptionPane.showMessageDialog(null, "No puede Apostar mas", "ERROR", JOptionPane.ERROR_MESSAGE);
            botonRepartir.setDisable(true);
        }
    }

    @FXML
    private void obtenerValor10() {
        botonRepartir.setDisable(false);
        int dinero = Integer.parseInt(campoEfectivo.getText());
        int apuesta = Integer.parseInt(campoApuesta.getText());
        int suma = apuesta + ficha.getFicha10();
        if (dinero > 0) {
            campoApuesta.setText(suma + "");
            this.resultado = dinero - ficha.getFicha10();
            campoEfectivo.setText(resultado + "");
        } else {
            campoEfectivo.setText("0");
            JOptionPane.showMessageDialog(null, "No puede Apostar mas", "ERROR", JOptionPane.ERROR_MESSAGE);
            botonRepartir.setDisable(true);
        }
    }

    @FXML
    private void obtenerValor25() {
        botonRepartir.setDisable(false);
        int dinero = Integer.parseInt(campoEfectivo.getText());
        int apuesta = Integer.parseInt(campoApuesta.getText());
        int suma = apuesta + ficha.getFicha25();
        if (dinero > 0) {
            campoApuesta.setText(suma + "");
            this.resultado = dinero - ficha.getFicha25();
            campoEfectivo.setText(resultado + "");
        } else {
            campoEfectivo.setText("0");
            JOptionPane.showMessageDialog(null, "No puede Apostar mas", "ERROR", JOptionPane.ERROR_MESSAGE);
            botonRepartir.setDisable(true);
        }
    }

    @FXML
    private void obtenerValor50() {
        botonRepartir.setDisable(false);
        int dinero = Integer.parseInt(campoEfectivo.getText());
        int apuesta = Integer.parseInt(campoApuesta.getText());
        int suma = apuesta + ficha.getFicha50();
        if (dinero > 0) {
            campoApuesta.setText(suma + "");
            this.resultado = dinero - ficha.getFicha50();
            campoEfectivo.setText(resultado + "");
        } else {
            campoEfectivo.setText("0");
            JOptionPane.showMessageDialog(null, "No puede Apostar mas", "ERROR", JOptionPane.ERROR_MESSAGE);
            botonRepartir.setDisable(true);
        }

    }

    @FXML
    private void obtenerValor100() {
        botonRepartir.setDisable(false);
        int dinero = Integer.parseInt(campoEfectivo.getText());
        int apuesta = Integer.parseInt(campoApuesta.getText());
        int suma = apuesta + ficha.getFicha100();
        if (dinero > 0) {
            campoApuesta.setText(suma + "");
            this.resultado = dinero - ficha.getFicha100();
            campoEfectivo.setText(resultado + "");
        } else {
            campoEfectivo.setText("0");
            JOptionPane.showMessageDialog(null, "No puede Apostar mas", "ERROR", JOptionPane.ERROR_MESSAGE);
            botonRepartir.setDisable(true);
        }
    }

    private void asignarCartasAJugadorYCupier() {

        //imagenJugador = "/Imagenes Cartas/10P.png";  
        //valorActualCarta1 = 10;
        //Se agrega la primera carta al jugador
        imagenJugador = paquete.barajar();
        valorActualCarta1 = paquete.getCartaActual();
        if (valorActualCarta1 == 1) { //VALIDACION SI SALE UN AS
            valorActualCarta1 = paquete.valorAs();
        }
        carta1 = new Image(imagenJugador);
        campoImagenJugador.setImage(carta1);

        //Se agrega la segunda carta al Cupier
        imagenCupier2 = paquete.barajar();
        valorActualCartaCupier2 = paquete.getCartaActual();
        //  System.out.println("Carta 2: " + valorActualCartaCupier2);
        puntajeCupier = valorActualCartaCupier2;
        cartaCupier = new Image(imagenCupier2);
        campoImagenCupier2.setImage(cartaCupier);
        campoPuntajeCupier.setText(valorActualCartaCupier2 + "");

        //imagenJugador = "/Imagenes Cartas/10P.png"; CARTA VALOR 10
        //imagenJugador2 = "/Imagenes Cartas/1P.png";
        //valorActualCarta2 = 1;
        //Se agrega la tercera carta al Jugador
        imagenJugador2 = paquete.barajar();
        valorActualCarta2 = paquete.getCartaActual();

        if (valorActualCarta2 == 1) { //VALIDACION SI SALE UN AS
            valorActualCarta2 = paquete.valorAs();
        }

        //VALIDACION PARA AHCER BLACK JACK CON DOS CARTAa
        if (valorActualCarta1 == 1 && valorActualCarta2 == 10) {
            seguro(); //******************************************************************************** por si depronto afecta puntaje cupier
            valorActualCarta1 = 11;
            botonOtraCarta.setDisable(true); //Boton
            botonCarta4.setDisable(true);
            botonSeguro.setDisable(true);
            campoMensajeGanadorOperdedor.setText(mensajeGanador);
            int Apuesta = Integer.parseInt(campoApuesta.getText());
            int dinero = Integer.parseInt(campoEfectivo.getText());
            this.resultado = Apuesta * 2;
            dinero += resultado;
            campoEfectivo.setText(dinero + "");
        }
        if (valorActualCarta1 == 10 && valorActualCarta2 == 1) {
            seguro(); //******************************************************************************** por si depronto afecta puntaje cupier
            valorActualCarta2 = 11;
            botonOtraCarta.setDisable(true); //Boton
            botonCarta4.setDisable(true);
            botonSeguro.setDisable(true);
            campoMensajeGanadorOperdedor.setText(mensajeGanador);
            int Apuesta = Integer.parseInt(campoApuesta.getText());
            int dinero = Integer.parseInt(campoEfectivo.getText());
            this.resultado = Apuesta * 2;
            dinero += resultado;
            campoEfectivo.setText(dinero + "");
        }

        carta1 = new Image(imagenJugador2);
        campoImagenJugador2.setImage(carta1);

        //Suma De las dos cartas Jugador
        puntaje = valorActualCarta1 + valorActualCarta2;
        campoPuntajeJugador.setText(puntaje + "");

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

}
