public class Tester {
    public static void main(String[] args) {
        System.out.println("\n=== Swordman & SwordSaint ===");
        Swordman zoro = new Swordman("Zoro", "Enma");
        zoro.tebas();

        SwordSaint reinhard = new SwordSaint("Reinhard");
        reinhard.tebas();

        System.out.println("\n=== Penyihir ===");
        Penyihir emilia = new Penyihir("Emilia", 100);
        emilia.gunakanSihir(30);
        emilia.mengisiMana(10);
        emilia.gunakanSihir(100); // gagal

        System.out.println("\n=== Witch ===");
        Witch echidna = new Witch("Echidna", 100, "Greed");
        echidna.gunakanSihir(40);
        echidna.mengisiMana(50);
        echidna.gunakanSihir(150); // gagal

        System.out.println("\n=== Subaru ===");
        Subaru subaru = new Subaru();
        subaru.perkenalan();
        subaru.mati();
        subaru.mati("Kastil Roswaal");
        subaru.mati();
    }
}
