package vendingmachine;

import static vendingmachine.view.InputView.inputMoney;
import static vendingmachine.view.InputView.inputProducts;
import static vendingmachine.view.InputView.inputVendinMachineOwnMoney;
import static vendingmachine.view.OutputView.printCurrentOwnCoins;
import static vendingmachine.view.OutputView.printErrorMessage;

import vendingmachine.domain.Money;
import vendingmachine.domain.VendingMachine;

public class Application {

    public static void main(String[] args) {
        Money money = inputVendingMachineOwnMoney();
        VendingMachine machine = VendingMachine.createRandomVendingMachineByMoney(money);
        printCurrentOwnCoins(machine.currentRemainCoins());
        inputVendingMachineProducts(machine);

        machine.chargeMoney(inputUserMoney());
    }

    private static Money inputVendingMachineOwnMoney() {
        try {
            return Money.valueOf(inputVendinMachineOwnMoney());
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return inputVendingMachineOwnMoney();
        }
    }

    private static void inputVendingMachineProducts(VendingMachine machine) {
        try {
            machine.putProducts(inputProducts());
        } catch (Exception e) {
            printErrorMessage(e);
            inputVendingMachineProducts(machine);
        }
    }

    private static Money inputUserMoney() {
        try {
            return Money.valueOf(inputMoney());
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return inputUserMoney();
        }
    }
}
