package vendingmachine.coin;

import camp.nextstep.edu.missionutils.Console;

public class CoinInputView {
    private static final String COINS_AMOUNT_INIT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

    public static String inputAmountByClient(){
        System.out.println(COINS_AMOUNT_INIT_MESSAGE);
        return Console.readLine();
    }
}
