package vendingmachine.controller;

import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;
import vendingmachine.domain.VendingMachine;

public class VendingMachineController {
    public void run() {
        VendingMachine vendingMachine = new VendingMachine();
        setMachineMoney(vendingMachine);

        makeRandomCoin(vendingMachine);
    }

    private void setMachineMoney(VendingMachine vendingMachine) {
        try {
            vendingMachine.setMachineMoney(InputView.printSetMachineMoney());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            setMachineMoney(vendingMachine);
        }
    }

    private void makeRandomCoin(VendingMachine vendingMachine) {
        vendingMachine.makeRandomCoin();
        OutputView.printCoinStatus(vendingMachine.getCoinCount());
    }
}
