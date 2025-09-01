/**
 * Huawoi.java
 * Kelas Huawoi merupakan turunan dari kelas Handphone
 * @author 18223110 Desati Dinda Saraswati
 */

public class Huawoi extends Handphone {
	private Boolean isKW;

	public Huawoi(Boolean isKW) {
		// Sesuai dengan Soal
        super("Huawoi", 0, 0);
        this.isKW = isKW;
        if (isKW) {
            setNama("Huawoi KW");
            setHarga(2000000);
            setRam(2);
        }
        else {
            setHarga(5000000);
            setRam(4);
        }
	}

    @Override
	public Boolean tawar(Integer hargaTawaran) {
		// Sesuai dengan soal
        return hargaTawaran >= getHarga() - 1000000;
	}

	@Override
	public void printSpeciality() {
		// Bila isKW = true, Print (tanpa tanda kutip, diakhiri newline) "HPnya murah
		// bos"
		// Bila isKW = false, Print (tanpa tanda kutip, diakhiri newline) "Speknya
		// kenceng bos"
        if (isKW) {
            System.out.println("HPnya murah bos");
        }
        else {
            System.out.println("Speknya kenceng bos");
        }
	}
}