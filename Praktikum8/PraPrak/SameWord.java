import java.util.*;

public class SameWord {
    public static List<String> findCommonElements(List<String> list1, List<String> list2) {
        List<String> commonElements = new ArrayList<>();
        for (String word1 : list1) {
            for (String word2 : list2) {
                if (word1.equals(word2) && !commonElements.contains(word1)) {
                    commonElements.add(word1);
                }
            }
        }
        return commonElements;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String firstlist = scan.nextLine();
        String secondlist = scan.nextLine();
        scan.close();
        List<String> list1 = Arrays.asList(firstlist.split(" "));
        List<String> list2 = Arrays.asList(secondlist.split(" "));

        List<String> commonElements = findCommonElements(list1, list2);
        if (commonElements.isEmpty()) {
            System.out.println("Tidak ada kata yang sama");
        } else {
            System.out.println("Kata yang sama: " + String.join(", ", commonElements));
        }
    }
}
