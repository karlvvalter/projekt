public class Mängija extends Player {
    private int handValue;
    private int mituÄssa;

    public Mängija(String nimi) {
        super(nimi);
    }

    //Algväärtustab mängija käe
    @Override
    void newHand() {
        this.handValue = 0;
        this.mituÄssa = 0;
    }

    //Tagastab mängija käe väärtuse
    @Override
    public int getHandValue() {
        int uus = this.handValue;
        if (this.mituÄssa > 0) {
            for (int i = 0; i < this.mituÄssa; i++) {
                if (uus > 21) {
                    uus = uus - 10;
                } else {
                    break;
                }
            }
        }
        return uus;
    }

    //Lisab kaardi väärtuse mängija käele
    public void addValue(Kaart kaart) {
        if (kaart.getValue() == 11) {
            this.mituÄssa = this.mituÄssa + 1;
        }
        this.handValue += kaart.getValue();
    }

    //Info
    public void printControls() {
        System.out.println("1 - võta kaart juurde");
        System.out.println("2 - lõpeta käik");
        System.out.println("3 - lõpeta mäng");
        System.out.println("4 - mängu eesmärk/reeglid");
        System.out.println("5 - Juhend");
        System.out.println();
    }

    @Override
    public String toString() {
        return "TEIE KAARTIDE VÄÄRTUS: " + this.getHandValue();
    }
}
