package vendingmachine;

public class Application {
    public static void main(String[] args) {
        setUp().on();
    }

    private static VendingMachineController setUp() {
        return new VendingMachineController(new VendingMachineService());
    }
}
