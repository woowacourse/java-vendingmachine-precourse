package vendingmachine;

import static vendingmachine.ConsolePrinter.*;

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
                print(Message.INPUT_VENDING_MACHINE_HOLDING_MONEY.getMessage());
                VendingMachine vendingMachine = new VendingMachine(Coins.createRandomCoins(input.inputInteger()));
                printCoins(vendingMachine.getCoins(), Message.VENDING_MACHINE_INFORMATION);
                return vendingMachine;
            } catch (IllegalArgumentException exception) {
                print(exception.getMessage());
            }
        }
    }

    private VendingMachine addProducts(VendingMachine vendingMachine) {
        while (true) {
            try {
                print(Message.INPUT_PRODUCT.getMessage());
                vendingMachine.addAll(new ProductArgumentResolver(input.inputString()).resolve());
                return vendingMachine;
            } catch (IllegalArgumentException exception) {
                print(exception.getMessage());
            }

        }
    }

    private int inputAmount() {
        while (true) {
            try {
                print(Message.INPUT_AMOUNT.getMessage());
                return input.inputInteger();
            } catch (IllegalArgumentException exception) {
                print(exception.getMessage());
            }
        }
    }

    private void processBuyProduct(VendingMachine vendingMachine, Order order) {
        while (true) {
            useMoney(vendingMachine, order);
            if (!vendingMachine.isCheckedStockByProduct(order.getHoldingAmount())) {
                printCoins(vendingMachine.getChangeMoney(order.getHoldingAmount()), Message.CHANGE_MONTY);
                break;
            }
        }
    }

    private void useMoney(VendingMachine vendingMachine, Order order) {
        try {
            ConsolePrinter.printUserAmount(order.getHoldingAmount());
            order.addProduct(inputProduct());
            vendingMachine.buyProduct(order);
        } catch (IllegalArgumentException exception) {
            print(exception.getMessage());
        }
    }

    private String inputProduct() {
        while (true) {
            print(Message.INPUT_PRODUCT_NAME.getMessage());
            return input.inputString();
        }
    }
}
