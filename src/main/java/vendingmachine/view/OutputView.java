package vendingmachine.view;

import vendingmachine.domain.PossessionCoins;

public class OutputView {

    public static final String POSSESSION_COINS_MESSAGE = "\n자판기가 보유한 동전";

    private OutputView() {
    }

    public static void printPossessionCoins(PossessionCoins possessionCoins) {
        System.out.println(POSSESSION_COINS_MESSAGE);
        possessionCoins.getPossessionCoins().forEach(System.out::println);
    }
}