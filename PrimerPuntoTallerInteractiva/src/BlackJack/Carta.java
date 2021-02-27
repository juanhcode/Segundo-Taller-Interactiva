package BlackJack;
public class Carta {
    
    private String cara;
    private String palo;
    
    public Carta(String cara,String palo){
        this.cara = cara;
        this.palo = palo;
    }

    public String getCara() {
        return cara;
    }

    public void setCara(String cara) {
        this.cara = cara;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }
}
