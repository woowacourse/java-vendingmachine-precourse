package vendingmachine.controller;

import vendingmachine.repository.Coins;
import vendingmachine.repository.InputAmount;
import vendingmachine.repository.Products;
import view.View;

public class VendingMachine {
    private final Coins coins;
    private Products products;
    private InputAmount inputAmount;

    public VendingMachine(String amount) {
        coins = new Coins(amount);
        getInitialCoins();
    }

    public void getInitialCoins() {
        View.printInitialCoins(coins.getCoins());
    }

    public int getUserBalance() {
        return inputAmount.getAmount();
    }

    public void getCoins() {
        View.printCoins(inputAmount.getAmount(), coins.exchange(inputAmount.getAmount()));
    }

    public void registerProduct(String specification) {
        products = new Products(specification);
    }

    public void receiveInputAmount(String amount) {
        inputAmount =  new InputAmount(amount);
    }

    public void sell(String productName) {
        products.reduceQuantityByName(productName);
        inputAmount.reduce(products.getPriceByName(productName));
    }

    public boolean canBuyProduct() {
        return products.isValidAmount(inputAmount.getAmount());
    }

    public void checkIsValidProductName(String name) {
        products.findByName(name);
    }
}
