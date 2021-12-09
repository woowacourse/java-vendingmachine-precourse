package vendingmachine;

import java.util.Map;

public class VendingMachine {
    private Coins coins;
    private Products products;
    private InputAmount inputAmount;

    public VendingMachine(String amount) {
        coins = new Coins(amount);
        getInitialCoins();
    }

    public void getInitialCoins() {
        View.printVendingMachineCoin(coins.getCoins());
    }

    public InputAmount getUserBalance() {
        return inputAmount;
    }

    public void getCoins() {
        View.printCoins(inputAmount, coins.exchange(inputAmount));
    }

    public void createProduct(String specification) {
        products = new Products(specification);
    }

    public void createInputAmount(String amount) {
        inputAmount =  new InputAmount(amount);
    }

    public void sell(String productName) {
        products.reduce(productName);
        inputAmount.reduce(products.getPriceByName(productName));
    }

    public boolean checkUserBalance() {
        return products.isValidAmount(inputAmount);
    }
}
