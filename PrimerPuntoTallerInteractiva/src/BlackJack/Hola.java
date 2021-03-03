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

        //comparar con valores de las cartas para el AS y (10 J K Q)
        PaqueteDeCartas paquete = new PaqueteDeCartas();        
        //paquete.valorAs();
        
        String carta = paquete.barajar();
        System.out.println(carta);
        if (carta.equals("/Imagenes Cartas/1C.png") || (carta.equals("/Imagenes Cartas/1D.png") || (carta.equals("/Imagenes Cartas/1P.png") || (carta.equals("/Imagenes Cartas/1T.png"))))){
            paquete.valorAs();
        }
        
        System.out.println(paquete.getCartaActual());

    }

}
