public class Ngabuburit {
    public static int maxSameActivity = 3;

    public ICommand command;
    public int jenuhCounter;

    /**
     * Constructor untuk melakukan Ngabuburit
     * 
     * @param command     Aktivitas yang ingin dilakukan
     */
    public Ngabuburit(ICommand command) {
        this.command = command;
        jenuhCounter = 0;
    }

    /**
     * Setter untuk mengubah aktivitas yang dilakukan
     * Counter jenuh akan kembali ke 0
     * 
     * @param command     Aktivitas yang ingin dilakukan
     */
    public void changeCommand(ICommand command) {
        this.command = command;
        jenuhCounter = 0;
    }

    /**
     * Setter untuk mengubah aktivitas yang dilakukan dengan argumen string. 
     * Counter jenuh akan kembali ke 0
     * Pilihan command adalah "laptop", "pintu", atau "rumah"
     * 
     * @param command     Aktivitas yang ingin dilakukan dalam string
     */
    public void changeCommandStr(String command) {
        switch (command) {
            case "pintu":
                changeCommand(new PintuCommand(new Pintu()));
                break;
            case "laptop":
                changeCommand(new LaptopCommand(new Laptop()));
                break;
            case "rumah":
                changeCommand(new RumahCommand(new Rumah()));
                break;
            default:
                break;
        }
        // if (command.equals("laptop")) {
        //     changeCommand(new LaptopCommand(new Laptop()));
        // }
        // else if (command.equals("pintu")) {
        //     changeCommand(new PintuCommand(new Pintu()));
        // }
        // else if (command.equals("rumah")) {
        //     changeCommand(new RumahCommand(new Rumah()));
        // }
    }

    /**
     * Method untuk melakukan aktivitas pada command. Jika command sudah dijalankan
     * lebih dari maxSameActivity, maka akan mencetak "Sudah jenuh! Lakukan aktivitas lain"
     * ke layar.
     */
    public void doStuff() {
        if (jenuhCounter >= maxSameActivity) {
            System.out.println("Sudah jenuh! Lakukan aktivitas lain");
        }
        else {
            command.execute();
            jenuhCounter++;
        }
    }
}
