import java.util.HashMap;

public class Kaardid {
    private String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    private HashMap<Kaart, Integer> kaardiPakk = new HashMap<>();


    public HashMap<Kaart, Integer> algseadistaPakk(int pakkideKogus){
        for (int i = 0; i < 13; i++) {
            Kaart kaart = new Kaart(this.cards[i]);
            this.kaardiPakk.put(kaart, kaart.getValue());
        }
        return this.kaardiPakk;
    }

    //Juhuarv, ülemine&alumine on kaasaarvatud\\
    public Integer suvalineArv(int alumine, int ulemine){
        return (alumine + (int)(Math.random() * ((ulemine - alumine) + 1)));
    }

    public Kaart annaKaart(){
        int juhuslikIndeks = suvalineArv(0, 12);
        return new Kaart(cards[juhuslikIndeks]);
    }


    /*
    public HashMap<Kaart, int[]> eemaldaKaart(Kaart kaart){
            int value = this.kaardiPakk.get(kaart)[0];
            this.kaardiPakk.remove(kaart);
            this.kaardiPakk.put(kaart, kaart.getValue());
            return this.kaardiPakk;
    }
     */

    public void printDeck(){
        int i = 0;
        for (Kaart kaart : this.kaardiPakk.keySet()){
            if (i == 6)
                System.out.print("\n");
            System.out.print(kaart + " = " + this.kaardiPakk.get(kaart) + "  ");
            i++;
        }
        System.out.println();
    }
}
