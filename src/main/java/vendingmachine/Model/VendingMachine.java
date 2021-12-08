package vendingmachine.Model;

import java.util.List;

public class VendingMachine {
    private int balance;
    private Coins coins;
    private List<Drink> drinks;

    public VendingMachine(int balance, Coins coins, List<Drink> drinks){
        this.balance=balance;
        this.coins=coins;
        this.drinks=drinks;
    }
}
