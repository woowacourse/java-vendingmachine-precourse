package vendingmachine;


public class VendingMachineRunner implements Runnable {
    private final Input input;

    public VendingMachineRunner(Input input) {
        this.input = input;
    }

    @Override
    public void run() {
        VendingMachine vendingMachine = initializeVendingMachine();
        ConsolePrinter.print(vendingMachine.getCoins(), Message.VENDING_MACHINE_INFORMATION);
    }

    private VendingMachine initializeVendingMachine() {
        while (true) {
            try {
                ConsolePrinter.print(Message.INPUT_VENDING_MACHINE_HOLDING_MONEY.getMessage());
                return new VendingMachine(Coins.createRandomCoin(input.inputInteger()));
            } catch (IllegalArgumentException exception) {
                ConsolePrinter.print(exception.getMessage());
            }
        }
    }
}
