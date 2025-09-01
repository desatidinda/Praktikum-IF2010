import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean error = false;

        try {
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            Password password = new Password(input);
            password.validate();
            scan.close();
        }
        catch (InvalidLengthException | InvalidPasswordException e) {
            System.out.println(e.getClass().getName() + "! " + e.getMessage());
            error = true;
        }
        catch (Exception e) {
            System.out.println(e.getClass().getName());
            error = true;
        }
        finally {
            if (error) {
                System.out.println("Password string error!");
            }
            else {
                System.out.println("true");
                System.out.println("Password validated.");
            }
            System.out.println("Operation finished.");
        }
    }
}