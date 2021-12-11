package vendingmachine.controller;

import vendingmachine.model.Products;
import vendingmachine.util.ProductValidator;
import vendingmachine.util.InputValidator;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;

public class MachineController {
    private final VendingMachine vendingMachine;

    public MachineController(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void run() {
        initMachine();
        useMachine();
        endMachine();
    }

    private void initMachine() {
        insertInitialAmount();
        insertProducts();
        insertUserInsertAmount();
    }

    private void insertInitialAmount() {
        InputView.printInputInitialAmountMessage();
        vendingMachine.setInitialAmount(inputInitialAmount(InputView.getInput()));
        OutputView.printRemainingCoins(vendingMachine.getCoins());
    }

    private int inputInitialAmount(String input) {
        while (true) {
            try {
                return InputValidator.validateAmountInput(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void insertProducts() {
        InputView.printInputProductMessage();
        Products products = new Products(inputProducts(InputView.getInput()));
        vendingMachine.setProducts(products);
    }

    private List<List<String>> inputProducts(String input) {
        while (true) {
            try {
                return InputValidator.validateProductInput(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void insertUserInsertAmount() {
        InputView.printUserInsertAmountMessage();
        vendingMachine.setUserInsertAmount(userInsertAmount(InputView.getInput()));
    }

    private int userInsertAmount(String input) {
        while (true) {
            try {
                return InputValidator.validateAmountInput(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void useMachine() {
        while (shouldContinue()) {
            try {
                String product = checkProductName();
                vendingMachine.checkProductQuantity(product);
                vendingMachine.buyProduct(product);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private boolean shouldContinue() {
        return hasEnoughInsertAmount() && hasRemainingProducts();
    }

    private boolean hasEnoughInsertAmount() {
        OutputView.printRemainingInsertAmount(vendingMachine.getUserInsertAmount());
        return vendingMachine.hasEnoughAmount();
    }

    private boolean hasRemainingProducts() {
        return vendingMachine.hasAnyProduct();
    }

    private String checkProductName() {
        InputView.printProductToBuyMessage();
        String productName = InputView.getInput();
        while (true) {
            try {
                ProductValidator.validateProduct(vendingMachine, productName);
                return productName;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
                productName = InputView.getInput();
            }
        }
    }

    private void endMachine() {
        OutputView.printChanges(vendingMachine.getChanges());
    }
}
