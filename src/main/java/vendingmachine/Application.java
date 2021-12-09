package vendingmachine;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        OutputView.printCoinsInfo(machine.getCoins());
    }
}
