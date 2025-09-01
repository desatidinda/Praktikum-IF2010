import java.util.Scanner;

public class TorrentDriver {

    private static void printSeparator() {
        System.out.println("------------");
    }

    /**
     * method helper untuk mencetak elemen array
     * @param array
     */
    private static void printArrayElements(Object[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(String.format("%s, ", array[i]));
        }
        if (array.length > 0) {
            System.out.println(array[array.length - 1]);
        }
    }

        /**
     * method helper untuk mencetak elemen array
     * @param array
     */
    private static void printArrayElements(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(String.format("%d, ", array[i]));
        }
        if (array.length > 0) {
            System.out.println(array[array.length - 1]);
        }
    }
    public static void main(String[] args) {
        /*
        * Kalian bisa mencoba menggunakan pendekatan kalian sendiri, petunjuk di bawah
        merupakan salah satu pendekatan yang dapat kalian ikuti.

         * Tahap 1
         * Hal yang perlu dilakukan yaitu:
         * Mengambil input nama file dan jumlah peer
         * 
         * TIPS: disarankan menggunakan Integer.parseInt(myScanner.nextLine()) untuk mengambil nilai input Integer 
         * secara aman dan mengurangi error atau masalah yang terjadi saat pembacaan input.
         */
        Scanner scan = new Scanner(System.in);
        String file = scan.nextLine();
        int jumlah = Integer.parseInt(scan.nextLine());

        /*
         *  Tahap 2
         *  Hal yang perlu dilakukan yaitu:
         *  - Mengambil input konten masing-masing peer
         *  - masing-masing peer memiliki atribut nama dengan format nama "PeerX" dengan X merupakan
         *  bilangan integer
         * 
         *  Contoh input jika kalian mengatur jumlah peer nya 4 adalah sebagai berikut:
         *  2 3 1 4
            5 9 6 7
            1 8
            7 5 2
         * 
         *  Masukkan input-input tersebut ke dalam array of TorrentPeer. untuk instansiasinya
         *  bisa mengikuti konstruktor yang telah disediakan
         * 
         *  TIPS: gunakan method split(separator) pada kelas String untuk men-split string menjadi array dengan
         *  pembagi elemen sesuai dengan input separator
         *  Contoh:
         *      String inputSaya = "1 2 3 4";
         *      String[] inputSplit = inputSaya.split(" ");  // inputSplit = ["1", "2", "3", "4"]
         * 
         *      // ubah semua elemennya menjadi integer
         *      int[] inputInteger = new int[inputSplit.length];
         *      for (int i = 0; i < inputSplit.length < i++) {
         *          inputInteger[i] = Integer.parseInt(inputSplit[i]);
         *      }
         */

        TorrentPeer[] peers = new TorrentPeer[jumlah];

        for (int i = 0; i < jumlah; i++) {
            String input = scan.nextLine();
            String[] chunks = input.split(" ");

            int[] chunksInt = new int[chunks.length];
            for (int j = 0; j<chunks.length; j++) {
                chunksInt[j] = Integer.parseInt(chunks[j]);
            }
            peers[i] = new TorrentPeer("Peer" + (i+1), chunksInt);
            System.out.print(peers[i].name + " memiliki chunk: ");
            printArrayElements(chunksInt);

        }
         /*
          * Tahap 3
            Hal yang perlu diperhatikan yaitu:
            - Masukkan chunk-chunk ke dalam sebuah array yang berisi chunk-chunk unik. misalnya pada contoh yang diberikan,
            terdapat total 13 chunk yang dimiliki oleh 4 peer, namun total chunk unik keseluruhannya adalah 9
            - array chunk unik tersebut nantinya akan digunakan untuk mengunduh secara urut chunk-chunk tersebut sehingga
            menghasilkan hasil rekonstruksi file yang valid
            - Kalian juga perlu men-track jumlah chunk unik yang ada karena diperlukan juga pada salah satu print statement
            
            CATATAN:
            berdasarkan catatan dari deskripsi soal, maksimal jumlah chunk unik yang dimiliki oleh seluruh peer yaitu
            100. untuk itu, kalian bisa membuat set sederhana menggunakan array of boolean dengan indeks array sebagai key
            dari chunk kalian.

                boolean[] uniqueChunks = new boolean[100];
            
            TIPS:
            - Untuk mengecek duplikasi, kalian bisa mengecek apakah uniqueChunks[key] true atau false
          */ 
        boolean[] uniqueChunks = new boolean[100];
        int chunksIdx = 0;
  
        for (TorrentPeer peer : peers) {
            for (int chunk : peer.chunks) {
                uniqueChunks[chunk] = true;
                if (chunk > chunksIdx) {
                    chunksIdx = chunk;
                }
            }
        }
        int unik = 0;
        for(int i = 1; i <= chunksIdx; i++) {
            if(uniqueChunks[i]) {
                unik++;
            }
        }
        printSeparator();

          // Tahap 4
          // Buat sebuah StringBuilder yang berfungsi sebagai rekonstruktor file torrent yang diunduh
          // untuk setiap chunk yang diunduh, append string "[Chunk-i]" ke dalam rekonstruktor file dengan
          // memanfaatkan method append() pada StringBuilder di mana i merupakan indeks chunk yang diunduh pada saat itu
          // 
          // Contoh 1:
          //    StringBuilder sb = new StringBuilder("Hello");
          //    sb.append(" World!");
          //    System.out.println(sb); // output: "Hello World!"
          //
          // Contoh 2:
          //    StringBuilder builder = new StringBuilder();
          //    builder.append("Oke");
          //    System.out.println(builder); // Output: "Oke"
          //    builder.append(" Gas");
          //    System.out.println(builder); // Output: "Oke Gas"
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= chunksIdx; i++){
            if(uniqueChunks[i]){
                for(TorrentPeer peer : peers){
                    if(peer.hasChunk(i)){
                        System.out.println("Mengunduh chunk " + i + " dari " + peer.name + "...");
                        sb.append("[Chunk-" + i + "]");
                        break;
                    }
                }
            }
        }
          /*
           * Catatan tambahan:
           * - Pada contoh output yang diberikan pada deskripsi soal, terdapat
           *  output "------------" yang merupakan separator.
           * - Gunakan method static printSeparator() untuk mencetak separator tersebut pada output
           * - Kalian bebas menggunakan method helper yang telah disediakan dalam pengerjaan soal
           * - Jangan lupa close scannernya untuk mencegah resource/memory leak
           */
        printSeparator();
  
        System.out.println("Semua chunk berhasil diunduh!");
        System.out.println("Menyusun kembali file...");
        System.out.println("File " + file + " berhasil direkonstruksi dari " + unik + " chunk.");
        System.out.println("Isi rekontruksi file: " + sb.toString());
        scan.close();
    }    
}