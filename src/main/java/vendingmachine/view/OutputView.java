package vendingmachine.view;

import vendingmachine.MessageConstant;
import vendingmachine.domain.Coin;

import java.util.HashMap;
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
        for (Coin coin : coins.keySet()) {
            System.out.println(coin.toString() + " - " );
        }
    }
}
