package vendingmachine.controller;

import vendingmachine.service.MachineService;
import vendingmachine.util.InputValidator;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class MachineController {
    private static MachineController instance;
    private static MachineService machineService;

    public static MachineController getInstance() {
        if (instance == null) {
            instance = new MachineController();
            machineService = new MachineService();
        }
        return instance;
    }

    public void initMachine() {
        requestInsertInitialAmount();
        requestInsertProduct();
        requestInsertUserAmount();
    }

    public void useMachine() {
        InputView.printProductToBuyMessage();
        while (machineService.shouldContinue()) {
            OutputView.printRemainingInsertAmount(machineService.getUserInsertAmount());
            buyProduct();
        }
    }

    public void endMachine() {
        OutputView.printChanges(machineService.getChanges());
    }

    private void requestInsertInitialAmount() {
        InputView.printInputInitialAmountMessage();
        machineService.saveAmount(inputValidAmount());
        OutputView.printRemainingCoins(machineService.getCoins());
    }

    private void requestInsertUserAmount() {
        InputView.printUserInsertAmountMessage();
        machineService.saveUserInsertAmount(inputValidAmount());
    }

    private String inputValidAmount() {
        while (true) {
            try {
                String input = InputView.getInput();
                InputValidator.validateAmountInput(input);
                return input;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
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

    private void buyProduct() {
        while (true) {
            try {
                String productName = InputView.getInput();
                machineService.buyProduct(productName);
                break;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
