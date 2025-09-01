/**
 * Handphone.java
 * Kelas handphone yang berisi data nama, harga, ram dan kelas ini merupakan parent class
 * @author 18223110 Desati Dinda Saraswati
 */

public abstract class Handphone {
    private String nama; // sama dengan merk
    private Integer harga;
    private Integer ram;

    public Handphone(String nama, Integer harga, Integer ram) {
        // Inisialisasi handphone dengan property terkait
        this.nama = nama;
        this.harga = harga;
        this.ram = ram;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public void printSpec() {
        // Mencetak spec dari handphone
        // spec dari handphone dicetak dalam format(diakhiri newline, tanpa spasi di
        // awal):
        // [nama] - Harga [harga], RAM [ram]
        System.out.println(nama + " - Harga " + harga + ", RAM " + ram);
    }

    public Boolean isBetterThan(Handphone otherHP) {
        // Mereturn true apabila RAM HP ini > RAM HP lain,
        // bila RAM sama, return true apabila Harga HP ini < Harga HP lain
        // return false dalam kasus lain
        if (ram > otherHP.getRam()) {
            return true;
        }
        else if (ram == otherHP.getRam()) {
            return (harga < otherHP.getHarga());
        }
        else {
            return false;
        }
    }

    // Melakukan penawaran terhadap HP terkait
    public abstract Boolean tawar(Integer hargaTawaran);

    // Mencetak apa yang membuat HP terkait spesial
    public abstract void printSpeciality();
}