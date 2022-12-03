package vendingmachine.Domain;

import vendingmachine.Util.View;

import java.util.List;

public class Machine {

    private final View view = new View();

    private Change change;
    private List<Product> products;


    public void turnOn() {
        change = new Change(view.getInitChanges());
        products = view.getInitProducts();
    }

    public void buyProducts() {
        int money = view.getPurchaseMoney();

        while (isPurchasable(money, change)) {
            products = view.buyProduct(products);
        }

        result();
    }

    private boolean isPurchasable(int money, Change change) {
        return false;
    }

    private void result() {

    }
}
