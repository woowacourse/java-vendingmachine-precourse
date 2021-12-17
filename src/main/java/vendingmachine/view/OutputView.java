package vendingmachine.view;

import java.util.Map;

import static vendingmachine.util.Constants.*;

import vendingmachine.model.Coin;

public class OutputView {

    public static void printMachineCoins(Map<Integer, Integer> coins) {
        System.out.println(TAKEN_MACHINE_COINS_MSG);
        for (int coinValue : Coin.getAmountsList()) {
            System.out.println(
                coinValue + KRW + COINS_MSG_DELIMETER + coins.get(coinValue) + EA
            );
        }
        System.out.println();
    }

    public static void printCurrUserMoney(Integer currUserMoney) {
        System.out.println(USER_MONEY + currUserMoney + KRW);
        System.out.println();
    }

    public static void printChangeCoins(Map<Integer, Integer> changeCoins){
        System.out.println(CHANGES_MSG);
        for (int coinValue : changeCoins.keySet()) {
            System.out.println(
                coinValue + KRW + COINS_MSG_DELIMETER + changeCoins.get(coinValue) + EA
            );
        }
        System.out.println();
    }

    public static void printErrorMsg(Exception e) {
        System.out.println(ERROR_MSG + e.getMessage());
        System.out.println();
    }
}
