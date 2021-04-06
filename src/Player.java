abstract class Player {
    private String nimi;
    private int handValue;
    private int mituÄssa;


    public Player(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return nimi;
    }

    public int getHandValue() {
        return handValue;
    }

    public boolean draw(int hand){
        return false;
    }

    abstract void newHand();

    abstract void addValue(Kaart kaart);

    public void printControls(){};
}
