package vendingmachine.coin;

import static vendingmachine.coin.Coin.*;

public class CoinOutputView {
    private static final String COINS_COUNTS_MESSAGE = "자판기가 보유한 동전";

    public static void initCoinsPrintInfo() {
        System.out.println();
        System.out.println(COINS_COUNTS_MESSAGE);
        System.out.println(COIN_500.toString());
        System.out.println(COIN_100.toString());
        System.out.println(COIN_50.toString());
        System.out.println(COIN_10.toString());
        System.out.println();
    }
}
