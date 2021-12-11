package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private VendingMachine vendingMachine;

    public void run() {
        prepareChange();
        prepareMerchandise();
        preparePurchaseAmount();
        buyMerchandise();
        OutputView.returnChanges(vendingMachine.calculateChangeToCustomer());
    }

    private void preparePurchaseAmount() {
        vendingMachine.putMoney(InputView.requireMoney());
    }

    private void prepareMerchandise() {
        try {
            vendingMachine.setMerchandise(InputView.requireVendingMachineMerchandiseInfo());
        } catch (Exception exception) {
            OutputView.printErrorMessage(exception.getMessage());
            prepareMerchandise();
            return;
        }
    }

    private void prepareChange() {
        try {
            vendingMachine = new VendingMachine(InputView.requireChanges());
        } catch (Exception exception) {
            System.out.println("[ERROR]");
//            OutputView.printErrzorMessage(exception.getMessage());
            prepareChange();
            return;
        }
        OutputView.printChangesState(vendingMachine.getChanges());
    }

    private void buyMerchandise() {
        while (vendingMachine.canBuySomething() && !vendingMachine.soldOut()) {
            OutputView.printExistMoney(vendingMachine.money());
            buyTargetMerchandise();
        }
        OutputView.printExistMoney(vendingMachine.money());
    }

    private void buyTargetMerchandise() {
        try {
            vendingMachine.buyMerchandise(InputView.requireMerchandise());
        } catch (Exception exception) {
            OutputView.printErrorMessage(exception.getMessage());
            buyTargetMerchandise();
            return;
        }
    }
}
