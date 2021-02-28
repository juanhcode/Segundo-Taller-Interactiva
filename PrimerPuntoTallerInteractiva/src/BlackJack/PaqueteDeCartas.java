package BlackJack;

import java.util.Random;

public class PaqueteDeCartas {
    
    private Carta paquete[];
    private int cartaActual;
    private final int NUMERO_CARTAS = 52;
    private Random numerosAleatorios;

    public PaqueteDeCartas(){
        String caras[] = {"As","Dos","Tres","Cuatro","Cinco","Seis","Siete", "Ocho", "Nueve", "Diez", "Joto", "Quina", "Rey"};
        String palos[] = {"Corazones","Diamantes","Treboles","Espadas"};
        
        paquete = new Carta[NUMERO_CARTAS];
        cartaActual = 0;
        numerosAleatorios = new Random();
        for(int cuenta = 0 ; cuenta < paquete.length; cuenta++){
            paquete[cuenta] = new Carta(caras[cuenta % 13], palos[cuenta / 13]);
        }
    }
    
    
}
