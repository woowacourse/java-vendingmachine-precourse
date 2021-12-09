package vendingmachine.view;

import java.util.LinkedHashMap;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Price;

public class OutputView {
    public static void showUserMoney(Price userMoney) {
        System.out.println("투입 금액: " + userMoney + "원");
    }

    public static void showChange(LinkedHashMap<Coin, Integer> giveChange) {
        System.out.println("잔돈");
        giveChange.keySet()
            .stream()
            .forEach(coin -> System.out.println(coin.getAmount() + "원 - " + giveChange.get(coin) + "개"));
    }
}
