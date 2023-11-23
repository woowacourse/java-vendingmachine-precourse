package vendingmachine.view;

import static vendingmachine.view.constants.MachineMessage.CHANGE;
import static vendingmachine.view.constants.MachineMessage.COIN_FORMAT;
import static vendingmachine.view.constants.MachineMessage.MACHINE_CHANGE;
import static vendingmachine.view.constants.MachineMessage.NEWLINE;
import static vendingmachine.view.constants.MachineMessage.USER_AMOUNT;

import java.util.Map;
import java.util.Map.Entry;
import vendingmachine.Coin;
import vendingmachine.domain.Machine;

public class OutputView {
    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printCoins(Map<Coin, Integer> coins) {
        System.out.println(MACHINE_CHANGE.getMessage());
        for (Coin coin : Coin.values()) {
            int coinCount = coins.getOrDefault(coin, 0);
            System.out.println(String.format(COIN_FORMAT.getMessage(), coin.getAmount(), coinCount));
        }
        NEWLINE.getMessage();
    }

    public void printUserAmount(int userAmount){
        System.out.println(String.format(USER_AMOUNT.getMessage(), userAmount));
    }

    public void printChange(Map<Coin,Integer> changes){
        System.out.println(CHANGE.getMessage());
        for (Entry<Coin, Integer> change : changes.entrySet()) {
            System.out.println(String.format(COIN_FORMAT.getMessage(), change.getKey().getAmount(), change.getValue()));
        }
    }
}
