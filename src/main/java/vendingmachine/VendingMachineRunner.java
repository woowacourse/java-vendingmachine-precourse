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

        addProducts(vendingMachine);
        System.out.println(vendingMachine.getProducts());
    }

    private VendingMachine initializeVendingMachine() {
        while (true) {
            try {
                ConsolePrinter.print(Message.INPUT_VENDING_MACHINE_HOLDING_MONEY.getMessage());
                return new VendingMachine(Coins.createRandomCoins(input.inputInteger()));
            } catch (IllegalArgumentException exception) {
                ConsolePrinter.print(exception.getMessage());
            }
        }
    }

    private VendingMachine addProducts(VendingMachine vendingMachine) {
        while (true) {
            ConsolePrinter.print(Message.INPUT_PRODUCT.getMessage());
            vendingMachine.addAll(new ProductArgumentResolver(input.inputString()).resolve());
            return vendingMachine;
        }
    }
}
