import java.util.HashMap;
import java.util.Scanner;

public class Blackjack {

    public static String roundWinner(Player[] players){
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
        return nimi;
    }

    public static void showTable(Player[] players){
        for (Player player : players) {
            System.out.println(player);
        }
    }

    public static void makeAiMove(Player[] arvuti, Kaardid pakk){
        for (Player player : arvuti) {
            Kaart kaart = pakk.annaKaart();
            int hand = player.getHandValue();
            if (player.draw(hand)){
                player.addValue(kaart);
            }
        }
    }

    public static void main(String[] args) {
        Player user = new Mängija("Frodo");
        Player arvuti1 = new arvutiPlayer("Thorin");
        Player arvuti2 = new arvutiPlayer("Gandalf");

        Player[] playersAI = {arvuti1, arvuti2};
        Player[] players = {user, arvuti1, arvuti2};

        Kaardid kaardipakk = new Kaardid();
        kaardipakk.algseadistaPakk(2);

        System.out.println("-------------------------------------");
        System.out.println("  TERE TULEMAST ÜKSIKUMÄE KASIINOSSE  ");
        System.out.println("   Tänaseks diileriks on Gandalf");
        System.out.println("   Täna on tulnud mängima ka Thorin   ");
        System.out.println("-------------------------------------");
        System.out.println("Juhend: ");
        user.printControls();

        showTable(players);
        System.out.println();

        while (true){
            Scanner scan = new Scanner(System.in);
            System.out.print("Sisesta valik: ");
            int valik = scan.nextInt();

            if (valik == 1){
                Kaart kaart = kaardipakk.annaKaart();
                System.out.println("Tõmbasid: " + kaart);
                user.addValue(kaart);
                System.out.println(user.toString());
            }
            else if (valik == 2){
                for (Player player : playersAI) {
                    while (player.draw(player.getHandValue())){
                        Kaart kaart = kaardipakk.annaKaart();
                        player.addValue(kaart);
                    }
                }

                System.out.println("-------------------------------");
                showTable(players);
                System.out.println("-------------------------------");
                System.out.println("Selle käe võitja oli:");
                System.out.println(roundWinner(players));
                for (Player player : players) {
                    player.newHand();
                }

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