package vendingmachine.controller;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.Products;
import vendingmachine.util.ProductValidator;
import vendingmachine.util.InputValidator;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;

public class MachineController {
    private VendingMachine vendingMachine;
    private Products products;

    public void run() {
        initMachine();
        useMachine();
    }

    private void initMachine() {
        createVendingMachine();
        createProducts();
        createUserInsertAmount();
    }

    private void createVendingMachine() {
        InputView.printInputInitialAmountMessage();
        vendingMachine = new VendingMachine(inputInitialAmount());
        OutputView.printRemainingCoins(vendingMachine.getCoins());
    }

    private int inputInitialAmount() {
        while (true) {
            try {
                return InputValidator.validateAmountInput(Console.readLine());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void createProducts() {
        InputView.printInputProductMessage();
        products = new Products(inputProducts());
        vendingMachine.setProducts(products);
    }

    private List<List<String>> inputProducts() {
        while (true) {
            try {
                return InputValidator.validateProductInput(Console.readLine());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void createUserInsertAmount() {
        InputView.printUserInsertAmountMessage();
        vendingMachine.setUserInsertAmount(userInsertAmount());
    }

    private int userInsertAmount() {
        while (true) {
            try {
                return InputValidator.validateAmountInput(Console.readLine());
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void useMachine() {
        while(shouldContinueBuying()) {
            buyProduct();
        }
    }

    private boolean shouldContinueBuying() {
        return checkRemainingInsertAmount() && checkRemainingQuantity();
    }

    private boolean checkRemainingInsertAmount() {
        OutputView.printRemainingInsertAmount(vendingMachine.getUserInsertAmount());
        return vendingMachine.hasEnoughAmount();
    }

    private boolean checkRemainingQuantity() {
        return true;
    }

    private void buyProduct() {
        InputView.printProductToBuyMessage();
        String productName = Console.readLine();
        while(true) {
            try {
                ProductValidator.validateProduct(vendingMachine, productName);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
                productName = Console.readLine();
            }
        }
    }
}
