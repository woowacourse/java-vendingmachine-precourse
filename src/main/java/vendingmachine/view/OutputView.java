package vendingmachine.view;

import vendingmachine.model.money.Money;

public class OutputView {

    public static final String INPUT_MONEY = "투입 금액 : ";

    public static void showCoins(String s) {
    }

    public static void showInputMoney(Money money) {
        System.out.println(INPUT_MONEY + money.showMoneyBill());
    }

    public static void showChange(Money money) {
        System.out.println(money.showChange());
    }
}
