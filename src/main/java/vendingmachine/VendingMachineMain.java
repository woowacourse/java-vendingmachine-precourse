package vendingmachine;

import inputcontroller.InputGenerator;
import models.Coin;
import models.Product;

import java.util.HashMap;

import static models.Coin.*;

public class VendingMachineMain {
    public static int totalAmount;
    public static HashMap<Coin, Integer> coin2Num;
    public static int minCost = 2000000000;

    public static HashMap<String, Product> name2Product;
    public static int userInputMoney;


    public static void makeInitialCoins() {
        totalAmount = InputGenerator.inputInitMoney();

        coin2Num = new HashMap<Coin, Integer>();
        for (Coin coin: Coin.values()) {
            coin2Num.put(coin, 0);
        }
        VendingMachineDistribution.distributeRandomly();
        VendingMachineUI.printCoins();
    }

    public static void makeInitialProducts() {
        name2Product = new HashMap<String, Product>();
        String[] inputTextParsed = InputGenerator.inputInitProducts();

        for (int i = 0; i < inputTextParsed.length; i++) {
            if (i % 5 == 1) { // 상품명
                String productName = inputTextParsed[i];
                int price = Integer.parseInt(inputTextParsed[i + 1]);
                int remains = Integer.parseInt(inputTextParsed[i + 2]);

                name2Product.put(productName, new Product(productName, price, remains));
                minCost = Math.min(minCost, price);
            }
        }
    }

    public static void giveAnOrder() {
        String productToBuy = InputGenerator.inputProductToBuy();
        if (!name2Product.containsKey(productToBuy)) {
            throw new IllegalArgumentException("[ERROR] 상품명 입력 오류");
        }

        if (soldOutCheck(productToBuy)) {
            throw new IllegalArgumentException("[ERROR] 해당 상품 재고 없음");
        }
        name2Product.get(productToBuy).provide();
    }

    public static boolean soldOutCheck(String productToBuy) {
        return name2Product.get(productToBuy).isSoldOut();
    }

    public static int[] makeChange() {  // 거스름돈 생성
        Coin[] coinList = {COIN_500, COIN_100, COIN_50, COIN_10};
        int[] numOfCoin = new int[] {0, 0, 0, 0};  // 500원개수, 100원개수, 50원개수, 10원개수

        int num;
        for (int i = 0; i < numOfCoin.length; i++) {
            num = userInputMoney / coinList[i].value();
            numOfCoin[i] = Math.min(num, coin2Num.get(coinList[i]));
            userInputMoney -= numOfCoin[i] * coinList[i].value();
        }

        return numOfCoin;
    }
}