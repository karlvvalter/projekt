public class arvutiPlayer extends Player{
    private int handValue;
    private int mituÄssa;

    public arvutiPlayer(String nimi) {
        super(nimi);
    }

    @Override
    public boolean draw(int hand) {
        if (hand < 17)
            return true;
        else
            return false;
    }

    @Override
    void newHand() {
        this.handValue = 0;
        this.mituÄssa = 0;
    }

    @Override
    public int getHandValue() {
        int uus = this.handValue;
        if(this.mituÄssa > 0){
            for (int i = 0; i < this.mituÄssa; i++) {
                if(uus > 21){
                    uus = uus - 10;
                }
                else{
                    break;
                }
            }
        }
        return uus;
    }

    public void addValue(Kaart kaart){
        if(kaart.getValue() == 11){
            this.mituÄssa = this.mituÄssa + 1;
        }
        this.handValue += kaart.getValue();
    }

    @Override
    public String toString() {
        return this.getNimi() + " Kaartide väärtus: " + handValue;
    }
}
