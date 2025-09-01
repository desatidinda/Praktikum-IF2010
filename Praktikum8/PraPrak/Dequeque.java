import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Dequeque {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean reverse = false;
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int q = scan.nextInt();

        for (int i = 0; i < q; i++) {
            String command = scan.next();
            if (command.equals("addFirst")) {
                int x = scan.nextInt();
                if (!reverse) {
                    deque.addFirst(x);
                }
                else {
                    deque.addLast(x);
                }
            }
            else if (command.equals("addLast")) {
                int x = scan.nextInt();
                if (!reverse) {
                    deque.addLast(x);
                }
                else {
                    deque.addFirst(x);
                }
            }
            else if (command.equals("pollFirst")) {
                if (deque.isEmpty()) {
                    System.out.println("EMPTY");
                }
                else if (!reverse) {
                    System.out.println(deque.pollFirst().toString());
                }
                else {
                    System.out.println(deque.pollLast().toString());
                }
            }
            else if (command.equals("pollLast")) {
                if (deque.isEmpty()) {
                    System.out.println("EMPTY");
                }
                else if (!reverse) {
                    System.out.println(deque.pollLast().toString());
                }
                else {
                    System.out.println(deque.pollFirst().toString());
                }
            }
            else if (command.equals("reverse")) {
                reverse = !reverse;
            }
        }
        scan.close();
    }
}
