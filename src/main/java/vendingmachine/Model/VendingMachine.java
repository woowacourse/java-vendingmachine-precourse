package vendingmachine.Model;

import java.util.List;

public class VendingMachine {
    private static int balance;
    private static Coins coins;
    private static List<Drink> drinks;

    public VendingMachine(int balance, Coins coins){
        this.balance=balance;
        this.coins=coins;
    }

}
