package vendingmachine.view;

import vendingmachine.MessageConstant;
import vendingmachine.domain.Coin;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OutputView {

    private OutputView() {

    }
    public static void printMachineInputMoneyMsg() {
        System.out.println(MessageConstant.INPUT_VENDING_MACHINE_HAS_MONEY_MSG);
    }
    public static void printMachineHasCoinMsg() {
        System.out.println(MessageConstant.MACHINE_HAS_COIN_MSG);
    }

    public static void printMachineHasCoins(HashMap<Coin, Integer> coins) {
        printMachineHasCoinMsg();
        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + "개");
        }
    }

    public static void printCurrentInputMoney(int money) {
        System.out.println("투입 금액 : " + money + "원");
    }

    public static void printChange(LinkedHashMap<Coin, Integer> coins) {
        System.out.println("잔돈");
        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(entry.toString() +"-" + entry.getValue() + "개");
            }
        }
    }
}
