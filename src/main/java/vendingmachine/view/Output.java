package vendingmachine.view;

import vendingmachine.domain.Coin;

import java.util.Map;

public class Output {

    private static final String COIN_FORMAT = "%d원 - %d개";

    public void showCoins(Map<Coin, Integer> coins) {
        System.out.println("\n자판기가 보유한 동전");
        coins.forEach((key, value) ->
                System.out.println(String.format(COIN_FORMAT, key.getAmount(), value))
        );
    }
}
