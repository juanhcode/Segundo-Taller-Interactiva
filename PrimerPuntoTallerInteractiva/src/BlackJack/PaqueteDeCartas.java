package BlackJack;

import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PaqueteDeCartas {

    private Carta paquete[];
    private int cartaActual;
    private final int NUMERO_CARTAS = 52;
    private String numerosAleatorios;
    private int letra;
    private int suma;
    private int cartaAs;

    public PaqueteDeCartas() {

    }

    public String identificarNumeroCarta() {
        Random numeros = new Random();
        int numero = 1 + numeros.nextInt(13);
        String hola;
        hola = numero + "";
        return hola;
    }

    public String barajar() {
        Random aleatorios = new Random();
        int numero = 1 + aleatorios.nextInt(4);
        String variable = "";
        switch (numero) {
            case 1:
                variable = identificarNumeroCarta() + "C" + ".png";
                break;
            case 2:
                variable = identificarNumeroCarta() + "D" + ".png";
                break;
            case 3:
                variable = identificarNumeroCarta() + "T" + ".png";
                break;
            case 4:
                variable = identificarNumeroCarta() + "P" + ".png";
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
        } else if (variable.equals("1C.png") || (variable.equals("1D.png") || (variable.equals("1P.png") || (variable.equals("1T.png"))))) {
            cartaActual = 1;
        } else {
            cartaActual = 10;
        }
        return "/Imagenes Cartas/" + variable;
    }

    public int valorAs() {
        Icon carta = new ImageIcon(getClass().getResource("/Imagenes Cartas/1P.png"));
        
        String[] botones = {"1", "11"};
        int ventana = JOptionPane.showOptionDialog(null, "¿Que valor desea dar a la carta?", "Juego 21", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, carta, botones, botones[0]);
        if (ventana == 0) {
            this.cartaActual = 1;
            System.out.println(cartaActual);
        } else if (ventana == 1) {
            this.cartaActual = 11;
            System.out.println(cartaActual);
        }
        return cartaActual;
    }
    
    public Carta[] getPaquete() {
        return paquete;
    }

    public void setPaquete(Carta[] paquete) {
        this.paquete = paquete;
    }

    public int getCartaActual() {
        return cartaActual;
    }

    public int setCartaActual(int cartaActual) {
        return this.cartaActual = cartaActual;
    }

    public String getNumerosAleatorios() {
        return numerosAleatorios;
    }

    public void setNumerosAleatorios(String numerosAleatorios) {
        this.numerosAleatorios = numerosAleatorios;
    }

    public int getLetra() {
        return letra;
    }

    public void setLetra(int letra) {
        this.letra = letra;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public String cartaObtenida() {
        return barajar();
    }

    public int getCartaAs() {
        return cartaAs;
    }

    public void setCartaAs(int cartaAs) {
        this.cartaAs = cartaAs;
    }

}
