/**
 * Apel.java
 * Kelas Apel merupakan turunan dari kelas Handphone
 * @author 18223110 Desati Dinda Saraswati
 */

public class Apel extends Handphone {
	public Apel() {
		// Sesuai dengan Soal
        super("Apel", 10000000, 6);
	}

	@Override
	public Boolean tawar(Integer hargaTawaran) {
		// Sesuai dengan soal
        return false;
	}

	@Override
	public void printSpeciality() {
		// Print (tanpa tanda kutip, diakhiri newline):
		// "Stylish nih bos"
        System.out.println("Stylish nih bos");
	}
}