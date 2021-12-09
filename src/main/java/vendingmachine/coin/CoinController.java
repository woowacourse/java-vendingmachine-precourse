package vendingmachine.coin;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.coin.Coin.*;

public class CoinController {
    private static final String COINS_COUNTS_MESSAGE = "자판기가 보유한 동전";

    private final CoinService coinService;

    public CoinController() {
        coinService = new CoinService(initCoinsAmount());
        coinService.initCoins();
    }

    public int initCoinsAmount() {
        int amount = 0;
        try {
            String inputAmount = CoinInputView.inputAmountByClient();
            // 검증로직
            amount = Integer.parseInt(inputAmount);
        } catch (IllegalArgumentException e) {
            initCoinsAmount();
        }
        return amount;
    }

    public void initCoinsPrint(){
        System.out.println();
        System.out.println(COINS_COUNTS_MESSAGE);
        System.out.println(COIN_500.toString());
        System.out.println(COIN_100.toString());
        System.out.println(COIN_50.toString());
        System.out.println(COIN_10.toString());
        System.out.println();
    }
}
