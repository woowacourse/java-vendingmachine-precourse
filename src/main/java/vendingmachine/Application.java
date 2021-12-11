package vendingmachine;

public class Application {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        OutputManager outputManager = new OutputManager();
        VendingMachine vendingMachine = inputManager.setVendingMachine();
        outputManager.printVendingMachineStatus(vendingMachine);
    }
}
