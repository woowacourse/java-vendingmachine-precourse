package vendingmachine.view;

import vendingmachine.domain.Price;

public class OutputView {
    public static void showUserMoney(Price userMoney) {
        System.out.println("투입 금액: " + userMoney + "원");
    }
}
