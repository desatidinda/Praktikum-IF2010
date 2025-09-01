import java.util.Scanner;

public class Main {
    /**
     * Fungsi utama dari program kalkulator Hexaesar.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mode = scanner.nextInt();
        scanner.nextLine();

        String pesan = scanner.nextLine().trim();
        int key = scanner.nextInt();

        try {
            switch(mode) {
                case 1:
                    if (!pesan.matches("[0-9A-Fa-f]+")) {
                        System.out.println("Invalid hexadecimal string");
                        break;
                    }
                    System.out.println(Hexaesar.encrypt(pesan, key));
                    break;
                case 2:
                    if (!pesan.matches("[0-9A-Fa-f]+")) {
                        System.out.println("Invalid hexadecimal string");
                        break;
                    }
                    System.out.println(Hexaesar.decrypt(pesan, key));
                    break;
                case 3:
                    try {
                        int plainInt = Integer.parseInt(pesan);
                        if (plainInt < 0) {
                            System.out.println("Number must be non-negative");
                            break;
                        }
                        try {
                            System.out.println(Hexaesar.encrypt(plainInt, key));
                        } catch (NumberFormatException e) {
                            System.out.println("Resulting encrypted value is too large for an integer.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format for input.");
                    }
                    break;
                case 4:
                    try {
                        int encryptedInt = Integer.parseInt(pesan);
                        if (encryptedInt < 0) {
                            System.out.println("Number must be non-negative");
                            break;
                        }
                        try {
                            System.out.println(Hexaesar.decrypt(encryptedInt, key));
                        } catch (NumberFormatException e) {
                            System.out.println("Resulting decrypted value is too large for an integer.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format for input.");
                    }
                    break;
                default:
                    System.out.println("Mode tidak valid");
                    break;
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}