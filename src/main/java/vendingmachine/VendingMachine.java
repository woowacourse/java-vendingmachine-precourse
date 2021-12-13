package vendingmachine;

import vendingmachine.exception.NotEnoughBalanceException;


public class VendingMachine {

    private int balance;

    private ProductContainer productContainer;

    private CoinContainer coinContainer;

    public VendingMachine(int balance, ProductContainer productContainer, CoinContainer coinContainer) {
        this.balance = balance;
        this.productContainer = productContainer;
        this.coinContainer = coinContainer;
    }

    public int getBalance() {
        return balance;
    }

    public void sellProduct(String productName) {
        balance -= productContainer.getPrice(productName);
        productContainer.sellProduct(productName);
    }

    public Coins returnBalance() {
        return coinContainer.returnBalance(balance);
    }

    public boolean isAllSoldOut() {
        return productContainer.isAllSoldOut();
    }

    public boolean isHavingBalanceToBuy() {
        return balance >= productContainer.getMinimumPrice();
    }
}
