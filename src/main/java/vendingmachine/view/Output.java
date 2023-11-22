package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Money;

import java.util.Map;

public class Output {

    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String COIN_FORMAT = "%d원 - %d개";
    private static final String MONEY_FORMAT = "투입 금액: %d원";

    public void showCoins(Map<Coin, Integer> coins) {
        System.out.println("\n자판기가 보유한 동전");
        coins.forEach((key, value) ->
                System.out.println(String.format(COIN_FORMAT, key.getAmount(), value))
        );
    }

    public void showMoney(Money money) {
        System.out.println();
        System.out.println(String.format(MONEY_FORMAT, money.getAmount()));
    }

    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public void showChanges(Map<Coin, Integer> changes) {
        System.out.println("잔돈");
        changes.forEach((key, value) ->
                System.out.println(String.format(COIN_FORMAT, key.getAmount(), value))
        );
    }
}
