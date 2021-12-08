package vendingmachine;

public class MachineController {
    private VendingMachine vendingMachine;

    public void run() {
        initMachine();
    }

    private void initMachine() {
        vendingMachine = new VendingMachine(inputAmount());
    }

    private int inputAmount() {
        while (true) {
            try {
                // validation
                return 1;
            } catch (IllegalArgumentException e) {
                System.out.println("invalid amount");
            }
        }
    }
}
