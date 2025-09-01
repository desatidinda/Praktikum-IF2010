import java.util.ArrayList;

public class ComplexWordCountServer {

    private int nWorkers;

    // masukkan arraylist of string dipastikan berupa alfabet lowercase saja
    private ArrayList<String> array;

    // hasil pada method countSpecialString akan disimpan pada res
    int[] res = new int[26];

    ComplexWordCountServer(int nWorkers, ArrayList<String> array) {
        // Inisialisasi attributes
        this.nWorkers = nWorkers;
        this.array = array;
    }

    public void countSpecialString() throws InterruptedException {
        // calculateSum akan membuat thread untuk setiap string
        // setiap thread kemudian akan memanggil metode characterCountHelper
        // lalu hasil dari Array Mapping yang dikembalikan oleh metode characterCountHelper akan digunakan
        // untuk ditambahkan ke attribut res
        Thread[] threads = new Thread[nWorkers];
        int x = array.size() / nWorkers;
        int start = 0;

        for (int i = 0; i < nWorkers; i++) {
            int end = start + x;
            if (i == nWorkers - 1) {
                end = array.size();
            }
            ArrayList<String> subArray = new ArrayList<>(array.subList(start, end));
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    for (String str : subArray) {
                        int[] charCount = characterCountHelper(str);
                        synchronized (res) {
                            for (int j = 0; j < 26; j++) {
                                res[j] += charCount[j];
                            }
                        }
                    }
                }
            });
            threads[i].start();
            start += x;
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }

    protected int[] characterCountHelper(String str) {
        // Menghitung berapa banyak occurence dari suatu karakter pada suatu string
        // lalu dipetakan pada suatu array of integer

        // HINT : untuk memetakan suatu karakter ke array of integer, anda bisa melakukan arr[c-'a']
        // sehingga apabila variable c merupakan karakter 'a', value dari c-'a' menjadi 0, begitupun
        // dengan karakter alfabet lainnya
        int[] charCount = new int[26];
        for (char c : str.toCharArray()) {
            charCount[c - 'a']++;
        }
        return charCount;
    }

    public String toString() {
        // menampilkan berapa banyak kata spesial "one", "two" dan "three"
        // format keluaran dari fungsi ini adalah "one : {one_occurence}, two : {two_occurence}, three : {three_occurence}"
        // lalu diakhiri dengan newline
        int one_occurence = Math.min(res['o' - 'a'], Math.min(res['n' - 'a'], res['e' - 'a']));
        for (int i = 0; i < one_occurence; i++) {
            res['o' - 'a']--;
            res['n' - 'a']--;
            res['e' - 'a']--;
        }
        int two_occurence = Math.min(res['t' - 'a'], Math.min(res['w' - 'a'], res['o' - 'a']));
        for (int i = 0; i < two_occurence; i++) {
            res['t' - 'a']--;
            res['w' - 'a']--;
            res['o' - 'a']--;
        }
        int three_occurence = Math.min(res['t' - 'a'],
                Math.min(res['h' - 'a'], Math.min(res['r' - 'a'], (res['e' - 'a'] / 2))));
        for (int i = 0; i < three_occurence; i++) {
            res['t' - 'a']--;
            res['h' - 'a']--;
            res['r' - 'a']--;
            res['e' - 'a']--;
            res['e' - 'a']--;
        }
        return String.format("one : %d, two : %d, three : %d\n", one_occurence, two_occurence, three_occurence);
    }
}