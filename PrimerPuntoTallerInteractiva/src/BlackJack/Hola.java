/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

/**
 *
 * @author Usuario
 */
public class Hola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
        PaqueteDeCartas paquete = new PaqueteDeCartas();
        
        
        String carta = paquete.barajar();
        int valorCarta = paquete.getCartaActual();
        System.out.println(carta);
        System.out.println(valorCarta);
        carta = paquete.barajar();
        valorCarta = paquete.getCartaActual();
        System.out.println(carta);
        System.out.println(valorCarta);
        
        /*
        JuegoVistaController pruebas = new JuegoVistaController();
        pruebas.Imprimir();
        */

    }

}
