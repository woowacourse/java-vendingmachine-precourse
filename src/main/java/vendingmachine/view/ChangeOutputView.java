package vendingmachine.view;

import vendingmachine.domain.Coin;

import java.util.HashMap;

public class ChangeOutputView {

    public void printCoinList(HashMap<Coin, Integer> coinStorage) {
        System.out.println();
        for (Coin coin : Coin.values()) {
            System.out.println(coin.getAmount() + "원 - " + coinStorage.get(coin) + "개");
        }
    }
}
