import java.util.*;

/**
 * Main.java
 * 
 * @author 18223110 Desati Dinda Saraswati
 */

public class Main {
    /**
     * Mengecek apabila kartu memiliki nilai 10, J, Q, K, A
     * 
     * @param cards
     * @return true apabila kartu memiliki 10 sampai As, false sebaliknya
     */
    public static boolean isRoyal(String[] cards) {
        boolean foundT = false;
        boolean foundJ = false;
        boolean foundQ = false;
        boolean foundK = false;
        boolean foundA = false;

        if (isFlush(cards)) {
            for (int i = 0; i < 5; i++) {
                if (cards[i].charAt(1) == 'T') {
                    foundT = true;
                }
                if (cards[i].charAt(1) == 'J') {
                    foundJ = true;
                }
                if (cards[i].charAt(1) == 'Q') {
                    foundQ = true;
                }
                if (cards[i].charAt(1) == 'K') {
                    foundK = true;
                }
                if (cards[i].charAt(1) == 'A') {
                    foundA = true;
                }
            }    
        }
        else {
            return false;
        }

        return (foundT && foundJ && foundQ && foundK && foundA);
    }

    /**
     * Mengecek apabila kartu dapat membentuk Full House
     * 
     * @param cards
     * @return true apabila kartu dapat membentuk Full House, false sebaliknya
     */
    public static boolean isFullHouse(String[] cards) {
        int[] countAngka = {countSama(cards, '2'), countSama(cards, '3'), countSama(cards, '4'),
                            countSama(cards, '5'), countSama(cards, '6'), countSama(cards, '7'),
                            countSama(cards, '8'), countSama(cards, '9'), countSama(cards, 'T'),
                            countSama(cards, 'J'), countSama(cards, 'Q'), countSama(cards, 'K'),
                            countSama(cards, 'A')};
        boolean adaTiga = false;
        boolean adaDua = false;

        for(int i = 0; i < 13; i++) {
            if (countAngka[i] == 3) {
                adaTiga = true;
            }
        }
        for(int i = 0; i < 13; i++) {
            if (countAngka[i] == 2) {
                adaDua = true;
            }
        }
        return (adaTiga && adaDua);
    }

    /**
     * Mengecek apabila kartu dapat membentuk Flush
     * 
     * @param cards
     * @return true apabila kartu dapat membentuk Flush, false sebaliknya
     */
    public static boolean isFlush(String[] cards) {
        if ((cards[0].charAt(0) == cards[1].charAt(0)) && cards[1].charAt(0) == cards[2].charAt(0) && cards[2].charAt(0) == cards[3].charAt(0) && cards[3].charAt(0) == cards[4].charAt(0)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Menghitung udah ada berapa angka tersebut dalam satu set
     */
    public static int countSama(String[] cards, char angka) { 
        int count = 0;
        for(int i = 0; i < 5; i++) {
            if (cards[i].charAt(1) == angka) {
                count++;
            }
        }
        return count;
    }
    /**
     * Mengembalikan rangking dari set yang dimiliki dengan rangking berikut:
     * - Royal Flush: 3
     * - Full House: 2
     * - Flush: 1
     * - High Card: 0
     * 
     * @param cards
     * @return rangking
     */
    public static int getSetRanking(String[] cards) {
        if (isRoyal(cards)) {
            return 3;
        }
        else if (isFullHouse(cards)) {
            return 2;
        }
        else if (isFlush(cards)) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        String[] cardsTuanBil = new String[5];
        String[] cardsTuanMask = new String[5];
        Scanner scan = new Scanner(System.in);

        /* YOUR CODE HERE */
        for(int i = 0; i < 5; i++) {
            cardsTuanBil[i] = scan.nextLine();
        }
        for(int i = 0; i < 5; i++) {
            cardsTuanMask[i] = scan.nextLine();
        }

        int bil = getSetRanking(cardsTuanBil);
        int mask = getSetRanking(cardsTuanMask);

        if (bil > mask) {
            System.out.println("Tuan Bil");
            System.out.println(bil);
        }
        else if (bil < mask) {
            System.out.println("Tuan Mask");
            System.out.println(mask);
        }
        else if (bil == mask) {
            System.out.println("Seri");
            System.out.println(bil);
        }
    }
}