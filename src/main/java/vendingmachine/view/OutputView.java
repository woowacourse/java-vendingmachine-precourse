package vendingmachine.view;

import java.util.LinkedHashMap;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Price;
import vendingmachine.repository.CoinRepository;

public class OutputView {
    public static void showUserMoney(Price userMoney) {
        System.out.println("\n투입 금액: " + userMoney + "원");
    }

    public static void showChange(LinkedHashMap<Coin, Integer> giveChange) {
        System.out.println("잔돈");
        giveChange.keySet()
            .stream()
            .forEach(coin -> System.out.println(coin.getAmount() + "원 - " + giveChange.get(coin) + "개"));
    }

    public static void showAllCoinsMachineHave(CoinRepository coinRepository) {
        System.out.println("\n자판기가 보유한 동전");
        System.out.println(coinRepository);
    }
}
