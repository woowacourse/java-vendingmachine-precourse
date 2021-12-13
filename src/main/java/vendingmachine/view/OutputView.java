package vendingmachine.view;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.coin.CoinCombination;
import vendingmachine.domain.product.Products;
import vendingmachine.domain.user.UserMoney;

import java.util.Map;

public class OutputView {

    public static void printCoinCount(CoinCombination coinCombination) {
        coinCombination.print();
    }

    public static void printProducts(Products products) {
        products.print();
    }

    public static void printUserMoney(UserMoney userMoney) {
        System.out.println("투입 금액 : " + userMoney.getMoney() + "원");
    }
}