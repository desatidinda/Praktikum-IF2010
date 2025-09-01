public class Eraphone {
    public static void main(String[] args) {
        Handphone hp1 = new Apel();
        Handphone hp2 = new Pipo("48MP");
        Handphone hp3 = new Huawoi(true);
        Handphone hp4 = new Huawoi(false);

        hp1.printSpec();
        hp1.printSpeciality();
        System.out.println(hp1.tawar(9000000)); // Harus false

        hp2.printSpec();
        hp2.printSpeciality();
        System.out.println(hp2.tawar(2500000)); // Harus true
        System.out.println(hp2.tawar(2400000)); // Harus false

        hp3.printSpec();
        hp3.printSpeciality();
        System.out.println(hp3.tawar(1500000)); // Harus true
        System.out.println(hp3.tawar(900000));  // Harus false

        hp4.printSpec();
        hp4.printSpeciality();
        System.out.println(hp4.tawar(4500000)); // Harus true
        System.out.println(hp4.tawar(3500000)); // Harus false
    }
}
