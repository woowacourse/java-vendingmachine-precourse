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

        view.showAllCoins(change);
    }

    public void buyProducts() {
        int money = view.getPurchaseMoney();

        while (isPurchasable(money)) {
            view.leftMoney(money);
            String productName = view.getProductNameToBuy(products);
            money -= productSold(productName);
        }

        view.leftMoney(money);
        view.showHoldingCoins(change);
    }

    private boolean isPurchasable(int money) {
        int minimumCost = Integer.MAX_VALUE;

        for (Product product : products) {
            minimumCost = Math.min(product.getPrice(), minimumCost);
        }

        if (money > minimumCost) return true;

        return false;
    }

    private int productSold(String productName) {
        for (Product productOfMenu : products) {
            if (productOfMenu.getName().equals(productName)) {
                productOfMenu.sold();
                return productOfMenu.getPrice();
            }
        }

        return -1;
    }

}
