public class DelayedNumber {
    public static void printDelayed(int delayMillisec, int maxnum) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(delayMillisec);
                    for (int i = 0; i < maxnum; i++) {
                        System.out.println(i);
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        });
        thread.start();
    }
}
