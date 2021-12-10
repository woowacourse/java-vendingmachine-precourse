package vendingmachine.controller;

import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;
import vendingmachine.constant.ErrorMessage;
import vendingmachine.constant.SystemMessage;
import vendingmachine.domain.VendingMachine;

public class VendingMachineController {
    public void run() {
        VendingMachine vendingMachine = new VendingMachine();
        setMachineMoney(vendingMachine);

        makeRandomCoin(vendingMachine);
        setMerchandise(vendingMachine);

        setInputMoney(vendingMachine);
    }

    private void setMachineMoney(VendingMachine vendingMachine) {
        try {
            vendingMachine.setMachineMoney(InputView.printSetMachineMoneyMessage());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            setMachineMoney(vendingMachine);
        }
    }

    private void makeRandomCoin(VendingMachine vendingMachine) {
        vendingMachine.makeRandomAllCoin();
        OutputView.printCoinStatus(vendingMachine.getCoin());
    }

    private void setMerchandise(VendingMachine vendingMachine) {
        try {
            vendingMachine.addMerchandise(InputView.printSetMerchandiseMessage());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            setMerchandise(vendingMachine);
        }
    }

    private void setInputMoney(VendingMachine vendingMachine) {
        vendingMachine.setInputMoney(InputView.printSetInputMoneyMessage());
    }
}
