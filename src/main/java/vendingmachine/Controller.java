package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static List<Coin> coins;
    private View view;
    private VendingMachine vendingMachine;

    public Controller(VendingMachine vendingMachine, View view) {
        this.view = view;
        this.vendingMachine = vendingMachine;
        this.coins = makeCoins();
    }

    public static List<Coin> makeCoins() {
        List<Coin> coins = new ArrayList<>();
        coins.add(Coin.COIN_500);
        coins.add(Coin.COIN_100);
        coins.add(Coin.COIN_50);
        coins.add(Coin.COIN_10);
        return coins;
    }

    public List<Coin> getCoins() {
        return this.coins;
    }

    public void setMoney() {
        vendingMachine.setMoney(view.setMoney());
    }

    public void printCoins() {
        System.out.println();
        view.printCoins(this.coins);
        System.out.println();
    }
}
