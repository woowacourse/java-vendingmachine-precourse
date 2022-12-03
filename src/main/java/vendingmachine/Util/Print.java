package vendingmachine.Util;

import vendingmachine.Domain.Change;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        HashMap<Integer, Integer> coinMap = change.getCoins();
        List<Integer> coinUnits = new ArrayList<>(coinMap.keySet());

        System.out.println(COUNTS_OF_CHANGES.getMessage());

        for (int unit : coinUnits) {
            int count = coinMap.get(unit);
            System.out.printf(COUNT_OF_COIN.getMessage(), unit, count);
        }
    }

    public void showHoldingCoins(Change change) {
        HashMap<Integer, Integer> coinMap = change.getCoins();
        List<Integer> coinUnits = new ArrayList<>(coinMap.keySet());
        System.out.println(RESULT.getMessage());

        for (int unit : coinUnits) {
            int count = coinMap.get(unit);
            if (count > 0) {
                System.out.printf(COUNT_OF_COIN.getMessage(), unit, count);
            }

        }
    }

    public void leftMoney(int money) {
        System.out.printf(MONEY_AMOUNT_LEFT.getMessage(), money);
    }

}
