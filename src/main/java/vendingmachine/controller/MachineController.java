package vendingmachine.controller;

import vendingmachine.service.MachineService;
import vendingmachine.util.InputValidator;
import vendingmachine.model.VendingMachine;
import vendingmachine.util.ProductValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

import java.util.List;

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
        List<List<String>> productList;
        while (true) {
            try {
                productList = InputValidator.validateProductInput(InputView.getInput());
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
        machineService.saveProducts(productList);
    }

    private void requestInsertUserAmount() {
        InputView.printUserInsertAmountMessage();
        machineService.saveUserInsertAmount(inputValidAmount());
    }

    private int inputValidAmount() {
        while (true) {
            try {
                return InputValidator.validateAmountInput(InputView.getInput());
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
