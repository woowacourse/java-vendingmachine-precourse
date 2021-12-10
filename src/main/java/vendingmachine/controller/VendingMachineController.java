package vendingmachine.controller;

import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;
import vendingmachine.domain.VendingMachine;

public class VendingMachineController {
    public void run() {
        VendingMachine vendingMachine = new VendingMachine();
        getMachineMoney(vendingMachine);

        makeRandomCoin(vendingMachine);
        getMerchandiseInfo(vendingMachine);

        getInputMoney(vendingMachine);
    }

    private void getMachineMoney(VendingMachine vendingMachine) {
        try {
            vendingMachine.setMachineMoney(InputView.printSetMachineMoneyMessage());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            getMachineMoney(vendingMachine);
        }
    }

    private void makeRandomCoin(VendingMachine vendingMachine) {
        vendingMachine.makeRandomAllCoin();
        OutputView.printCoinStatus(vendingMachine.getCoin());
    }

    private void getMerchandiseInfo(VendingMachine vendingMachine) {
        try {
            vendingMachine.addMerchandise(InputView.printSetMerchandiseMessage());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            getMerchandiseInfo(vendingMachine);
        }
    }

    private void getInputMoney(VendingMachine vendingMachine) {
        vendingMachine.setInputMoney(InputView.printSetInputMoneyMessage());
    }
}
