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
        Product product;

        product = productContainer.getProduct(productName);

        if (balance < product.getPrice()) {
            throw new NotEnoughBalanceException(ErrorMessage.NOT_ENOUGH_BALANCE.getCompleteMessage());
        }

        balance -= product.getPrice();
        product.sell();
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
