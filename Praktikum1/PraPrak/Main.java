import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        CimolBojot[] cimol = new CimolBojot[3];
        for(int i = 0; i < 3; i++) {
            String namaMenu = scan.next();
            int harga = scan.nextInt();
            int stok = scan.nextInt();

            cimol[i] = new CimolBojot(namaMenu, harga, stok);
        }

        int kasAwal = scan.nextInt();
        Toko toko = new Toko(kasAwal);

        for(int i = 0; i < 3; i++) {
            toko.addCimolBojot(cimol[i]);
        }

        scan.nextLine(); //consume newline
        String jualCimol = scan.next();
        int jualBerapa = scan.nextInt();

        System.out.println(toko.sellCimolBojot(jualCimol, jualBerapa));

        System.out.println("Kas kasir sekarang: " + toko.getKas());
    }
}