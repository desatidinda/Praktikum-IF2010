/**
 * Pipo.java
 * Kelas Pipo merupakan turunan dari kelas Handphone
 * @author 18223110 Desati Dinda Saraswati
 */

public class Pipo extends Handphone {
	private String camera;

	public Pipo(String camera) {
		// Sesuai dengan Soal
        super("Pipo", 3000000, 3);
        this.camera = camera;
	}

	@Override
	public Boolean tawar(Integer hargaTawaran) {
		// Sesuai dengan soal
        return (hargaTawaran >= 2500000);
	}

	@Override
	public void printSpeciality() {
		// Print (tanpa tanda kutip, diakhiri newline):
		// "Kamera ni HP " + camera
        System.out.println("Kamera ni HP " + camera);
	}
}