import java.util.Scanner;
import java.util.TreeSet;
import java.util.SortedSet;

public class Ngurut {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        SortedSet<Integer> set = new TreeSet<>();
        try {
            String x = scan.nextLine();
            String[] numbers = x.split(" ");
            for (int i = 0; i < numbers.length; i++) {
                set.add(Integer.parseInt(numbers[i]));
            }
            System.out.println(set);
        } catch (NumberFormatException e) {
            System.out.println("[]");
        }
        scan.close();
    }
}