/**
 * Toko.java
 * Kelas toko ini merupakan apaan ya gatau pokonya ya dia buat jualan si cimol
 * 
 * @author 18223110 Desati Dinda Saraswati
 */


public class Toko {
    // Deklarasi atribut
    private CimolBojot[] cimolBojotArray;
    private int kas; 
    private static final int MAX_CIMOL = 3;
    private int cimolCount;

    public Toko(int initialKas) {
       this.kas = initialKas;
       this.cimolBojotArray = new CimolBojot[MAX_CIMOL];
       this.cimolCount = 0;
    }

    public int getKas() {
        return kas;
    }

    public void addCimolBojot(CimolBojot cimolBojot) {
        if (cimolCount < MAX_CIMOL) {
            cimolBojotArray[cimolCount] = cimolBojot;
            cimolCount++;
        }
    }

    public int findCimolBojotIndexByName(String namaMenu) {
        for (int i = 0; i < cimolCount; i++) {
            if (cimolBojotArray[i].getNamaMenu().equals(namaMenu)) {
                return i;
            }
        }
        return -1;
    }


    public String sellCimolBojot(String namaMenu, int quantity) {
        for (int i = 0; i < MAX_CIMOL; i++) {
            if (cimolBojotArray[i].getNamaMenu().equals(namaMenu)) {
                cimolBojotArray[i].setStok(cimolBojotArray[i].getStok() - quantity);
                kas += (cimolBojotArray[i].getHarga() * quantity);
                return "Berhasil menjual cimol " + namaMenu + " sebanyak " + quantity;
            }
        }
        return "Stok tidak cukup";
    }
}