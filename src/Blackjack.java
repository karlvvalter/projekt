import java.util.Scanner;


public class Blackjack {

    public static void algseadistaLaud(Kaardid kaardipakk, Player[] mängijad){
        System.out.print("TEIE KAARDID ON: ");
        for (int i = 0; i < 2; i++) {
            for (Player player : mängijad) {
                Kaart kaart = kaardipakk.annaKaart();
                player.addValue(kaart);
                if(player.getNimi().equals("TEIE")){
                    System.out.print(kaart + " ");
                }
            }
        }
        System.out.println();
    }
    public static String reeglid = "\nIgale mängijale jagatakse kaks kaarti ja seejärel pakutakse võimalust lisakaarte võtta.\n Suurema punktisummaga käsi võidab, juhul, kui punktisumma ei ületa 21;\n käsi, mille punktisumma on suurem kui 21, loetakse kaotanuks.\n Kaardid 2-st 10-ni on nimiväärtusega ning pildikaartide väärtuseks on kümme punkti.\n Äss on kas 1 või 11 punkti,\n sõltuvalt sellest kas punktide kogusumma püsib 21 piires\n";
    public static void roundWinner(Player[] players){
        //Ei vaata viiki ega kui kõik üle panevad
        int suurim = 0;
        String nimi = "";
        for (Player player : players) {
            int value = player.getHandValue();
            if (value > suurim && value <= 21) {
                suurim = value;
                nimi = player.getNimi();
            }
        }
        System.out.println("Selle käe võitja oli:");
        System.out.println(nimi);
        System.out.println();
        System.out.println("Lõppseis: ");
        showTable(players);
        System.out.println("-------------------------------");
        try {Thread.sleep(1000);}
        catch (Exception e){
            System.out.println("asdfasfasdasfasf");
        }
        System.out.println();
        System.out.println("|          UUS KÄSI           |");
    }

    public static void showTable(Player[] players){
        for (Player player : players) {
            System.out.println(player);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Player user = new Mängija("TEIE");
        Player arvuti1 = new arvutiPlayer("Arvutimängija Thorin");
        Player diiler = new arvutiPlayer("Diiler Gandalf");

        Player[] playersAI = {arvuti1, diiler};
        Player[] allPlayers = {user, arvuti1, diiler};
        Player[] ainultMängijad = {user, arvuti1};


        Kaardid kaardipakk = new Kaardid();
        kaardipakk.algseadistaPakk(2);

        System.out.println("--------------------------------------");
        System.out.println("|                                    |");
        System.out.println("| TERE TULEMAST ÜKSIKUMÄE KASIINOSSE |");
        System.out.println("|             LAUAS ON :             |");
        System.out.println("|          Diiler Gandalf            |");
        System.out.println("|       Arvutimängija Thorin         |");
        System.out.println("|                                    |");
        System.out.println("--------------------------------------");
        Thread.sleep(500);
        System.out.println("Juhend: ");
        user.printControls();


        System.out.println();

        boolean uusRaund = true;
        boolean jätkub = true;
        boolean mäng = true;

        while (mäng) {
            System.out.println("Mängimiseks sisesta [ 1 ] ");
            while(true) {
                Scanner scan = new Scanner(System.in);
                int valik = scan.nextInt();
                if(valik == 1){
                    break;
            }
            }
            while (jätkub) {
                if (kaardipakk.getKaartepakis() < 6) {
                    jätkub = false;
                    break;
                }
                if (uusRaund) {
                    for (Player player : allPlayers) {
                        player.newHand();
                    }
                    Kaart diileriKaart = kaardipakk.annaKaart();
                    diiler.addValue(diileriKaart);
                    algseadistaLaud(kaardipakk, ainultMängijad);
                    showTable(allPlayers);
                    uusRaund = false;
                }
                if (user.getHandValue() > 21) {
                    break;
                }

                Scanner scan = new Scanner(System.in);
                System.out.println();
                System.out.print("Sisesta valik: ");
                int valik = scan.nextInt();

                if (valik == 1) {
                    Kaart kaart = kaardipakk.annaKaart();
                    System.out.println("Tõmbasid: " + kaart);
                    user.addValue(kaart);
                    Thread.sleep(500);
                    showTable(allPlayers);

                } else if (valik == 2) {
                    break;
                } else if (valik == 3) {
                    mäng = false;
                    jätkub = false;
                    break;
                } else if (valik == 4) {
                    System.out.print(reeglid);
                } else if (valik == 5) {
                    user.printControls();
                } else {
                    System.out.println("Ebasobiv sisend!");
                }

            }
            if (jätkub) {
                for (Player player : playersAI) {
                    while (player.draw(player.getHandValue())) {
                        Kaart kaart = kaardipakk.annaKaart();
                        player.addValue(kaart);
                    }
                }
                System.out.println("-------------------------------");
                Thread.sleep(1000);
                roundWinner(allPlayers);

                uusRaund = true;
                jätkub = true;

            }
            else if(mäng) {
                Thread.sleep(500);
                kaardipakk.algseadistaPakk(2);
                System.out.println("-------------------------------");
                System.out.println("Kaardid on otsas");
                System.out.println("Gandalf segab uue paki");
                System.out.println("-------------------------------");
                uusRaund = true;
                jätkub = true;
                Thread.sleep(500);
            }
        }
        System.out.println("--------------------------------------");
        System.out.println("|                                    |");
        System.out.println("|     LAHKUTE ÜKSIKUMÄE KASIINOST    |");
        System.out.println("|                                    |");
        System.out.println("|             AITÄH, ET              |");
        System.out.println("|             MÄNGISTE!              |");
        System.out.println("|                                    |");
        System.out.println("--------------------------------------");
    }
}
