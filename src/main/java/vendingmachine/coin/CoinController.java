package vendingmachine.coin;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.coin.Coin.*;

public class CoinController {
    private static final String COINS_AMOUNT_INIT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String COINS_COUNTS_MESSAGE = "자판기가 보유한 동전";

    private final CoinService coinService;

    public CoinController() {
        coinService = new CoinService(initCoinsAmount());
        coinService.initCoins();
    }

    public int initCoinsAmount() {
        int amount = 0;
        try {
            System.out.println(COINS_AMOUNT_INIT_MESSAGE);
            String inputAmount = Console.readLine();
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
