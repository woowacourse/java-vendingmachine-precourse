package vendingmachine;

import java.util.ArrayList;

public class Machine {
    private int money;
    private ArrayList<Product> products;
    //private Coin coins;

    Machine() {
        Coin.makeRandom(InputView.inputMachineMoney());
        OutputView.printMachineCoin();
        this.products = InputView.inputProductList();
        this.money = InputView.inputMoney();
        while (true) {
            OutputView.printMoney(money);
            InputView.inputProduct();
        }
    }

    public boolean isPurchasable(String productName) {
        for (Product product : this.products) {
            if (product.getName().equals(productName) && product.getPrice() >= money && product.getCount() > 0) {
                return true;
            }
        }
        return false;
    }
}
