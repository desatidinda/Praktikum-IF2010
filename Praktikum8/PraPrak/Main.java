import java.util.TreeSet;
import java.util.Scanner;

// jadi kita mau buat program operasi pada triset yh guiz

public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        Scanner scan = new Scanner(System.in);
        Integer Q = scan.nextInt();
        for (int i = 0; i < Q; i++) {
            scan.nextLine();
            String operation = scan.next();
            if (operation.equals("add")) {
                int X = scan.nextInt();
                treeSet.add(X);
            }
            else if (operation.equals("remove")) {
                int X  = scan.nextInt();
                if (treeSet.contains(X)) {
                    treeSet.remove(X);
                }
                else {
                    System.out.println("Element " + X + " is not in The TreeSet");
                }
            }
            else if (operation.equals("first")) {
                if (treeSet.isEmpty() == false) {
                    System.out.println(treeSet.first());
                }
                else {
                    System.out.println("EMPTY");
                }
            }
            else if (operation.equals("last")) {
                if (treeSet.isEmpty() == false) {
                    System.out.println(treeSet.last());
                }
                else {
                    System.out.println("EMPTY");
                }
            }
        }
        scan.close();
    }
}
