package BlackJack;

import java.util.Random;

public class PaqueteDeCartas {

    private Carta paquete[];
    private int cartaActual;
    private final int NUMERO_CARTAS = 52;
    private String numerosAleatorios;
    private int letra;
    private int suma;

    public PaqueteDeCartas() {

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
        return variable;
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

    public void setCartaActual(int cartaActual) {
        this.cartaActual = cartaActual;
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
    
    

}
