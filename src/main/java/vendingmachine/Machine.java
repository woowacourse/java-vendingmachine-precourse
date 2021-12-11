package vendingmachine;

import java.util.ArrayList;

public class Machine {
    private int money;
    private ArrayList<Product> products;
    private boolean purchasable = true;
    //private Coin coins;

    Machine() {
        Coin.makeRandom(InputView.inputMachineMoney());
        OutputView.printMachineCoin();
        this.products = InputView.inputProductList();
        this.money = InputView.inputMoney();
        while (purchasable) {
            OutputView.printMoney(money);
            this.purchasable = isPurchasable(InputView.inputProduct());
        }
    }

    public boolean isPurchasable(String productName) {
        for (Product product : this.products) {
            if (product.getName().equals(productName) && product.getPrice() >= money && product.getCount() > 0) {
                reduceMoney(product.getPrice());
                product.reduceCount();
                return true;
            }
        }
        return false;
    }

    public void reduceMoney(int reduceMoney) {
        this.money -= reduceMoney;
    }
}
