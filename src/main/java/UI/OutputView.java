package UI;

import static Constants.GuideMessages.CHANGE;
import static Constants.GuideMessages.COIN_OWNED_BY_MACHINE;
import static Constants.GuideMessages.ENTER_INPUT_PRICE;
import static Constants.GuideMessages.ENTER_PRODUCT_INFO;
import static Constants.GuideMessages.ENTER_PRODUCT_YOU_WILL_BUY;
import static Constants.GuideMessages.ENTER_VENDING_MACHINE_MONEY;

import Constants.Coin;
import java.util.Map;

public class OutputView {
    public void enterVendingMachineMoney() {
        System.out.println(ENTER_VENDING_MACHINE_MONEY);
    }

    public static void printVendingMachineCoins(Map<Coin, Integer> coinBox) {
        System.out.println(COIN_OWNED_BY_MACHINE);
        for (Map.Entry<Coin, Integer> entry : coinBox.entrySet()) {
            int amount = entry.getKey().getAmount();
            int coinSize = entry.getValue();
            System.out.printf("%d원 - %d개\n", amount, coinSize);
        }
        System.out.println();
    }

    public void enterProductInfo() {
        System.out.println(ENTER_PRODUCT_INFO);
    }

    public void enterinputMoney() {
        System.out.println(ENTER_INPUT_PRICE);
    }

    public void enterWishList() {
        //System.out.println(REMAINING_PRICE+돈+원);
        System.out.println(ENTER_PRODUCT_YOU_WILL_BUY);
    }

    public void showReturnedChanges(Map<Coin, Integer> coinBox) {
        System.out.println(CHANGE);
        for (Map.Entry<Coin, Integer> entry : coinBox.entrySet()) {
            int amount = entry.getKey().getAmount();
            int coinSize = entry.getValue();
            System.out.printf("%d원 - %d개\n", amount, coinSize);
        }
    }

}
