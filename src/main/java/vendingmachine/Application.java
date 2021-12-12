package vendingmachine;

import static vendingmachine.view.InputView.inputVendinMachineOwnMoney;
import static vendingmachine.view.OutputView.printErrorMessage;

import vendingmachine.domain.Money;

public class Application {

    public static void main(String[] args) {
        Money money = inputVendingMachineOwnMoney();
    }

    private static Money inputVendingMachineOwnMoney() {
        try {
            return Money.valueOf(inputVendinMachineOwnMoney());
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return inputVendingMachineOwnMoney();
        }
    }
}
