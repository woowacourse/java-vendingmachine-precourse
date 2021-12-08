package vendingmachine;

public class MachineController {
    private VendingMachine vendingMachine;

    public void run() {
        initMachine();
    }

    private void initMachine() {
        vendingMachine = new VendingMachine(0);
    }
}
