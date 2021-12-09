package vendingmachine.domain;

import java.util.List;

public class VendingMachine {
    private int price;
    private List<Coin> coins;

    public VendingMachine(int price){
        this.price = price;
    }
}
