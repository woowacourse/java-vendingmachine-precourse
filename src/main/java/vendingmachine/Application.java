package vendingmachine;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        OutputView.printCoinsInfo(machine.getCoins());

        machine.setMerchandiseInfo(InputView.getMerchandiseInput());
        machine.setMoneyLeft(InputView.getCustomerMoneyInput());

        while (true) {
            OutputView.printMoneyLeft(machine.getMoneyLeft());
            if (!machine.canBuyMore()) break;
            machine.sellMerchandise();
        }
    }
}
