import java.util.ArrayList;

public class BahasaC extends Bahasa {
    public BahasaC(ArrayList<String> files) {
        super(files);
        extention = ".c";
    }

    public void compile() throws BahasaError {
        /* Tambahkan error checking disini */
        for (String i : files) {
            if (!i.contains(extention)) {
                throw new WrongExtentionException(extention, i);
            }
        }

        System.out.println("gcc -o " + removeExtention(files.get(0)) + " " + String.join(" ", files));
    }

    public void grade(String inputFilename, String outputFilename) throws BahasaError {
        /* Tambahkan error checking disini */
        if (!inputFilename.contains(".in")) {
            throw new WrongExtentionException(".in", inputFilename);
        }
        else if (!outputFilename.contains(".out")) {
            throw new WrongExtentionException(".out", inputFilename);
        }

        String input = removeExtention(inputFilename);
        String output = removeExtention(outputFilename);

        if (!input.equals(output)) {
            throw new TestcaseMismatchException(inputFilename, outputFilename);
        }

        System.out.println("./" + removeExtention(files.get(0)) + " < " + inputFilename + " > " + outputFilename);
    }
}
