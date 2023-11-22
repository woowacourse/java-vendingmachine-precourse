package vendingmachine.controller;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import vendingmachine.domain.Coin;
import vendingmachine.domain.InputAmount;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Controller {

    public void run() {
        int vendingMachineAmount = InputView.readVendingMachineAmount();
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addCoins(vendingMachineAmount);
        OutputView.printCoinsOfVendingMachine(vendingMachine.getCoins());

        List<String> inputProducts = InputView.readProducts();
        for (String inputProduct : inputProducts) {
            String[] split = inputProduct.split(",");
            vendingMachine.addProduct(repeatReadForInvalid(() -> this.createProduct(split)));
        }

        InputAmount inputAmount = new InputAmount(InputView.readInputAmount());
        while (true) {
            OutputView.printRemainingInputAmount(inputAmount.getAmount());
            if (vendingMachine.isAllPriceGreaterThan(inputAmount.getAmount()) || vendingMachine.isAllProductSoldOut()) {
                break;
            }
            String productNameToPurchase = InputView.readProductNameToPurchase();
            vendingMachine.purchase(productNameToPurchase, inputAmount);
        }

        Map<Coin, Integer> changes = vendingMachine.changes(inputAmount);
        OutputView.printChanges(changes);
    }

    private Product createProduct(String[] split) {
        return new Product(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]));
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
