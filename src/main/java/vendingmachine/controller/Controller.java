package vendingmachine.controller;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import vendingmachine.domain.Coin;
import vendingmachine.domain.InputAmount;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.VendingMachineAmount;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Controller {

    public void run() {
        VendingMachine vendingMachine = new VendingMachine();
        VendingMachineAmount vendingMachineAmount = repeatReadForInvalid(this::createVendingMachineAmount);
        addCoinsToVendingMachine(vendingMachineAmount, vendingMachine);
        addProductsToVendingMachine(vendingMachine);

        InputAmount inputAmount = repeatReadForInvalid(this::createInputAmount);
        repeatPurchaseProduct(vendingMachine, inputAmount);

        Map<Coin, Integer> changes = vendingMachine.changes(inputAmount);
        OutputView.printChanges(changes);
    }

    private void addCoinsToVendingMachine(VendingMachineAmount vendingMachineAmount, VendingMachine vendingMachine) {
        vendingMachine.addCoins(vendingMachineAmount.getVendingMachineAmount());
        OutputView.printCoinsOfVendingMachine(vendingMachine.getCoins());
    }

    private void addProductsToVendingMachine(VendingMachine vendingMachine) {
        List<String> inputProducts = InputView.readProducts();
        for (String inputProduct : inputProducts) {
            String[] split = inputProduct.split(",");
            vendingMachine.addProduct(repeatReadForInvalid(() -> this.createProduct(split)));
        }
    }

    private InputAmount createInputAmount() {
        return new InputAmount(InputView.readInputAmount());
    }

    private void repeatPurchaseProduct(VendingMachine vendingMachine, InputAmount inputAmount) {
        while (true) {
            OutputView.printRemainingInputAmount(inputAmount.getAmount());
            if (vendingMachine.isAllPriceGreaterThan(inputAmount.getAmount()) || vendingMachine.isAllProductSoldOut()) {
                break;
            }
            String productNameToPurchase = InputView.readProductNameToPurchase();
            vendingMachine.purchase(productNameToPurchase, inputAmount);
        }
    }

    private Product createProduct(String[] split) {
        return new Product(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }

    private VendingMachineAmount createVendingMachineAmount() {
        return new VendingMachineAmount(InputView.readVendingMachineAmount());
    }

    private <T> T repeatReadForInvalid(Supplier<T> reader) {
        try {
            return reader.get();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return repeatReadForInvalid(reader);
        }
    }
}
