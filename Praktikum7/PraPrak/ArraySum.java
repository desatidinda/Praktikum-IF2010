/**
 * Jangan lupa tambahkan kata kunci yang dibutuhkan
 */ 

public class ArraySum {
    private int nWorkers;
    private Integer[] arr;
    private int sum = 0;
    /**
     * Tambahkan atribut kelas yang dibutuhkan
     */ 

    /**
     * Konstruktor
     * Inisialisasi atribut kelas
     */
    ArraySum(int nWorkers, Integer[] arr) {
        this.nWorkers = nWorkers;
        this.arr = arr;
    }

    /**
     * Implementasi
     * method sum akan membuat sejumlah thread dan memetakan array masukan secara merata ke semua threads yang dapat dibuat
     */
    public int sum() throws InterruptedException {
        Thread[] threads = new Thread[nWorkers];
        int length = arr.length;
        int initialSize = length / nWorkers;
        int remainder = length % nWorkers;

        int start = 0;

        for (int i = 0; i < nWorkers; i++) {
            int size = initialSize + (i < remainder ? 1 : 0);
            int end = start + size;

            int tempStart = start;
            int tempEnd = end;

            if (tempStart < length) {
                threads[i] = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int partial = partialSum(tempStart, tempEnd);
                        synchronized (ArraySum.this) {
                            sum += partial;
                        }
                    }
                });
                threads[i].start();
            }
            start = end;
        }

        for (Thread thread : threads) {
            if (thread != null) thread.join();
        }

        return sum;
    }

    /**
     * Implementasi
     * method partialSum akan melakukan penjumlahan elemen-elemen array pada index `start` sampai `end-1`
     */
    protected int partialSum(int start, int end) {
        int sum = 0;

        for (int i = start; i < end; i++) {
            sum += arr[i];
        }

        return sum;
    }
}