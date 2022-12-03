package vendingmachine.Domain;

import vendingmachine.Util.View;

import java.util.List;

public class Machine {

    private final View view = new View();

    private Change change;
    private List<Product> products;


    public Machine() {
        change = new Change(view.getInitChanges());
        products = view.getInitProducts();
    }

    public void buyProducts() {
        int money = view.getPurchaseMoney();

        while (isPurchasable(money)) {
            view.leftMoney(money);

            String productName = view.getProductNameToBuy(products);
            products = view.buyProduct(products);

            money -= getProductCost(productName);
        }

        result();
    }

    private boolean isPurchasable(int money) {
        int minimumCost = Integer.MAX_VALUE;

        for (Product product : products) {
            minimumCost = Math.min(product.getPrice(), minimumCost);
        }

        if (money > minimumCost) return true;

        return false;
    }

    private int getProductCost(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName))
                return product.getPrice();
        }

        return 0;
    }

    private void result() {

    }
}
