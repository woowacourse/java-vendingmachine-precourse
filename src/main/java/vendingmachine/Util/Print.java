package vendingmachine.Util;

import vendingmachine.Constant.Coin;
import vendingmachine.Domain.Change;

import java.util.HashMap;

import static vendingmachine.Constant.Message.*;

public class Print {

    public void inputChanges() {
        System.out.println(INITIALIZE_CHANGES.getMessage());
    }

    public void inputProductInfo() {
        System.out.println(INITIALIZE_PRODUCTS.getMessage());
    }

    public void inputPurchaseMoney() {
        System.out.println(PURCHASE_MONEY.getMessage());
    }

    public void inputProductToBuy() {
        System.out.println(PURCHASE_PRODUCT.getMessage());
    }

    public void showAllCoins(Change change) {
        System.out.println(COUNTS_OF_CHANGES.getMessage());

        HashMap<Coin, Integer> coinMap = change.getCoins();

        for (Coin unit : coinMap.keySet()) {
            int count = coinMap.get(unit);

            System.out.printf(COUNT_OF_COIN.getMessage(), unit.getAmount(), count);
        }
    }

    public void showHoldingCoins(HashMap<Coin, Integer> changes) {
        System.out.println(RESULT.getMessage());

        for (Coin unit : changes.keySet()) {
            int count = changes.get(unit);

            if (count > 0) System.out.printf(COUNT_OF_COIN.getMessage(), unit.getAmount(), count);
        }
    }

    public void leftMoney(int money) {
        System.out.printf(MONEY_AMOUNT_LEFT.getMessage(), money);
    }

}
