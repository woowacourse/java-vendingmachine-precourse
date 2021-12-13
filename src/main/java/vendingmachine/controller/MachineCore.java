package vendingmachine.controller;

import vendingmachine.model.Machine;
import vendingmachine.validator.ConsoleValidator;
import vendingmachine.view.InputData;
import vendingmachine.view.MainView;

public class MachineCore {
    private final Machine machine = new Machine();
    private final MainView view = new MainView();
    private final ConsoleValidator consoleValidator = new ConsoleValidator();

    public void startMachine() {
        readMachineAssetFromUser();
    }

    private void readMachineAssetFromUser() {
        while (true) {
            try {
                String input = view.askQuestion(InputData.ASK_PRODUCTS_TO_SET);
                machine.setInitialAsset(consoleValidator.checkNumeric(input));
                break;
            } catch (IllegalArgumentException exception) {
                view.printError();
            }
        }
    }
}
