package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private VendingMachine vendingMachine;

    public void run() {
        prepareChange();
    }

    private void prepareChange() {
        try {
            vendingMachine = new VendingMachine(InputView.requireChanges());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception.getMessage());
            prepareChange();
            return;
        }
        OutputView.printChangesState(vendingMachine.getChanges());
    }
}
