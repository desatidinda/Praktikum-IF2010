public class JSONHandler implements IHandler {
    public void writeRequest(RequestData data) {
        // IMPLEMENTASI DISINI
        System.out.println("Writing request in JSON format:");
        data.printInfo();
    }

    public void readRequest(RequestData data) {
        // IMPLEMENTASI DISINI
        System.out.println("Reading request in JSON format:");
        data.printInfo();
    }
}
