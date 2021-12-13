package vendingmachine.controller;

import vendingmachine.model.Machine;
import vendingmachine.model.ProductTable;
import vendingmachine.validator.ConsoleValidator;
import vendingmachine.validator.ProductValidator;
import vendingmachine.view.InputData;
import vendingmachine.view.MainView;

public class MachineCore {
    private final Machine machine = new Machine();
    private final MainView view = new MainView();
    private final ConsoleValidator consoleValidator = new ConsoleValidator();
    private final ProductValidator productValidator = new ProductValidator();

    public void startMachine() {
        readMachineAssetFromUser();
        readProductTableFromUser();
    }

    private void readMachineAssetFromUser() {
        while (true) {
            try {
                String input = view.askQuestion(InputData.ASK_BUDGET);
                machine.setInitialAsset(consoleValidator.checkNumeric(input));
                break;
            } catch (IllegalArgumentException exception) {
                view.printError();
            }
        }
    }

    private void readProductTableFromUser() {
        while (true) {
            try {
                String input = view.askQuestion(InputData.ASK_PRODUCT_TO_BUY);
                ProductTable productTable = splitProductInfo(input);
                machine.setProductTable(productTable);
                break;
            } catch (IllegalArgumentException exception) {
                view.printError();
            }
        }
    }

    private ProductTable splitProductInfo(String userInput) {
        return productValidator.checkStringOfProductTable(userInput);
    }
}
