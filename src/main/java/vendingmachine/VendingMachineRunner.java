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
            try {
                ConsolePrinter.print(Message.INPUT_PRODUCT.getMessage());
                vendingMachine.addAll(new ProductArgumentResolver(input.inputString()).resolve());
                return vendingMachine;
            } catch (IllegalArgumentException exception) {
                ConsolePrinter.print(exception.getMessage());
            }

        }
    }

    private int inputAmount() {
        while (true) {
            try {
                ConsolePrinter.print(Message.INPUT_AMOUNT.getMessage());
                return input.inputInteger();
            } catch (IllegalArgumentException exception) {
                ConsolePrinter.print(exception.getMessage());
            }
        }
    }

    private void processBuyProduct(VendingMachine vendingMachine, Order order) {
        while (true) {
            useMoney(vendingMachine, order);
            if (!vendingMachine.isCheckedStockByProduct(order.getHoldingAmount())) {
                ConsolePrinter.print(vendingMachine.getChangeMoney(order.getHoldingAmount()), Message.CHANGE_MONTY);
                break;
            }
        }
    }

    private void useMoney(VendingMachine vendingMachine, Order order) {
        try {
            ConsolePrinter.print(order.getHoldingAmount());
            order.addProduct(inputProduct());
            vendingMachine.buyProduct(order);
        } catch (IllegalArgumentException exception) {
            ConsolePrinter.print(exception.getMessage());
        }
    }

    private String inputProduct() {
        while (true) {
            ConsolePrinter.print(Message.INPUT_PRODUCT_NAME.getMessage());
            return input.inputString();
        }
    }
}
