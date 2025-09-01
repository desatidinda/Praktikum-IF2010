public class DelayedCharacter {
    public static void printDelayed(int delayMillisec, String output) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(delayMillisec);
                    for (int i = 0; i < output.length(); i++) {
                        System.out.println(output.charAt(i));
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
