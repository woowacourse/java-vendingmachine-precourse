package vendingmachine.controller;

import vendingmachine.service.MachineService;
import vendingmachine.util.InputValidator;
import vendingmachine.model.VendingMachine;
import vendingmachine.util.ProductValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
    private final VendingMachine vendingMachine;
    private final MachineService machineService;

    public MachineController(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        this.machineService = new MachineService(vendingMachine);
    }

    public void run() {
        initMachine();
        useMachine();
        endMachine();
    }

    private void initMachine() {
        requestInsertInitialAmount();
        requestInsertProduct();
        requestInsertUserAmount();
    }

    private void useMachine() {
        InputView.printProductToBuyMessage();
        while (shouldContinue()) {
            buyProduct();
        }
    }

    private void endMachine() {
        OutputView.printChanges(vendingMachine.getChanges());
    }

    private void requestInsertInitialAmount() {
        InputView.printInputInitialAmountMessage();
        machineService.saveAmount(inputValidAmount());
        OutputView.printRemainingCoins(vendingMachine.getCoins());
    }

    private void requestInsertProduct() {
        InputView.printInputProductMessage();
        String inputProducts;
        while (true) {
            try {
                inputProducts = InputView.getInput();
                InputValidator.validateProductInput(inputProducts);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
        machineService.saveProducts(inputProducts);
    }

    private void requestInsertUserAmount() {
        InputView.printUserInsertAmountMessage();
        machineService.saveUserInsertAmount(inputValidAmount());
    }

    private int inputValidAmount() {
        while (true) {
            try {
                String input = InputView.getInput();
                InputValidator.validateAmountInput(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private boolean shouldContinue() {
        return hasEnoughInsertAmount() && hasRemainingProducts() && canBuySomething();
    }

    private boolean hasEnoughInsertAmount() {
        OutputView.printRemainingInsertAmount(vendingMachine.getUserInsertAmount());
        return vendingMachine.hasEnoughAmount();
    }

    private boolean hasRemainingProducts() {
        return vendingMachine.hasAnyProduct();
    }

    private boolean canBuySomething() {
        return vendingMachine.existProductToBuy();
    }

    private void buyProduct() {
        while (true) {
            try {
                String productName = InputView.getInput();
                checkProductName(productName);
                machineService.buyProduct(productName);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void checkProductName(String productName) {
        ProductValidator.isProductInVendingMachine(vendingMachine, productName);
    }
}
