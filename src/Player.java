abstract class Player {
    private String nimi;
    private int handValue;
    private int mituÄssa;

    //Konstruktor mängija nime panemiseks
    public Player(String nimi) {
        this.nimi = nimi;
    }

    //Get-meetod mängija nime saamiseks
    public String getNimi() {
        return nimi;
    }

    //Get-meetod mängija käe väärtuse saamiseks
    public int getHandValue() {
        return handValue;
    }

    //Meetod, mis aitab määrata arvuti käiku
    public boolean draw(int hand) {
        return false;
    }

    //Meetod, mis algväärtustab mängija käe
    abstract void newHand();

    //Meetod, mis lisab etteantud kaardi väärtuse mängija käele
    abstract void addValue(Kaart kaart);

    //Meetod, mis prindib mängu mängimiseks vajaliku info
    public void printControls() {
    }

    ;
}
