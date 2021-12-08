package vendingmachine.Model;

import java.util.List;

public class VendingMachine {
    private int balance;
    private Coins coins;
    private List<Drink> drinks;

    public VendingMachine(int balance, Coins coins, List<Drink> drinks) {
        this.balance = balance;
        this.coins = coins;
        this.drinks = drinks;
    }

    public boolean isDrinkInList(String drinkName) {
        int flag = 1;
        for (Drink drink : drinks) {
            flag *= drink.isSameDrink(drinkName);
        }
        return (flag == 1);
    }

    public boolean isSoldOut() {
        int totalStock = 0;
        for (Drink drink : drinks) {
            totalStock += drink.getStock();
        }
        return (totalStock == 0);
    }

    public int getMinimumPrice() {
        int minimumPrice = Integer.MAX_VALUE;
        for (Drink drink : drinks) {
            minimumPrice = comparePrice(minimumPrice, drink);
        }
        return minimumPrice;
    }

    public int comparePrice(int currentMinimum, Drink drink) {
        if (drink.getPrice() < currentMinimum && drink.getStock() > 0) {
            return drink.getPrice();
        }
        return currentMinimum;
    }
}
