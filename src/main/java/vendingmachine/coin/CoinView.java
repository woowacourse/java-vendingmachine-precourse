package vendingmachine.coin;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.coin.Coin.*;
import static vendingmachine.coin.Coin.COIN_10;

public class CoinView {
    private final static String INPUT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private final static String OUT_MESSAGE = "자판기가 보유한 동전";

    public static String inputHoldingMoney() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }

    public static void outputAmount() {
        System.out.println();
        System.out.println(OUT_MESSAGE);
        System.out.println(COIN_500.toString());
        System.out.println(COIN_100.toString());
        System.out.println(COIN_50.toString());
        System.out.println(COIN_10.toString());
        System.out.println();
    }
}
