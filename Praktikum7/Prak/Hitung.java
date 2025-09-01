public class Hitung {
    static final int NUM_OF_THREAD = 10;

    public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Lengkapi method ini untuk mencari bilangan prima dari [0, N]. Wajib menggunakan conccurency!

    // Di dalam method run() dalam runnable sertakan pemanggilan ThreadTracker.mark();
    // Jika tidak, atau jika tidak menggunakan conccurency maka kode akan terus runtime error!

    public int hitungPrima(int N) throws InterruptedException {
        Thread[] threads = new Thread[NUM_OF_THREAD];
        int initialSize = N / NUM_OF_THREAD;
        int remainder = N % NUM_OF_THREAD;

        int start = 0;
        int[] sum = {0};

        for (int i = 0; i < NUM_OF_THREAD; i++) {
            int size = initialSize + (i < remainder ? 1 : 0);
            int end = start + size;

            int tempStart = start;
            int tempEnd = end;

            if (tempStart < N) {
                threads[i] = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ThreadTracker.mark();
                        int localSum = 0;
                    
                        for (int j = tempStart; j < tempEnd && j < N; j++) {
                            if (isPrime(j)) {
                                localSum++;
                            }
                        }
                        synchronized (Hitung.this) {
                            sum[0] += localSum;
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

        return sum[0];
    }
}