package UI;

import static Constants.GuideMessages.*;
import Constants.Coin;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class OutputView {
    public static void enterVendingMachineMoney() {
        System.out.println(ENTER_VENDING_MACHINE_MONEY);
    }

    public static void printVendingMachineCoins(Map<Coin, Integer> coinBox) {
        System.out.println(COIN_OWNED_BY_MACHINE);
        Map<Coin, Integer> sortedCoinBox = sortCoinBox(coinBox);
        for (Map.Entry<Coin, Integer> entry : coinBox.entrySet()) {
            int amount = entry.getKey().getAmount();
            int coinSize = entry.getValue();
            System.out.printf("%d원 - %d개\n", amount, coinSize);
        }
        System.out.println();
    }

    private static Map<Coin, Integer> sortCoinBox(Map<Coin, Integer> coinBox) {
        Map<Coin, Integer> sortedMap = new TreeMap<>(new Comparator<Coin>() {
            @Override
            public int compare(Coin o1, Coin o2) {
                int amountDifference = o2.getAmount() - o1.getAmount();
                return amountDifference;
            }
        });
        return sortedMap;
    }

    public static void enterProductInfo() {
        System.out.println(ENTER_PRODUCT_INFO);
    }

    public static void enterInputMoney() {
        System.out.println(ENTER_INPUT_PRICE);
    }

    public static void enterWishList(int inputMoney) {
        System.out.println(String.format(REMAINING_PRICE,inputMoney));
        System.out.println(ENTER_PRODUCT_YOU_WILL_BUY);
    }

    public static void showReturningChanges(Map<Coin, Integer> coinBox) {
        System.out.println(CHANGE);
        for (Map.Entry<Coin, Integer> entry : coinBox.entrySet()) {
            int amount = entry.getKey().getAmount();
            int coinSize = entry.getValue();
            if (coinSize == 0) {
                continue;
            }
            System.out.println(String.format(CHANGE_RESULT, amount, coinSize));
        }
    }

}
