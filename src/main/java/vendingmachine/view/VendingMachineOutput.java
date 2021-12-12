package vendingmachine.view;

import vendingmachine.domain.Coin;

import java.util.Map;

public class VendingMachineOutput {
    private static final String CONNECTION_MARK = " - ";
    private static final String COINS_INSTRUCTION = "자판기가 보유한 동전";
    private static final String INPUT_MONEY_INSTRUCTION = "투입 금액: ";
    private static final String CHANGES_INSTRUCTION = "잔돈";

    public static void printCoinsVendingMachineHas(Map<Coin, Integer> coinMap) {
        System.out.println(COINS_INSTRUCTION);
        for(Coin coin : coinMap.keySet()) {
            System.out.println(coin + CONNECTION_MARK + coinMap.get(coin));
        }
    }

    public static void printRestMoney(int restMoney) {
        System.out.println(INPUT_MONEY_INSTRUCTION + restMoney);
    }

    public static void printChange(Map<Coin, Integer> changes) {
        System.out.println(CHANGES_INSTRUCTION);
        for(Coin coin: changes.keySet()) {
            System.out.println(coin + CONNECTION_MARK + changes.get(coin));
        }

    }

}
