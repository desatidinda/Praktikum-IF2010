/**
 * Kartu.java
 * Kelas yang memodelkan Kartu dalam permainan Balala
 * 
 * @author 18223110 Desati Dinda Saraswati
 */

public class Kartu {
    // Deklarasi atribut
    private String suit;
    private String rank;
    private int multiplier;
    private static int jumlahKartu;

    /**
     * Konstruktor
     * 
     * @param suit
     * @param rank
     * @param multiplier
     */
    public Kartu(String suit, String rank, int multiplier) {
        this.suit = suit;
        this.rank = rank;
        this.multiplier = multiplier;
        jumlahKartu++;
    }

    /**
     * Konstruktor
     * 
     * @param suit
     * @param rank
     */
    public Kartu(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        this.multiplier = 1;
        jumlahKartu++;

        /**ALTERNATIF
         * this(suit, rank, 1)
         */
    }

    /**
     * Getter suit
     * 
     * @return suit
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Getter rank dalam bentuk nilai
     * - king, queen, jack bernilai 10
     * - ace bernilai 11
     * - selainnya bernilai sesuai angka kartu
     * 
     * Gunakan method string1.equals(string2) untuk memastikan nilai dua buah string
     * sama
     * 
     * @return rank
     */
    public int getRank() {
        if (rank.equals("king") || rank.equals("queen") || rank.equals("jack") || rank.equals("10")) { //cekdulu pake equals, kalo sama return angkanya
            return 10;
        }
        else if (rank.equals("ace")) {
            return 11;
        } 
        else {
            return Integer.parseInt(rank);
        }
    }

    /**
     * Getter multiplier
     * 
     * @return multiplier
     */
    public int getMultiplier() {
        return multiplier;
    }

    /**
     * @return total nilai kartu (rank * multiplier)
     */
    public int getKartuValue() {
        return getRank() * multiplier;
    }

    /**
     * Getter jumlahKartu
     * 
     * @return jumlahKartu yang ada
     */
    public static int getJumlahKartu() {
        return jumlahKartu; 
    }

    /**
     * Method untuk meningkatkan rank kartu, contohnya:
     * - king akan menjadi ace
     * - ace akan menjadi 2
     * - 10 akan menjadi jack
     */
    public void upgradeKartu() {
       String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};

        for (int i = 0; i < ranks.length; i++) {
            if (rank.equals(ranks[i])) {
                rank = ranks[(i + 1) % ranks.length];
                break;
            }
        }
    }
}