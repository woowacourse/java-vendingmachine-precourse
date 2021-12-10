package vendingmachine.controller;

import vendingmachine.View.InputView;
import vendingmachine.View.OutputView;
import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;

public class VendingMachineController {
    public void run() {
        VendingMachine vendingMachine = new VendingMachine();
        getMachineMoney(vendingMachine);

        makeRandomCoin(vendingMachine);
        getMerchandiseInfo(vendingMachine);

        getInputMoney(vendingMachine);

        do {
            purchase(vendingMachine);
        } while (!vendingMachine.canPurchase());

        printChange(vendingMachine);
    }

    private void getMachineMoney(VendingMachine vendingMachine) {
        try {
            vendingMachine.setMachineMoney(InputView.printGetMachineMoneyMessage());
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
            vendingMachine.addMerchandise(InputView.printGetMerchandiseMessage());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            getMerchandiseInfo(vendingMachine);
        }
    }

    private void getInputMoney(VendingMachine vendingMachine) {
        vendingMachine.setInputMoney(InputView.printGetInputMoneyMessage());
    }

    private void purchase(VendingMachine vendingMachine) {
        try {
            OutputView.printMoneyStatus(vendingMachine);
            vendingMachine.purchase(InputView.printPurchaseMessage());
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMessage(exception);
            purchase(vendingMachine);
        }
    }

    private void printChange(VendingMachine vendingMachine) {
        OutputView.printMoneyStatus(vendingMachine);
        vendingMachine.getChange();
    }
}
