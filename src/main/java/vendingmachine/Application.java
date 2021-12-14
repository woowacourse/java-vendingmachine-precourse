package vendingmachine;

public class Application {
    public static void main(String[] args) {
        VendingMachineSystem vendingMachineSystem = VendingMachineSystem.getInstance();
        vendingMachineSystem.operate();
    }
}
