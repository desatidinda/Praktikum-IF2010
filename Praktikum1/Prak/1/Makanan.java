/**
 * Makanan.java
 * Kelas Makanan berisi data lauk, nasi, dan minuman untuk yayasan amal Tuan Jip
 * @author 18223110 Desati Dinda Saraswati
 */

class Makanan {
    // Deklarasi atribut
    private String lauk;
    private int nasi;
    private String minuman;

    /**
     * Konstruktor
     * @param lauk Lauk dari makanan
     * @param nasi Berat nasi (dalam gram)
     * @param minuman Jenis minuman
     */
    public Makanan(String lauk, int nasi, String minuman) {
        this.lauk = lauk;
        this.nasi = nasi;
        this.minuman = minuman;
    }

    /**
     * Getter atribut lauk
     * @return lauk
     */
    public String getLauk() {
        return lauk;
    }

    /**
     * Getter atribut nasi
     * @return nasi
     */
    public int getNasi() {
        return nasi;
    }

    /**
     * Getter atribut minuman
     * @return minuman
     */
    public String getMinuman() {
        return minuman;
    }

}






