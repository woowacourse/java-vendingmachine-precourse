package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.util.VendingMachineConstant;

import java.util.Map;

public class OutputView {
    public static void printCoinCount(Coins coins) {
        System.out.println(VendingMachineConstant.RESULT_VENDING_MACHINE_COIN_MESSAGE);
        printCoins(coins.getCoins());
    }

    public static void printRemainInputMoney(int money) {
        System.out.println(VendingMachineConstant.INPUT_MONEY_PREFIX_MESSAGE + money + VendingMachineConstant.UNIT_OF_COIN);
    }

    public static void refundCoins(Coins coins) {
        System.out.println(VendingMachineConstant.REFUND_COIN_MESSAGE);
        printCoins(coins.getCoins());
    }

    private static void printCoins(Map<Coin, Integer> coins) {
        for (Coin coin : coins.keySet()) {
            System.out.println(coin.getAmount() + VendingMachineConstant.UNIT_OF_COIN + VendingMachineConstant.HYPHEN + coins.get(coin) + VendingMachineConstant.UNIT_OF_COUNT);
        }
    }
}
