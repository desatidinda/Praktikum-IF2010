import java.util.*;

public class Soal2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] value = new int[5];
        int count = 0;

        for(int i = 0; i < 5; i++) {
            value[i] = scan.nextInt();
            count += value[i];
        }
        int mul = scan.nextInt();
        int booster = scan.nextInt();

        if (booster == 1) {
            System.out.println(mul * 2 * count);
        }
        else if (booster == 2) {
            System.out.println(mul * 3 * count);
        }
        else {
            System.out.println(mul * count);
        }
    }
}