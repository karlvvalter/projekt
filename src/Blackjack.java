import java.util.Scanner;


public class Blackjack {

    public static void algseadistaLaud(Kaardid kaardipakk, Player[] mängijad){
        for (int i = 0; i < 2; i++) {
            for (Player player : mängijad) {
                Kaart kaart = kaardipakk.annaKaart();
                player.addValue(kaart);
            }
        }
    }

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
        System.out.println("Lõppseis: ");
        showTable(players);
        System.out.println("---------------------------");
        System.out.println("Uus mäng:");
    }

    public static void showTable(Player[] players){
        for (Player player : players) {
            System.out.println(player);
        }
    }


    public static void main(String[] args) {
        Player user = new Mängija("Frodo");
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

        System.out.println("Juhend: ");
        user.printControls();


        System.out.println();

        boolean uusRaund = true;
        boolean jätkub = true;

        while (true){
            while (jätkub){

            }
            if (uusRaund) {
                Kaart diileriKaart = kaardipakk.annaKaart();
                diiler.addValue(diileriKaart);
                algseadistaLaud(kaardipakk, ainultMängijad);
                showTable(allPlayers);
                uusRaund = false;
            }
            Scanner scan = new Scanner(System.in);
            System.out.println();
            System.out.print("Sisesta valik: ");
            int valik = scan.nextInt();

            if (valik == 1){
                Kaart kaart = kaardipakk.annaKaart();
                System.out.println("Tõmbasid: " + kaart);
                user.addValue(kaart);
                showTable(allPlayers);

            }
            else if (valik == 2){
                for (Player player : playersAI) {
                    while (player.draw(player.getHandValue())){
                        Kaart kaart = kaardipakk.annaKaart();
                        player.addValue(kaart);
                    }
                }

                System.out.println("-------------------------------");
                showTable(allPlayers);
                System.out.println("-------------------------------");
                roundWinner(allPlayers);

                for (Player player : allPlayers) {
                    player.newHand();
                }
                uusRaund = true;

            }else if (valik == 3){
                System.out.println("Mäng läbi :)");
                break;
            }else if (valik == 4){
                System.out.println("Bla-bla-bla");
            }
            else if (valik == 5){
                user.printControls();
            }else {
                System.out.println("Ebasobiv sisend!");
                continue;
            };

        }
    }
}
