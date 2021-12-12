package vendingmachine.service;

import vendingmachine.domain.Money;

import static vendingmachine.utils.VerificationUtil.validateHoldingAmount;
import static vendingmachine.view.OutputView.printInputInsertAmount;
import static vendingmachine.view.OutputView.printInputVendingMachineMoney;

public class MoneyService {

    public Money createHoldingMoney() {
        int moneyPrice = createMoneyByInput();

        Money money = new Money(moneyPrice);

        return money;
    }

    public Money createInputMoney() {
        int moneyPrice = createInputMoneyByInput();

        Money money = new Money(moneyPrice);

        return money;
    }

    private int createMoneyByInput() {
        while (true) {
            try {
                String input = printInputVendingMachineMoney();

                validateHoldingAmount(input);

                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int createInputMoneyByInput() {
        while (true) {
            try {
                String input = printInputInsertAmount();

                validateHoldingAmount(input);

                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
