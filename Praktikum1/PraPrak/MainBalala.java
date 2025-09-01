/**
 * MainBalala.java
 * Program yang akan menghitung skor akhir dari setiap blind permainan balala dan menetukan menang atau kalah
 * 
 * @author 18223110 Desati Dinda Saraswati
 */

import java.util.Scanner;

public class MainBalala {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Kartu[] kartu = new Kartu[5];

        for (int i = 0; i < 5; i++) {
            String suit = scan.next();
            String rank = scan.next();
            int multiplier = scan.nextInt();

            kartu[i] = new Kartu(suit, rank, multiplier);
        }

        int joker = scan.nextInt();
        int target = scan.nextInt();

        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                System.out.print("Kartu pertama punya suit ");
            }
            else if (i == 1) {
                System.out.print("Kartu kedua punya suit ");
            }
            else if (i == 2) {
                System.out.print("Kartu ketiga punya suit ");
            }
            else if (i == 3) {
                System.out.print("Kartu keempat punya suit ");
            }
            else if (i == 4) {
                System.out.print("Kartu kelima punya suit ");
            }
            System.out.println(kartu[i].getSuit() + " dengan rank " + kartu[i].getRank() + " dan multiplier " + kartu[i].getMultiplier());

        }

        Blind balala = new Blind(kartu[0], kartu[1], kartu[2], kartu[3], kartu[4], joker, target);
        System.out.println("Skor akhir : " + balala.calculateTotalScore());
        if (balala.isWin()) {
            System.out.println("MENANG!");
        }
        else {
            System.out.println("KALAH!");
        }
    }
}