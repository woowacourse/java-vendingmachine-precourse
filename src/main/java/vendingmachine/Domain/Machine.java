package vendingmachine.Domain;

import vendingmachine.Util.View;

public class Machine {

    private final View view = new View();

    private final Change change;
    private Product products;


    public Machine() {
        change = view.getInitChanges();
        view.showAllCoins(change);
    }

    public void buyProducts() {
        products = view.getInitProducts();

        int money = view.getPurchaseMoney();

        while (isPurchasable(money)) {
            view.leftMoney(money);
            String productName = view.getProductNameToBuy(products);
            money -= productSold(productName);
        }

        view.leftMoney(money);
        view.showHoldingCoins(change.getChanges(money));
    }

    private boolean isPurchasable(int money) {
        return products.getCheapestPrice() < money;
    }

    private int productSold(String name) {
        products.sold(name);
        return products.getPrice(name);
    }

}
