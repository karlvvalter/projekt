public class arvutiPlayer extends Player{
    private int handValue;
    public
    arvutiPlayer(String nimi) {
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
    }

    @Override
    public int getHandValue() {
        return handValue;
    }

    public void addValue(Kaart kaart){
        this.handValue += kaart.getValue();
    }

    @Override
    public String toString() {
        return super.toString() + "arvutiPlayer{" +
                "handValue=" + handValue +
                '}';
    }
}
