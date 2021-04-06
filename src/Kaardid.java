import java.util.ArrayList;
import java.util.List;

public class Kaardid {
    private String[] kaardid = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    public int kaartepakis = 0;
    public List<Kaart> kaardipakk= new ArrayList();

    public int getKaartepakis() {
        return kaartepakis;
    }

    public List<Kaart> algseadistaPakk(int pakkideKogus){
        for (int i = 0; i < pakkideKogus*4; i++) {
            for (String elem : kaardid) {
                kaardipakk.add(new Kaart(elem));
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
        int juhuslikIndeks = suvalineArv(0, kaartepakis-1);
        Kaart uus = kaardipakk.get(juhuslikIndeks);
        kaardipakk.remove(juhuslikIndeks);
        kaartepakis = kaardipakk.size();
        return uus;
    }

}
