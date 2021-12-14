package vendingmachine;

import vendingmachine.view.InputView;

public class VendingMachine {
    private Coins coins;
    private Products products;

    public VendingMachine(Coins coins, Products products) {
        this.coins = coins;
        this.products = products;
    }

    public void purchase(int money) {
        do {
            Product product = products.getProduct(InputView.inputProductName(money));
            product.purchase(money);
            money -= product.getPrice();
        } while (canPurchase(money));
    }

    private boolean canPurchase(int money) {
        return products.checkInputMoney(money) && products.checkExistAmount();
    }
}
