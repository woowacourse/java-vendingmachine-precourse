package vendingmachine.view;

import vendingmachine.model.money.Money;
import vendingmachine.model.money.MoneyCoins;

public class OutputView {

    public static final String INPUT_MONEY = "투입 금액 : ";
    public static final String CHANGE = "잔돈";

    public static void showCoins(String coins) {
        System.out.println(coins);
    }

    public static void showInputMoney(Money money) {
        System.out.println(INPUT_MONEY + money.showMoneyBill());
    }

    public static void showChange(MoneyCoins changeResult) {
        System.out.println(CHANGE);
        System.out.println(changeResult.showChange());
    }
}
