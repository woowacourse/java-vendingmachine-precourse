package vendingmachine;

import java.util.ArrayList;

public class Machine {
    private static int money;
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
            if (!checkMoney() || !checkCount()) {
                break;
            }
            this.purchasable = isPurchasable(InputView.inputBuyProduct(products));
        }
        OutputView.printChanges();
    }

    public boolean isPurchasable(String productName) {
        for (Product product : this.products) {
            if (product.getName().equals(productName) && product.getPrice() <= money && product.getCount() > 0) {
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

    public static int makeChanges(Coin coin) {
        int changes = money / coin.getAmount();
        if (changes != 0) {
            if (coin.getCount() - changes >= 0) {
                return changes;
            }
            if (coin.getCount() - changes < 0) {
                return coin.getCount();
            }
        }
        return 0;
    }

    public boolean checkMoney() {
        for (Product product : this.products) {
            if (product.getPrice() <= money) {
                return true;
            }
        }
        return false;
    }

    public boolean checkCount() {
        for (Product product : this.products) {
            if (product.getCount() != 0) {
                return true;
            }
        }
        return false;
    }
}
