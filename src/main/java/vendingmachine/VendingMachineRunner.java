package vendingmachine;

public class VendingMachineRunner implements Runnable {
    private final Input input;

    public VendingMachineRunner(Input input) {
        this.input = input;
    }

    @Override
    public void run() {
        processBuyProduct(addProducts(initializeVendingMachine()), new Order(inputAmount()));
    }

    private VendingMachine initializeVendingMachine() {
        while (true) {
            try {
                ConsolePrinter.print(Message.INPUT_VENDING_MACHINE_HOLDING_MONEY.getMessage());
                VendingMachine vendingMachine = new VendingMachine(Coins.createRandomCoins(input.inputInteger()));
                ConsolePrinter.print(vendingMachine.getCoins(), Message.VENDING_MACHINE_INFORMATION);
                return vendingMachine;
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

    private int inputAmount() {
        while (true) {
            ConsolePrinter.print(Message.INPUT_AMOUNT.getMessage());
            return input.inputInteger();
        }
    }

    private void processBuyProduct(VendingMachine vendingMachine, Order order) {
        while (true) {
            ConsolePrinter.print(order.getHoldingAmount());
            order.addProduct(inputProduct());
            vendingMachine.buyProduct(order);
            if (order.getHoldingAmount() < 0) {             /** 임시 */
                break;
            }
        }
    }

    private String inputProduct() {
        while (true) {
            ConsolePrinter.print(Message.INPUT_PRODUCT_NAME.getMessage());
            return input.inputString();
        }
    }
}
