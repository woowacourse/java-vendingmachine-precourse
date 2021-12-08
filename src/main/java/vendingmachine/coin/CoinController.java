package vendingmachine.coin;

import camp.nextstep.edu.missionutils.Console;

public class CoinController {
    private static final String COINS_AMOUNT_INIT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

    public void initCoinsAmount() {
        int amount = 0;
        try {
            System.out.println(COINS_AMOUNT_INIT_MESSAGE);
            String inputAmount = Console.readLine();
            // 검증로직
            amount = Integer.parseInt(inputAmount);
        } catch (IllegalArgumentException e) {
            initCoinsAmount();
        }
    }
}
