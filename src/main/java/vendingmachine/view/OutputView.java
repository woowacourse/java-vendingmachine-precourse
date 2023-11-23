package vendingmachine.view;

import static vendingmachine.view.constants.MachineMessage.COIN_FORMAT;
import static vendingmachine.view.constants.MachineMessage.MACHINE_CHANGE;
import static vendingmachine.view.constants.MachineMessage.USER_AMOUNT;

import java.util.Map;
import vendingmachine.Coin;

public class OutputView {
    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printCoins(Map<Coin, Integer> coins) {
        System.out.println(MACHINE_CHANGE.getMessage());
        for (Coin coin : Coin.values()) {
            int coinCount = coins.getOrDefault(coin, 0);
            if (coinCount == 0) {
                continue;
            }
            System.out.println(String.format(COIN_FORMAT.getMessage(), coin.getAmount(), coinCount));
        }
    }

    public void printUserAmount(int userAmount){
        System.out.println(String.format(USER_AMOUNT.getMessage(), userAmount));
    }
}
