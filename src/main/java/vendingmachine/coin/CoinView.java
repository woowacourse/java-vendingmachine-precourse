package vendingmachine.coin;

import camp.nextstep.edu.missionutils.Console;

public class CoinView {
    private final static String INPUT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

    public static String inputHoldingMoney() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }
}
