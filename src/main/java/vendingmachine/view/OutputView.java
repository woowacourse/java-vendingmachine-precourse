package vendingmachine.view;

import vendingmachine.domain.Coin;
import vendingmachine.util.VendingMachineConstant;

import java.util.Map;

public class OutputView {
    public static void printCoinCount(Map<Coin, Integer> coins) {
        System.out.println(VendingMachineConstant.RESULT_VENDING_MACHINE_COIN_MESSAGE);
        for (Coin coin : coins.keySet()) {
            System.out.println(coin.getAmount() + VendingMachineConstant.UNIT_OF_COIN + VendingMachineConstant.HYPHEN + coins.get(coin) + VendingMachineConstant.UNIT_OF_COUNT);
        }
    }
}
