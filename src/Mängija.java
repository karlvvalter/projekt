public class Mängija extends Player{
    private int handValue;

    public Mängija(String nimi) {
        super(nimi);
    }

    @Override
    void newHand() {
        this.handValue = 0;
    }

    @Override
    public int getHandValue() {
        return handValue;
    }

    public void addValue(Kaart kaart){
        this.handValue += kaart.getValue();
    }

    public void printControls(){
        System.out.println("1 - võta kaart juurde");
        System.out.println("2 - lõpeta käik");
        System.out.println("3 - lõpeta mäng");
        System.out.println("4 - mängu eesmärk/reeglid");
        System.out.println("5 - Juhend");
        System.out.println();
    }

    @Override
    public String toString() {
        return "TEIE KAARTIDE VÄÄRTUS: " + handValue;
    }
}
