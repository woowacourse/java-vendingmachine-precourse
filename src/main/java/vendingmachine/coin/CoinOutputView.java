package vendingmachine.coin;

import java.util.List;

import static vendingmachine.coin.Coin.*;

public class CoinOutputView {
    private static final String COINS_COUNTS_MESSAGE = "자판기가 보유한 동전";
    private static final String REPAY_COINS_MESSAGE = "잔돈";
    private static final String REPAY_NO_COIN = "잔돈이 없습니다. 안녕히 가세요.";
    private static final String[] COIN_MESSAGE = {"500원 - ", "100원 - ", "50원 - ", "10원 - "};
    private static final String COIN_COUNTS_UNIT = "개";
    private static final int NO_COIN = 0;

    public static void initCoinsPrintInfo() {
        System.out.println();
        System.out.println(COINS_COUNTS_MESSAGE);
        System.out.println(COIN_500.toString());
        System.out.println(COIN_100.toString());
        System.out.println(COIN_50.toString());
        System.out.println(COIN_10.toString());
        System.out.println();
    }

    public static void repayCoinsPrintInfo(List<Integer> repayList) {
        System.out.println(REPAY_COINS_MESSAGE);
        for (int i = 0; i < repayList.size(); i++) {
            int counts = repayList.get(i);
            if (counts == NO_COIN) {
                continue;
            }
            System.out.println(COIN_MESSAGE[i] + counts + COIN_COUNTS_UNIT);
        }
    }
}
