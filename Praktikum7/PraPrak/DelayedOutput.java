/**
 * DelayedOutput.java 
 * [Jelaskan kegunaan class ini]
 * @author 18223110 Desati Dinda Saraswati
 */
public class DelayedOutput {
  public static void printDelayed(int delayMillisec, String output) {
      // TODO print output setelah di delay selama delayMillisec
      // PENTING: gunakan threading agar tidak blocking
      Thread thread = new Thread(new Runnable() {
          @Override 
          public void run() {
              try {
                  Thread.sleep(delayMillisec);
                  System.out.println(output);
              }
              catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      });
      thread.start();
  }
}