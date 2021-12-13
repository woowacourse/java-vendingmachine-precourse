package vendingmachine;

import static vendingmachine.view.InputView.calculateProductList;
import static vendingmachine.view.InputView.inputMoney;
import static vendingmachine.view.InputView.inputPurChaseProductName;
import static vendingmachine.view.InputView.inputVendinMachineOwnMoney;
import static vendingmachine.view.OutputView.printChangeCoins;
import static vendingmachine.view.OutputView.printCurrentMoney;
import static vendingmachine.view.OutputView.printCurrentOwnCoins;
import static vendingmachine.view.OutputView.printErrorMessage;

import java.util.List;
import vendingmachine.domain.Money;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;

public class Application {

    public static void main(String[] args) {
        Money money = inputVendingMachineOwnMoney();
        VendingMachine machine = VendingMachine.createRandomVendingMachineByMoney(money);
        printCurrentOwnCoins(machine.currentRemainCoins());
        inputVendingMachineProducts(machine);

        machine.chargeMoney(inputUserMoney());
        purchaseProductAndCheckPurchasable(machine);
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

    private static List<Product> inputProducts() {
        try {
            return calculateProductList();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return inputProducts();
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

    private static void purchaseProductAndCheckPurchasable(VendingMachine machine) {
        printCurrentMoney(machine.currentMoney());
        if (!machine.isPurchasable()) {
            printChangeCoins(machine.changeCoins());
            return;
        }
        purchaseProduct(machine);
        purchaseProductAndCheckPurchasable(machine);
    }

    private static void purchaseProduct(VendingMachine machine) {
        try {
            machine.purchaseProduct(inputPurChaseProductName());
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            purchaseProduct(machine);
        }
    }
}
