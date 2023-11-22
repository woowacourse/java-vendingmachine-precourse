package vendingmachine.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
            vendingMachine.addProduct(new Product(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2])));
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
    }
}
