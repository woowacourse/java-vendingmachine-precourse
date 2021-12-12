package vendingmachine;


public class VendingMachineRunner implements Runnable {
    private final Input input;

    public VendingMachineRunner(Input input) {
        this.input = input;
    }

    @Override
    public void run() {
        VendingMachine vendingMachine = initializeVendingMachine(input.inputInteger());
        ConsolePrinter.print(vendingMachine.getCoins(), Message.VENDING_MACHINE_INFORMATION);
    }

    private VendingMachine initializeVendingMachine(int money) {
        while (true) {
            System.out.println(Message.INPUT_VENDING_MACHINE_HOLDING_MONEY.getMessage());
            return new VendingMachine(Coins.createRandomCoin(money));
        }
    }
}
