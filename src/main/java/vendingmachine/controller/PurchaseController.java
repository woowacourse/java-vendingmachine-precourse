package vendingmachine.controller;

import vendingmachine.domain.Coin;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachineMoney;
import vendingmachine.view.Input;

public class PurchaseController {
    private static final String BASE_INPUT_MONEY = "\n투입 금액: ";
    private static final String BASE_WON = "원";
    private static final String BASE_CHANGE = "잔돈";

    public static void purchase(VendingMachineMoney vendingMachineMoney, Product product, int inputMoney) {
        product.setMinPrice();
        product.setSumCount();

        while (checkChange(inputMoney, product.getMinPrice()) && checkCount(product.getSumCount())) {
            String productName = purchaseRepetition(vendingMachineMoney, product, inputMoney);
            inputMoney -= product.getPrice(productName);
            product.replaceProductCount(productName, product.getCount(productName) - 1);
            product.setSumCount();
        }

        printReturnChange(vendingMachineMoney, inputMoney);
    }

    public static String purchaseRepetition(VendingMachineMoney vendingMachineMoney, Product product, int inputMoney) {
        while (true) {
            String productName = Input.InputPurchase(inputMoney);
            try {
                ValidationController.purchaseValidation(product, productName);
                return productName;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printReturnChange(VendingMachineMoney vendingMachineMoney, int inputMoney) {
        System.out.println(BASE_INPUT_MONEY + inputMoney + BASE_WON);
        inputMoney = Math.min(inputMoney, vendingMachineMoney.getTotalMoney());

        int count500 = getCount500(vendingMachineMoney.getMoneyCount500(), inputMoney);
        inputMoney = inputMoney - Coin.COIN_500.getAmount() * count500;
        int count100 = getCount100(vendingMachineMoney.getMoneyCount100(), inputMoney);
        inputMoney = inputMoney - Coin.COIN_100.getAmount() * count100;
        int count50 = getCount50(vendingMachineMoney.getMoneyCount50(), inputMoney);
        inputMoney = inputMoney - Coin.COIN_50.getAmount() * count50;
        int count10 = inputMoney / Coin.COIN_10.getAmount();

        System.out.println(BASE_CHANGE);
        printWon(Coin.COIN_500.getAmount(), count500);
        printWon(Coin.COIN_100.getAmount(), count100);
        printWon(Coin.COIN_50.getAmount(), count50);
        printWon(Coin.COIN_10.getAmount(), count10);
    }

    private static void printWon(int won, int count) {
        if (count > 0) {
            System.out.println(won + BASE_WON + " - " + count + "개");
        }
    }

    private static int getCount500(int count, int inputMoney) {
        int count500 = 0;
        for (int i = 1; i <= count; i++) {
            if (inputMoney < i * Coin.COIN_500.getAmount()) {
                break;
            }
            count500 += 1;
        }
        return count500;
    }

    private static int getCount100(int count, int inputMoney) {
        int count100 = 0;
        for (int i = 1; i <= count; i++) {
            if (inputMoney < i * Coin.COIN_100.getAmount()) {
                break;
            }
            count100 += 1;
        }
        return count100;
    }

    private static int getCount50(int count, int inputMoney) {
        int count50 = 0;
        for (int i = 1; i <= count; i++) {
            if (inputMoney < i * Coin.COIN_50.getAmount()) {
                break;
            }
            count50 += 1;
        }
        return count50;
    }

    private static boolean checkChange(int remainMoney, int minPrice) {
        if (remainMoney >= minPrice) {
            return true;
        }
        return false;
    }

    private static boolean checkCount(int count) {
        if (count != 0) {
            return true;
        }
        return false;
    }
}
