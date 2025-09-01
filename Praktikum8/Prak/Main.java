import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        int q = scan.nextInt();
        for (int i = 0; i < q; i++) {
            scan.nextLine();
            String command = scan.next();
            if (command.equals("tambah")) {
                String kata = scan.next();
                stack.push(kata);
                System.out.println("sudah menambahkan " + kata);
            }
            else if (command.equals("beli")) {
                if (!stack.empty()) {
                    System.out.println("telah membeli " + stack.peek());
                    stack.pop();
                }
                else {
                    System.out.println("maaf stock habis");
                }
            }
            else if (command.equals("lihat")) {
                if (!stack.empty()) {
                    System.out.println("print paling atas adalah " + stack.peek());
                }
                else {
                    System.out.println("maaf stock habis");
                }
            }
            else if (command.equals("habis?")) {
                if (!stack.empty()) {
                    System.out.println("masih ada kok");
                }
                else {
                    System.out.println("ya, habis");
                }
            }
        }
    }
}
