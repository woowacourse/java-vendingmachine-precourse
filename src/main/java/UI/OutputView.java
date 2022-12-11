package UI;

import static Constants.GuideMessages.*;

import Constants.Coin;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void enterVendingMachineMoney() {
        System.out.println(ENTER_VENDING_MACHINE_MONEY);
    }

    public static void printVendingMachineCoins(Map<Coin, Integer> coinBox) {
        System.out.println(COIN_OWNED_BY_MACHINE);
        List<Coin> sortedCoins = sortCoinsByTheirAmount(coinBox);
        printSortedCoins(coinBox, sortedCoins);
        System.out.println();
    }

    private static List<Coin> sortCoinsByTheirAmount(Map<Coin, Integer> coinBox) {
        List<Coin> coinAmounts = new ArrayList<>(coinBox.keySet());
        Comparator<Coin> comp = (c1, c2) -> Integer.compare(c2.getAmount(), c1.getAmount());
        coinAmounts.sort(comp);
        return coinAmounts;
    }

    private static void printSortedCoins(Map<Coin, Integer> coinBox, List<Coin> sortedCoins) {
        sortedCoins.forEach(coin -> {
            System.out.println(
                    String.format(COIN_MAP, coin.getAmount(), coinBox.get(coin)));
        });
    }


    public static void enterProductInfo() {
        System.out.println(ENTER_PRODUCT_INFO);
    }

    public static void enterInputMoney() {
        System.out.println(ENTER_INPUT_PRICE);
    }

    public static void enterWishList(int inputMoney) {
        System.out.println(String.format(REMAINING_PRICE, inputMoney));
        System.out.println(ENTER_PRODUCT_YOU_WILL_BUY);
    }

    public static void showReturningChanges(Map<Coin, Integer> coinBox, int inputMoney) {
        System.out.print(String.format(REMAINING_PRICE, inputMoney));
        System.out.println(CHANGE);
        List<Coin> sortedChanges = sortCoinsByTheirAmount(coinBox);
        printSortedChanges(coinBox, sortedChanges);
    }

    private static void printSortedChanges(Map<Coin, Integer> coinBox, List<Coin> sortedChanges) {
        sortedChanges.stream()
                .filter(coin -> coinBox.get(coin) != 0)
                .forEach(coin -> {
                            System.out.println(
                                    String.format(COIN_MAP, coin.getAmount(), coinBox.get(coin)));
                        }
                );
    }

}
