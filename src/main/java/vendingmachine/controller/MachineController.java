package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.Products;
import vendingmachine.util.Validator;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;

public class MachineController {
    private VendingMachine vendingMachine;
    private Products products;

    public void run() {
        initMachine();
    }

    private void initMachine() {
        createVendingMachine();
        createProducts();
        userInsertAmount();
    }

    private void createVendingMachine() {
        vendingMachine = new VendingMachine(inputInitialAmount());
        OutputView.printRemainingCoins(vendingMachine.getCoins());
    }

    private int inputInitialAmount() {
        InputView.printInputInitialAmountMessage();

        while (true) {
            try {
                return Validator.validateAmountInput(Console.readLine());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void createProducts() {
        products = new Products(inputProducts());
        vendingMachine.setProducts(products);
    }

    private List<List<String>> inputProducts() {
        InputView.printInputProductMessage();

        while (true) {
            try {
                return Validator.validateProductInput(Console.readLine());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void userInsertAmount() {
        InputView.printUserInputAmountMessage();


    }
}
