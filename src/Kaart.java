import java.util.HashMap;

public class Kaart extends Kaardid{
    private String kaart;
    private HashMap<String, Integer> values = new HashMap<>();


    public Kaart(String kaart) {
        this.kaart = kaart;
        this.values.put("2", 2);
        this.values.put("3", 3);
        this.values.put("4", 4);
        this.values.put("5", 5);
        this.values.put("6", 6);
        this.values.put("7", 7);
        this.values.put("8", 8);
        this.values.put("9", 9);
        this.values.put("10", 10);
        this.values.put("J", 10);
        this.values.put("Q", 10);
        this.values.put("K", 10);
        this.values.put("A", 11);
    }

    @Override
    public String toString() {
        return kaart;
    }


    public int getValue() {
        return this.values.get(this.kaart);
    }


}
