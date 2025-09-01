import java.util.ArrayList;

public class BahasaUlar extends Bahasa {
    public BahasaUlar(ArrayList<String> files) {
        super(files);
        extention = ".piton";
    }

    public void compile() throws BahasaError {
        /* Tambahkan error checking disini */
        for (String i : files) {
            if (!i.contains(extention)) {
                throw new WrongExtentionException(extention, i);
            }
        }
        
        System.out.println();
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

        System.out.println("piton " + removeExtention(files.get(0)) + " < " + inputFilename + " > " + outputFilename);
    }
}
