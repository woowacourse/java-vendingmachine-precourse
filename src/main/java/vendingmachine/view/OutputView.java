package vendingmachine.view;

import vendingmachine.domain.coin.Coin;
import vendingmachine.domain.product.Products;
import vendingmachine.domain.user.UserMoney;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class OutputView {

    public static void printCoinCount(List<Integer> coinCombination) {
        AtomicInteger index = new AtomicInteger();
        Coin.stream()
                .forEach(coin -> {
                    System.out.println(coin.toString() + " - " + coinCombination.get(index.get()) + "개");
                    index.addAndGet(1);
                });
    }

    public static void printProducts(Products products) {
        products.print();
    }

    public static void printUserMoney(UserMoney userMoney) {
        System.out.println("투입 금액 : " + userMoney.getMoney() + "원");
    }
}