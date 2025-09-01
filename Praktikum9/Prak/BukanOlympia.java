import java.util.ArrayList;
import java.util.Scanner;

public class BukanOlympia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            String namaBahasa = scanner.nextLine();
            int jumlahFile = scanner.nextInt();
            scanner.nextLine();
            
            ArrayList<String> files = new ArrayList<>();
            for (int i = 0; i < jumlahFile; i++) {
                files.add(scanner.nextLine());
            }
            
            Bahasa bahasa;
            try {
                bahasa = BahasaFactory.getBahasaRunner(namaBahasa, files);
            } catch (BahasaError e) {
                System.out.println(e.getMessage());
                return;
            }
            
            try {
                bahasa.compile();
            } catch (BahasaError e) {
                System.out.println(e.getMessage());
                return;
            }
            
            int jumlahTestcase = scanner.nextInt();
            scanner.nextLine();
            
            for (int i = 0; i < jumlahTestcase; i++) {
                String line = scanner.nextLine();
                String[] testcase = line.split(" ");
                
                String inputFilename = testcase[0].trim();
                String outputFilename = testcase[1].trim();
                
                try {
                    bahasa.grade(inputFilename, outputFilename);
                } catch (BahasaError e) {
                    System.out.println(e.getMessage());
                }
            }
        } finally {
            scanner.close();
        }
    }
}