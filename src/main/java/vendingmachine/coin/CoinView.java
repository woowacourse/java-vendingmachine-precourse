package vendingmachine.coin;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static vendingmachine.coin.Coin.*;

public class CoinView {

    private final static String INPUT_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private final static String OUT_MESSAGE = "자판기가 보유한 동전";
    private final static String[] coinMessage = {"500원 - ","100원 - ","50원 - ","10원 - "};

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

    public static void outputRepay(List<Integer> listCoin) {
        System.out.println("잔돈");
        for(int i = 0; i<listCoin.size(); i++) {
            if(listCoin.get(i) != 0) {
                System.out.println(coinMessage[i]+listCoin.get(i));
            }
        }
    }
}
