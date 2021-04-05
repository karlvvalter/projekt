import java.util.ArrayList;
import java.util.List;

public class Kaardid {
    private String[] kaardid = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    public int kaartepakis = 0;
    public List<Kaart> kaardipakk= new ArrayList();

    public List<Kaart> algseadistaPakk(int pakkideKogus){
        for (int i = 0; i < pakkideKogus; i++) {
            for (String kaart : kaardid) {
                kaardipakk.add(new Kaart(kaart));
            }
        }
        kaartepakis = kaardipakk.size();
        return kaardipakk;
    }


    //Juhuarv, ülemine&alumine on kaasaarvatud\\
    public Integer suvalineArv(int alumine, int ulemine){
        return (alumine + (int)(Math.random() * ((ulemine - alumine) + 1)));
    }

    public Kaart annaKaart(){
        kaartepakis = kaardipakk.size();
        int juhuslikIndeks = suvalineArv(0, kaartepakis);
        Kaart uus = kaardipakk.get(juhuslikIndeks);
        kaardipakk.remove(juhuslikIndeks);
        return uus;
    }

}
