package vendingmachine.view;

import java.util.HashMap;

import vendingmachine.domain.Coin;
import vendingmachine.domain.CoinCase;
import vendingmachine.domain.VendingMachine;

public class SystemMessageOutputView {

    private static final String HOLDING_COIN_INFO_MESSAGE = "자판기가 보유한 동전";
    private static final String NUMBER_UNIT = "개";

    public static void printHoldingCoins(final HashMap<Coin, Integer> holdingCoins) {
        System.out.println(HOLDING_COIN_INFO_MESSAGE);
        for (Coin coin : Coin.getCoinListDecreasingOrder()) {
            System.out.print(coin.toString());
            System.out.print(holdingCoins.get(coin));
            System.out.println(NUMBER_UNIT);
        }
    }
}
