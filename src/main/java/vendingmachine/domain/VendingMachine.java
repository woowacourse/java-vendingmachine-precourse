package vendingmachine.domain;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachine {
    private final Coins coins;
    private final Products products;

    public VendingMachine(Coins coins, Products products) {
        this.coins = coins;
        this.products = products;
    }

    public Coins getCoins() {
        return coins;
    }

    public void purchase(int money) {
        do {
            OutputView.printRemainInputMoney(money);
            Product product = products.getProduct(InputView.inputProductName());
            product.purchase(money);
            money -= product.getPrice();
        } while (canPurchase(money));
        OutputView.printRemainInputMoney(money);
    }

    private boolean canPurchase(int money) {
        return products.checkInputMoney(money) && products.checkExistAmount();
    }
}
